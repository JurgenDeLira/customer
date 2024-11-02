package org.ms.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CustomerDto(
        Long id,

        @NotBlank
        @Size(min = 2, max = 50)
        String name,

        @Email
        @NotBlank
        String email,

        @Size(max = 20)
        String phone
){}
