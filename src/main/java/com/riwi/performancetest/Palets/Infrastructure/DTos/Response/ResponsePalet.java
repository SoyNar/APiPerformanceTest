package com.riwi.performancetest.Palets.Infrastructure.DTos.Response;

import com.riwi.performancetest.Palets.Domain.LoadEntity;
import com.riwi.performancetest.Palets.Domain.State;
import com.riwi.performancetest.Users.Domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ResponsePalet {

    private int capacity;
    private String location;
    private State state;
    private User user;
    private List<LoadEntity> loadEntity;
}
