package com.riwi.performancetest.Palets.Infrastructure.DTos.Request;

import com.riwi.performancetest.Palets.Domain.LoadEntity;
import com.riwi.performancetest.Palets.Domain.State;
import com.riwi.performancetest.Users.Domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Builder
public class RequestPalet {
    @NotNull
    private int capacity;
    @NotBlank
    private String location;
    @NotBlank
    private State state;
    @NotBlank
    private String user;
    @NotBlank
    @NotNull
    private List<LoadEntity> loadEntity;
}
