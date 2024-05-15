package com.quizcontext.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/*
## Validations ##
   *Email must Contain At least One Uppercase and Lowercase alphabets,number,Special Character and length must between 8-15.
   *UserName size must between 5 to 10 Character.
*/

public record UserRequest(
    Boolean is_active,
    @NotBlank
        @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email format")
        String email,
    @NotBlank
        @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
            message = "Password is not valid")
        String password,
    @NotBlank @Size(min = 5, max = 10, message = "must between 5-10 char") String userName) {}
