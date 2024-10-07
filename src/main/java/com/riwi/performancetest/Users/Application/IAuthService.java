package com.riwi.performancetest.Users.Application;

import com.riwi.performancetest.Commont.Infraestructure.Persistence.CRUD.RegisterAuth;
import com.riwi.performancetest.Users.Infrastructure.Dtos.AuthRequestDto;
import com.riwi.performancetest.Users.Infrastructure.Dtos.AuthResponseDto;

public interface IAuthService extends RegisterAuth<AuthRequestDto, AuthResponseDto> {
}
