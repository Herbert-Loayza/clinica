package com.loayza.medico.service;


import com.loayza.medico.model.Medico;
import com.loayza.medico.repository.MedicoRespository;
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

    public Optional<Medico>searchById(Integer id){
        return medicoRespository.findById(id);
    }

    public Medico createMedico(Medico medico){
        return medicoRespository.save(medico);
    }

    public void delete(Integer id){
        medicoRespository.deleteById(id);
    }



}
