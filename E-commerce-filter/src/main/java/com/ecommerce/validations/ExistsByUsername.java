package com.ecommerce.validations;

import javax.validation.Payload;

public @interface ExistsByUsername {
    String message() default "El usuario ya existe en la DB";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
