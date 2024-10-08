package com.riwi.performancetest.Palets.Application.Service;

import com.riwi.performancetest.Commont.Infraestructure.Persistence.CRUD.ReadAll;
import com.riwi.performancetest.Commont.Infraestructure.Persistence.CRUD.ReadById;
import com.riwi.performancetest.Commont.Infraestructure.Persistence.CRUD.Save;
import com.riwi.performancetest.Palets.Domain.LoadEntity;
import com.riwi.performancetest.Palets.Infrastructure.DTos.Request.LoadRequesDTo;
import com.riwi.performancetest.Palets.Infrastructure.DTos.Response.LoadResponseDto;

public interface ILoadService extends ReadAll<LoadEntity>, ReadById<LoadEntity, Long> , Save<LoadRequesDTo, LoadResponseDto> {
}
