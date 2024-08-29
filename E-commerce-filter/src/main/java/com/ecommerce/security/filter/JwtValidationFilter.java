package com.ecommerce.security.filter;

import com.ecommerce.security.SimpleGrantedAuthorityJsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import static com.ecommerce.security.TokenJwtConfig.*;


import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class JwtValidationFilter extends BasicAuthenticationFilter {

    //    Desde la clase SpringSecurityConfig pasamos el authenticationManager
    public JwtValidationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        System.out.println("-------------------------------------- constructor de JwtValidationFilter  --------------------");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        capturar la cabecera authorization
        String header = request.getHeader(HEADER_AUTHORIZATION);
//        validar si es una ruta publica ya que no tendria el token
        if (header == null || !header.startsWith(PREFIX_TOKEN)){
            chain.doFilter(request, response);
            return;
        }

//        obtener el token del encabezado
        String token = header.replace(PREFIX_TOKEN, "");
        System.out.println("----------------------------------------------------------------- imprimir token");
        System.out.println(token);
        try {
//            Validar el token con la llave que tenemos y obtenemos los datos que trae el token a travez del metodo getPayload()
            Claims claims = Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token).getPayload();
            String username = claims.getSubject();
            Object authoritiesClaims = claims.get("authorities");

//            Convertir los roles a la clase GrantedAuthority SimpleGrantedAuthority. es un Collection porque se suelen tener muchos roles
            Collection<? extends GrantedAuthority> authorities = Arrays.asList(
                    new ObjectMapper()
                            .addMixIn(SimpleGrantedAuthority.class, SimpleGrantedAuthorityJsonCreator.class)
                            .readValue(authoritiesClaims.toString().getBytes(), SimpleGrantedAuthority[].class));
            /*
                la clase  SimpleGrantedAuthority recibe en el constructor un parametro llamado role, pero para nosotros ese parametro se llama
                authorities, por eso debemos usar el metodo addMixIn, para transformar lo que se pasa por el constructor
            */

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
            // autenticarnos
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            chain.doFilter(request, response);
        }catch (JwtException e){
            Map<String, String> body = new HashMap<>();
            body.put("error", e.getMessage());
            body.put("message", "El token JWT no es valido, clase JwtValidationFilter");
            response.getWriter().write(new ObjectMapper().writeValueAsString(body));
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType(CONTENT_TYPE);
        }
    }
}

