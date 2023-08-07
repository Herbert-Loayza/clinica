package com.loayza.clinica.service;


import com.loayza.clinica.model.Medico;
import com.loayza.clinica.repository.MedicoRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    private final MedicoRespository medicoRespository;

    public MedicoService(MedicoRespository medicoRespository) {
        this.medicoRespository = medicoRespository;
    }


    public List<Medico>getAllMedicos(){
        return medicoRespository.findAll();
    }

    /*
    public Medico getMedicoById(Integer id){
        return medicoRespository.findById(id).orElse(null);
    }
     */

    public Optional<Medico>searchById(Integer id){
        return medicoRespository.findById(id);
    }
}
