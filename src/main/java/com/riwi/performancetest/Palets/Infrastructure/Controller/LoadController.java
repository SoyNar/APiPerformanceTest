package com.riwi.performancetest.Palets.Infrastructure.Controller;

import com.riwi.performancetest.Palets.Application.Service.ILoadService;
import com.riwi.performancetest.Palets.Domain.LoadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
     private ILoadService loadService;

    @GetMapping
    public ResponseEntity<List<LoadEntity>> findLoad(){
        List<LoadEntity> loads = loadService.readAll();
        return ResponseEntity.status(HttpStatus.OK).body(loads);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoadEntity> getLoadById(@PathVariable Long id) {
        LoadEntity load = loadService.readById(id);
        return ResponseEntity.ok(load);
    }


}
