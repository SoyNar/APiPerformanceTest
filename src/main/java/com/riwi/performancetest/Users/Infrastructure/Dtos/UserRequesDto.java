package com.riwi.performancetest.Users.Infrastructure.Dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRequesDto {
    private String fullname;
    private String username;
}
