package com.riwi.performancetest.Users.Application;

import com.riwi.performancetest.Users.Domain.User;
import com.riwi.performancetest.Users.Domain.UserRepository;
import com.riwi.performancetest.Users.Infrastructure.Dtos.AuthRequestDto;
import com.riwi.performancetest.Users.Infrastructure.Dtos.AuthResponseDto;
import com.riwi.performancetest.Users.Mapper.MapperUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AuthService implements IAuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MapperUser mapperUser;

    @Transactional
    @Override
    public AuthResponseDto Register(AuthRequestDto authResponseDto) {

        if (userRepository.findByUsername(authResponseDto.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        String encodedPassword = passwordEncoder.encode(authResponseDto.getPassword());

        // Crear un nuevo usuario a partir del DTO, pasando solo el DTO
        User user = mapperUser.userDtoToUser(authResponseDto); // Aquí solo pasas el DTO

        // Asignar la contraseña encriptada
        user.setPassword(encodedPassword);
        user.setFirstName(authResponseDto.getFirstName());


        // Guardar el usuario y mapearlo a UserResponseDto
        return mapperUser.userToUserDto(userRepository.save(user));

    }

}
