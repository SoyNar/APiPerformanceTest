package com.riwi.performancetest.Commont.Infraestructure.Persistence.CRUD;

public interface Update <Entitity,ID>{
    public Entitity update(ID id);
}
