package com.riwi.performancetest.Users.Infrastructure.Dtos;

import com.riwi.performancetest.Users.Domain.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthRequestDto {
    @NotBlank
    private String firstName;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private Role role;
}
