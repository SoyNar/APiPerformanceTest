package com.riwi.performancetest.Palets.Infrastructure.DTos.Response;

import com.riwi.performancetest.Palets.Domain.Palets;
import com.riwi.performancetest.Palets.Domain.StateLoad;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoadResponseDto {

    private  int weight;
    private int dimensions;
    private StateLoad stateLoad;
    private Palets palets;
}
