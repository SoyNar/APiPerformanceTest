package com.riwi.performancetest.Users.Application.Dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthResponseDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
