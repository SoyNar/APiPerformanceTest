package com.riwi.performancetest.Users.Infrastructure.Dtos;

import com.riwi.performancetest.Users.Application.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/register")
//    @Operation(
//            summary = "Create a new user.",
//            description = "Allows the registration of a new user by providing the necessary details.")
    public ResponseEntity<AuthResponseDto> register(@RequestBody AuthRequestDto userDto) {
        try {
            AuthResponseDto createdUser = authService.Register(userDto);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

}
