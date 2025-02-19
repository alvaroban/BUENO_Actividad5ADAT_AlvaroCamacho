package com.u_tad.Actividad5ADAT_AlvaroCamacho.controller;

import com.u_tad.Actividad5ADAT_AlvaroCamacho.model.Moto;
import com.u_tad.Actividad5ADAT_AlvaroCamacho.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newMoto);
    }

    @GetMapping
    public ResponseEntity<List<Moto>> getAll() {
        List<Moto> allMotos = motoService.getBikes();
        return ResponseEntity.ok(allMotos);
    }

    @GetMapping("/{idMoto}")
    public ResponseEntity<Optional<Moto>> getById(@PathVariable int idMoto) {
        Optional<Moto> moto = motoService.getBikeById(idMoto);
        if (moto.isPresent()) {
            return ResponseEntity.ok(moto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/searchBrand")
    public ResponseEntity<List<Moto>> getByBrand(@RequestParam String brand) {
        List<Moto> motosMarcas = motoService.getBikesByBrand(brand);
        if (motosMarcas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(motosMarcas);
    }

    @DeleteMapping("/{idMoto}")
    public void deleteBike(@PathVariable int idMoto) {
        motoService.deleteBike(idMoto);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Moto>> getByBudget(@RequestParam int price){
        List<Moto> affordableBikes = motoService.getBikesByBudget(price);
        if (affordableBikes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(affordableBikes);
    }
}
