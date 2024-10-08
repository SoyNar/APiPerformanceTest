package com.riwi.performancetest.Palets.Application.Service;

import com.riwi.performancetest.Palets.Application.IPaletService;
import com.riwi.performancetest.Palets.Domain.LoadEntity;
import com.riwi.performancetest.Palets.Domain.Palets;
import com.riwi.performancetest.Palets.Infrastructure.DTos.Request.RequestPalet;
import com.riwi.performancetest.Palets.Infrastructure.DTos.Response.ResponsePalet;
import com.riwi.performancetest.Palets.Infrastructure.IPaletRepositorry;
import com.riwi.performancetest.Users.Domain.User;
import com.riwi.performancetest.Users.Domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PalletServiceImpl implements IPaletService {

    @Autowired
    private IPaletRepositorry paletRepositorry;

    @Autowired
    private UserRepository userRepository;



    @Override
    public List<Palets> readAll() {
        return this.paletRepositorry.findAll();
    }

    @Override
    public RequestPalet readById(Long aLong) {
        return null;
    }

    @Override
    public ResponsePalet save(RequestPalet requestPalet) {
        // Crear una nueva instancia de Palet
        Palets palet = Palets.builder()
                .location(requestPalet.getLocation())
                .capacity(requestPalet.getCapacity())
                .state(requestPalet.getState())
                .build();

        // Asignar el usuario por nombre
        User user = userRepository.findByUsername(requestPalet.getUser())
                .orElseThrow(() -> new RuntimeException("User not found"));
        palet.setUser(user);

        // Asignar la lista de cargas al palet
        List<LoadEntity> loads = new ArrayList<>();
        for (LoadEntity cargaRequest : requestPalet.getLoadEntity()) {
            LoadEntity carga = LoadEntity.builder()
                    .weight(cargaRequest.getWeight())
                    .palets(palet) // Establecer el palet asociado
                    .build();
            loads.add(carga);
        }
        palet.setLoadEntity(loads);

        // Guardar el palet en la base de datos
        Palets savedPalet = paletRepositorry.save(palet);

        // Devolver el DTO de respuesta
        return ResponsePalet.builder()
                .state(savedPalet.getState())
                .location(savedPalet.getLocation())
                .capacity(savedPalet.getCapacity())
                .build();

    }


    @Override
    public void disabled(Long id) {
        this.paletRepositorry.deleteById(id);

    }

    @Override
    public Palets update(Long id, RequestPalet paletDTo) {
        return null;
    }

    @Override
    public Palets update(Long aLong) {
        return null;
    }
}
