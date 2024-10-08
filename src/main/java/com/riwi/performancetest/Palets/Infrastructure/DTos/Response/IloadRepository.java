package com.riwi.performancetest.Palets.Infrastructure.DTos.Response;

import com.riwi.performancetest.Palets.Domain.LoadEntity;
import lombok.Lombok;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IloadRepository extends JpaRepository<LoadEntity, Long> {
}
