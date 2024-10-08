package com.riwi.performancetest.Users.Mapper;

import com.riwi.performancetest.Users.Domain.User;
import com.riwi.performancetest.Users.Infrastructure.Dtos.AuthRequestDto;
import com.riwi.performancetest.Users.Infrastructure.Dtos.AuthResponseDto;
import org.springframework.stereotype.Component;
@Component
public class MapperUser {



        public AuthResponseDto userToUserDto(User user) {
            return AuthResponseDto.builder()
                    .fullname(user.getFirstName())
                    .username(user.getUsername())
                    .build();
        }

        public User userDtoToUser(AuthRequestDto userRequestDto) {
            return User.builder()
                    .firstName(userRequestDto.getFirstName())
                    .username(userRequestDto.getUsername())
                    .password(userRequestDto.getPassword())
                    .role(userRequestDto.getRole())
                    .build();
        }

}
