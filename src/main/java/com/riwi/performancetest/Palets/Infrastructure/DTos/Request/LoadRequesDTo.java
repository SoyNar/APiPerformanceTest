package com.riwi.performancetest.Palets.Infrastructure.DTos.Request;

import com.riwi.performancetest.Palets.Domain.Palets;
import com.riwi.performancetest.Palets.Domain.StateLoad;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoadRequesDTo {

    private Long idPalet;
    @NotBlank
    private  int weight;
    @NotBlank
    private int dimensions;
    @NotBlank
    private StateLoad stateLoad;


}
