package com.loayza.clinica.model;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
@ToString
@Table(name = "medico")
@Entity
public class Medico {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_doctor;


    private String nombre;

    private String especialidad;

    private Integer colegiatura;


}
