package com.riwi.performancetest.Palets.Application.Service;

import com.riwi.performancetest.Palets.Domain.LoadEntity;
import com.riwi.performancetest.Palets.Domain.Palets;
import com.riwi.performancetest.Palets.Infrastructure.DTos.Request.LoadRequesDTo;
import com.riwi.performancetest.Palets.Infrastructure.DTos.Response.IloadRepository;
import com.riwi.performancetest.Palets.Infrastructure.DTos.Response.LoadResponseDto;
import com.riwi.performancetest.Palets.Infrastructure.IPaletRepositorry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadServiceImpl implements ILoadService{

    @Autowired
    IloadRepository loadRepository;

    @Autowired
    private IPaletRepositorry paletRepository;
    @Override
    public List<LoadEntity> readAll() {
        return this.loadRepository.findAll();
    }

    @Override
    public LoadEntity readById(Long id) {
        return loadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Load not found with id: " + id));
    }


    @Override
    public LoadResponseDto save(LoadRequesDTo loadRequesDTo) {

            // Buscar el palet al que se asignará la carga
            Palets palet = paletRepository.findById(loadRequesDTo.getIdPalet())
                    .orElseThrow(() -> new RuntimeException("Pallet not found with id: " + loadRequesDTo.getIdPalet()));

            // Crear la nueva carga
            LoadEntity newLoad = LoadEntity.builder()
                    .weight(loadRequesDTo.getWeight())
                    .stateLoad(loadRequesDTo.getStateLoad())
                    .palets(palet) // Asignar el palet
                    .build();

            // Guardar la carga
            LoadEntity savedLoad = loadRepository.save(newLoad);

            // Devolver el DTO de respuesta
            return mapToResponseDTO(savedLoad);
    }

    private LoadResponseDto mapToResponseDTO(LoadEntity loadEntity) {
        return LoadResponseDto.builder()
                .weight(loadEntity.getWeight())
                .build();
    }
}
