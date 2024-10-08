package com.riwi.performancetest.Palets.Application;

import com.riwi.performancetest.Commont.Infraestructure.Persistence.CRUD.*;
import com.riwi.performancetest.Palets.Domain.Palets;
import com.riwi.performancetest.Palets.Infrastructure.DTos.Request.RequestPalet;
import com.riwi.performancetest.Palets.Infrastructure.DTos.Response.ResponsePalet;
import lombok.extern.java.Log;

public interface IPaletService extends
        Save<RequestPalet, ResponsePalet>,
        ReadById<RequestPalet,Long>,
        ReadAll<Palets>, Update<Palets,Long>, Disabled<Long> {
    Palets update(Long id, RequestPalet paletDTo);
}
