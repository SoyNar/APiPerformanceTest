package com.riwi.performancetest.Users.Infrastructure.Dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthResponseDto {

    private String fullname;

    private String username;

    private String password;
}
