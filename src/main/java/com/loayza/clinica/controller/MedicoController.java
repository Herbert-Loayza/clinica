package com.loayza.clinica.controller;


import com.loayza.clinica.controller.response.MedicoResponse;
import com.loayza.clinica.model.Medico;
import com.loayza.clinica.service.MedicoService;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping("/listar")
    public List<Medico>getMedico(){
        return medicoService.getAllMedicos();
    }

    /*
    @GetMapping("/{id}")
    public MedicoResponse getMedicoxId(@PathVariable Integer id){
        Medico searchMedico = medicoService.getMedicoById(id);
        if(Objects.nonNull(medicoService.getAllMedicos())){
            return MedicoResponse
                    .builder()
                    .status(HttpStatus.OK.value())
                    .message(HttpStatus.OK.name())
                    .medico(searchMedico)
                    .build();

            }return MedicoResponse
                        .builder()
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(HttpStatus.NOT_FOUND.name())
                        .build();

    }
    */
    @GetMapping("/search/{id}")
    public ResponseEntity getMedicById(@PathVariable Integer id){
        Optional<Medico> optionalMedico = medicoService.searchById(id);
        if (optionalMedico.isPresent()){
            return ResponseEntity.ok(optionalMedico.get());
        }
            return ResponseEntity.notFound().build();
    }
}
