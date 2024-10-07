package com.riwi.performancetest.Commont.Infraestructure.Persistence.CRUD;

public interface RegisterAuth <RequestDto, ResponseDto>{
    public ResponseDto Register(RequestDto requestDto);
}
