package com.u_tad.Actividad5ADAT_AlvaroCamacho.controller;

import com.u_tad.Actividad5ADAT_AlvaroCamacho.model.Moto;
import com.u_tad.Actividad5ADAT_AlvaroCamacho.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/motos")
public class MotoController {

    private final MotoService motoService;

    @Autowired
    public MotoController(MotoService motoService) {
        this.motoService = motoService;
    }

    @PostMapping
    public ResponseEntity<Moto> save(@RequestBody Moto moto){
        Moto newMoto = motoService.saveOrUpdateBike(moto);
        //return ResponseEntity.status(HttpStatus.ACCEPTED).body(newMoto);
        return ResponseEntity.ok(newMoto);
    }

    @GetMapping
    public ResponseEntity<List<Moto>> getAll() {
        List<Moto> allMotos = motoService.getBikes();
        return ResponseEntity.ok(allMotos);
    }

    private void hola() {
        System.out.println("Hola");
    }

}
