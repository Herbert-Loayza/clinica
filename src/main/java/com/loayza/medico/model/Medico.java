package com.loayza.medico.model;


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
    private Integer id;


    private String nombre;

    private String especialidad;

    private String colegiatura;


}
