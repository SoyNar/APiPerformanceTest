package com.riwi.performancetest.Commont.Infraestructure.Persistence.CRUD;

public interface ReadById <ResponseEntity, ID>{
    public ResponseEntity readById(ID id);
}
