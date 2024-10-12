package com.validate.validate.domain.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDto (
        @NotNull(message = "The name user can't null!")
        @Size(min = 3, message = "The length name must be greather than 3", max = 8)
         String name,
        @NotNull(message = "The email of user can't null!")
        @Email(message = "Send a e-mail valid please!")
        String email,
        @NotNull( message = "The last of user can't null!")
        @Size(min = 3, message = "The length lastName must be greather than 3", max = 8)
        String lastName
){}
