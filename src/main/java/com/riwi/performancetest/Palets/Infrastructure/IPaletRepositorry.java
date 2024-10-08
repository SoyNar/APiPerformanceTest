package com.riwi.performancetest.Palets.Infrastructure;

import com.riwi.performancetest.Palets.Domain.Palets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaletRepositorry extends JpaRepository<Palets,Long> {
}
