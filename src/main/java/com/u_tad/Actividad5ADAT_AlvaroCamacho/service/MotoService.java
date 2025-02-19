package com.u_tad.Actividad5ADAT_AlvaroCamacho.service;

import com.u_tad.Actividad5ADAT_AlvaroCamacho.model.Moto;
import com.u_tad.Actividad5ADAT_AlvaroCamacho.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoService {

    @Autowired
    MotoRepository motoRepository;

    //Métodos CRUD
    public Moto saveOrUpdateBike(Moto moto) {
        return motoRepository.save(moto);
    }

    public List<Moto> getBikes(){
        return motoRepository.findAll();
    }

    public Optional<Moto> getBikeById(int id){
        return motoRepository.findById(id);
    }

    public void deleteBike(int id) {
        motoRepository.deleteById(id);
    }

    //Obtener las motos de una marca
    public List<Moto> getBikesByBrand(String brand){
        return motoRepository.findByBrandContainingIgnoreCase(brand);
    }

    //Obtener las motos que se ajusten a un presupuesto
    public List<Moto> getBikesByBudget(int price){
        return motoRepository.findByPriceLessThan(price);
    }
}
