package com.riwi.performancetest.Users.Application.Dto;

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
    private String usarname;
    @NotBlank
    private String password;
}
