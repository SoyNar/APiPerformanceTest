package com.riwi.performancetest.Commont.Infraestructure.Persistence.CRUD;

public interface Save <EntityRequest,EntityResponse> {
    public EntityResponse save(EntityRequest entityRequest);
}
