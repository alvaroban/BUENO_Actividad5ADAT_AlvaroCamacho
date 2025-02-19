package com.u_tad.Actividad5ADAT_AlvaroCamacho.repository;

import com.u_tad.Actividad5ADAT_AlvaroCamacho.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Integer> {

    List<Moto> findByBrandContainingIgnoreCase(String brand);
    List<Moto> findByPriceLessThan(int price);
}
