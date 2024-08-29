<<<<<<< HEAD
-- ESPAÑOL

DROP DATABASE IF EXISTS ecommerce;
CREATE DATABASE ecommerce;
USE ecommerce;

CREATE TABLE gama_producto(
    id INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    descripcion TEXT NULL,
    imagen VARCHAR(256) NULL,
    CONSTRAINT PK_gama_producto PRIMARY KEY (id)
)ENGINE = InnoDB;

CREATE TABLE estado(
    id INT AUTO_INCREMENT NOT NULL,
    nombre_estado VARCHAR(20) NOT NULL,
    CONSTRAINT PK_estado PRIMARY KEY(id)
)ENGINE = InnoDB;

CREATE TABLE metodo_pago(
    id INT AUTO_INCREMENT NOT NULL,
    nombre_metodo VARCHAR(15),
    CONSTRAINT PK_metodo_pago PRIMARY KEY(id)
)ENGINE = InnoDB;

CREATE TABLE ciudad(
    id INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    CONSTRAINT PK_ciudad PRIMARY KEY (id)
)ENGINE = InnoDB;

CREATE TABLE direccion(
    id INT AUTO_INCREMENT NOT NULL,
    linea_direccion1 VARCHAR(50) NOT NULL,
    linea_direccion2 VARCHAR(50) NULL,
    codigo_ciudad_d INT(10) NOT NULL,
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT FK_direccion_ciudad FOREIGN KEY (codigo_ciudad_d) REFERENCES ciudad(id)
)ENGINE = InnoDB;

CREATE TABLE oficina(
    id INT AUTO_INCREMENT NOT NULL,
    codigo_direccion_o INT(10) NOT NULL,
    CONSTRAINT PK_oficina PRIMARY KEY (id),
    CONSTRAINT FK_oficina_direccion FOREIGN KEY (codigo_direccion_o) REFERENCES direccion(id)
)ENGINE = InnoDB;

CREATE TABLE empleado(
    id INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido1 VARCHAR(50) NOT NULL,
    apellido2 VARCHAR(50) NULL,
    email VARCHAR(100) NOT NULL,
    codigo_oficina INT(10) NULL,
    CONSTRAINT PK_emplado PRIMARY KEY(id),
    CONSTRAINT PK_empleado_oficina FOREIGN KEY (codigo_oficina) REFERENCES oficina(id)
)ENGINE = InnoDB;

CREATE TABLE cliente(
    id INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    primer_apellido VARCHAR(30),
    segundo_apellido VARCHAR(30),
    email VARCHAR(50),
    codigo_ciudad_c INT(10) NOT NULL,
    codigo_direccion_c INT(10) NOT NULL,
    codigo_empleado_rep_ventas INT(10) NULL,
    CONSTRAINT PK_cliente PRIMARY KEY(id),
    CONSTRAINT FK_cliente_ciudad FOREIGN KEY (codigo_ciudad_c) REFERENCES ciudad(id),
    CONSTRAINT FK_cliente_direccion FOREIGN KEY (codigo_direccion_c) REFERENCES direccion(id),
    CONSTRAINT FK_cliente_empleado_rep FOREIGN KEY (codigo_empleado_rep_ventas) REFERENCES empleado(id)
)ENGINE = InnoDB;

CREATE TABLE telefono (
  id INT AUTO_INCREMENT NOT NULL,
  numero BIGINT NOT NULL,
  codigo_cliente_te INT(10) NULL,
  codigo_oficina_te INT(10) NULL,
  CONSTRAINT PK_telefono PRIMARY KEY (id),
  CONSTRAINT FK_telefono_cliente FOREIGN KEY (codigo_cliente_te) REFERENCES cliente(id),
  CONSTRAINT FK_telefono_oficina FOREIGN KEY (codigo_oficina_te) REFERENCES oficina(id)
)ENGINE = InnoDB;

CREATE TABLE pago(
    id INT AUTO_INCREMENT NOT NULL,
    fecha_pago DATE NOT NULL,
    total DOUBLE NOT NULL,
    codigo_metodo_pago INT(10) NOT NULL,
    codigo_cliente_pa INT(10) NOT NULL,
    CONSTRAINT PK_pago PRIMARY KEY (id),
    CONSTRAINT FK_pago_metodoPago FOREIGN KEY (codigo_metodo_pago) REFERENCES metodo_pago(id),
    CONSTRAINT FK_pago_cliente FOREIGN KEY (codigo_cliente_pa) REFERENCES cliente(id)
)ENGINE = InnoDB;

CREATE TABLE pedido(
    id INT AUTO_INCREMENT NOT NULL,
    fecha_pedido DATE NOT NULL,
    fecha_esperado DATE NOT NULL,
    fecha_entrega DATE NULL,
    comentario TEXT NULL,
    codigo_client_pedido INT(10) NOT NULL,
    codigo_estado_pedido INT(10) NOT NULL,
    CONSTRAINT PK_pedido PRIMARY KEY(id),
    CONSTRAINT FK_pedido_cliente FOREIGN KEY (codigo_client_pedido) REFERENCES cliente(id),
    CONSTRAINT FK_pedido_estado FOREIGN KEY (codigo_estado_pedido) REFERENCES estado(id)
)ENGINE = InnoDB;

CREATE TABLE producto(
    id INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(70) NOT NULL,
    cantidad_stock TINYINT NOT NULL,
    precio_venta DOUBLE NOT NULL,
    precio_proveedor DOUBLE NOT NULL,
    descripcion_producto TEXT NULL,
    codigo_gama INT(10) NOT NULL,
    dimension VARCHAR(255) NULL,
    CONSTRAINT PK_producto PRIMARY KEY (id),
    CONSTRAINT FK_producto_gama FOREIGN KEY (codigo_gama) REFERENCES gama_producto(id)
)ENGINE = InnoDB;

CREATE TABLE detalle_pedido(
    id_producto_pedido INT NOT NULL,
    id_pedido_producto INT NOT NULL,
    cantidad SMALLINT NOT NULL,
    precio_unidad DOUBLE NULL,
    numero_linea SMALLINT NULL,
    PRIMARY KEY (id_producto_pedido, id_pedido_producto),
    CONSTRAINT FK_producto_pedido FOREIGN KEY (id_producto_pedido) REFERENCES producto(id),
    CONSTRAINT FK_pedido_producto FOREIGN KEY (id_pedido_producto) REFERENCES pedido(id)
)ENGINE = InnoDB;

--

-- INGLES
DROP DATABASE IF EXISTS ecommerce;
CREATE DATABASE ecommerce;
USE ecommerce;

CREATE TABLE product_range (
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL,
    description TEXT NULL,
    image VARCHAR(256) NULL,
    CONSTRAINT PK_product_range PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE status (
    id INT AUTO_INCREMENT NOT NULL,
    state_name VARCHAR(20) NOT NULL,
    CONSTRAINT PK_state PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE payment_method (
    id INT AUTO_INCREMENT NOT NULL,
    method_name VARCHAR(15),
    CONSTRAINT PK_payment_method PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE city (
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(30) NOT NULL,
    CONSTRAINT PK_city PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE address (
    id INT AUTO_INCREMENT NOT NULL,
    address_line1 VARCHAR(50) NOT NULL,
    address_line2 VARCHAR(50) NULL,
    city_code_d INT(10) NOT NULL,
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT FK_address_city FOREIGN KEY (city_code_d) REFERENCES city(id)
) ENGINE = InnoDB;

CREATE TABLE office (
    id INT AUTO_INCREMENT NOT NULL,
    address_code_o INT(10) NOT NULL,
    CONSTRAINT PK_office PRIMARY KEY (id),
    CONSTRAINT FK_office_address FOREIGN KEY (address_code_o) REFERENCES address(id)
) ENGINE = InnoDB;

CREATE TABLE employee (
    id INT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name1 VARCHAR(50) NOT NULL,
    last_name2 VARCHAR(50) NULL,
    email VARCHAR(100) NOT NULL,
    office_code INT(10) NULL,
    CONSTRAINT PK_employee PRIMARY KEY (id),
    CONSTRAINT FK_employee_office FOREIGN KEY (office_code) REFERENCES office(id)
) ENGINE = InnoDB;

CREATE TABLE customer (
    id INT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name1 VARCHAR(30),
    last_name2 VARCHAR(30),
    email VARCHAR(50),
    city_code_c INT(10) NOT NULL,
    address_code_c INT(10) NOT NULL,
    sales_rep_employee_code INT(10) NULL,
    CONSTRAINT PK_customer PRIMARY KEY (id),
    CONSTRAINT FK_customer_city FOREIGN KEY (city_code_c) REFERENCES city(id),
    CONSTRAINT FK_customer_address FOREIGN KEY (address_code_c) REFERENCES address(id),
    CONSTRAINT FK_customer_sales_rep FOREIGN KEY (sales_rep_employee_code) REFERENCES employee(id)
) ENGINE = InnoDB;

CREATE TABLE phone (
    id INT AUTO_INCREMENT NOT NULL,
    number BIGINT NOT NULL,
    customer_code_ph INT(10) NULL,
    office_code_ph INT(10) NULL,
    CONSTRAINT PK_phone PRIMARY KEY (id),
    CONSTRAINT FK_phone_customer FOREIGN KEY (customer_code_ph) REFERENCES customer(id),
CONSTRAINT FK_phone_office FOREIGN KEY (office_code_ph) REFERENCES office(id)
) ENGINE = InnoDB;

CREATE TABLE payment (
    id INT AUTO_INCREMENT NOT NULL,
    payment_date DATE NOT NULL,
    total DOUBLE NOT NULL,
    payment_method_code INT(10) NOT NULL,
    customer_code_pa INT(10) NOT NULL,
    CONSTRAINT PK_payment PRIMARY KEY (id),
    CONSTRAINT FK_payment_method FOREIGN KEY (payment_method_code) REFERENCES payment_method(id),
    CONSTRAINT FK_payment_customer FOREIGN KEY (customer_code_pa) REFERENCES customer(id)
) ENGINE = InnoDB;

CREATE TABLE n_order (
    id INT AUTO_INCREMENT NOT NULL,
    order_date DATE NOT NULL,
    expected_date DATE NOT NULL,
    delivery_date DATE NULL,
    comment TEXT NULL,
    customer_code_or INT(10) NOT NULL,
    status_code_or INT(10) NOT NULL,
    CONSTRAINT PK_order PRIMARY KEY (id),
    CONSTRAINT FK_order_customer FOREIGN KEY (customer_code_or) REFERENCES customer(id),
    CONSTRAINT FK_order_status FOREIGN KEY (status_code_or) REFERENCES status(id)
) ENGINE = InnoDB;

CREATE TABLE product (
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(70) NOT NULL,
    stock_quantity TINYINT NOT NULL,
    sale_price DOUBLE NOT NULL,
--     supplier_price DOUBLE NOT NULL,
    product_description TEXT NULL,
    range_code INT(10) NOT NULL,
    dimensions VARCHAR(255) NULL,
    CONSTRAINT PK_product PRIMARY KEY (id),
    CONSTRAINT FK_product_range FOREIGN KEY (range_code) REFERENCES product_range(id)
) ENGINE = InnoDB;

CREATE TABLE order_detail (
    product_id_order INT NOT NULL,
    order_id_product INT NOT NULL,
    quantity SMALLINT NOT NULL,
    unit_price DOUBLE NULL,
--     line_number SMALLINT NULL,
    PRIMARY KEY (product_id_order, order_id_product),
    CONSTRAINT FK_product_order FOREIGN KEY (product_id_order) REFERENCES product(id),
    CONSTRAINT FK_order_product FOREIGN KEY (order_id_product) REFERENCES n_order(id)
) ENGINE = InnoDB;