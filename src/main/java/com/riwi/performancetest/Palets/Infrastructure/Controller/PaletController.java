package com.riwi.performancetest.Palets.Infrastructure.Controller;
import com.riwi.performancetest.Palets.Application.IPaletService;
import com.riwi.performancetest.Palets.Domain.Palets;
import com.riwi.performancetest.Palets.Infrastructure.DTos.Request.RequestPalet;
import com.riwi.performancetest.Palets.Infrastructure.DTos.Response.ResponsePalet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/palets")
public class PaletController {

    @Autowired
    IPaletService paletService;

    @GetMapping
    public ResponseEntity<List<Palets>> findPalet(){
     return ResponseEntity.status(HttpStatus.OK).body(paletService.readAll());
    }

    @PostMapping("/created")
    public ResponseEntity<ResponsePalet> createPalet(RequestPalet requestPalet){
        ResponsePalet resposePaletDto = this.paletService.save(requestPalet);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposePaletDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePalet(@PathVariable Long id) {
        paletService.disabled(id);
        return ResponseEntity.noContent().build();
    }
}
