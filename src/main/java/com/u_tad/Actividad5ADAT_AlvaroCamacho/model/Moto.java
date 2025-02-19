package com.u_tad.Actividad5ADAT_AlvaroCamacho.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Entity
@Table(name= "motos")
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private int displacement;
    private double power;
    private double torque;
    private String year;
    private String type;
    private int price;

    public Moto() {};

}
