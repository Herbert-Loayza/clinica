package com.loayza.medico.controller;


import com.loayza.medico.controller.response.MedicoResponse;
import com.loayza.medico.model.Medico;
import com.loayza.medico.service.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/search/{id}")
    public ResponseEntity getMedicById(@PathVariable Integer id){
        Optional<Medico> optionalMedico = medicoService.searchById(id);
        if (optionalMedico.isPresent()){
            return ResponseEntity.ok(optionalMedico.get());
        }
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/crear")
    public MedicoResponse medicoCreate(@RequestBody Medico medico){
        if (Objects.nonNull(medicoService.createMedico(medico))){
            return MedicoResponse
                    .builder()
                    .status(HttpStatus.OK.value())
                    .message(HttpStatus.OK.name())
                    .build();
        }
            return MedicoResponse
                    .builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .message(HttpStatus.INTERNAL_SERVER_ERROR.name())
                    .build();
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity<?>medicoEdit(@RequestBody Medico medico, @PathVariable Integer id ){
        Optional<Medico>medicoOptional=medicoService.searchById(id);
        if (medicoOptional.isPresent()){
            Medico medicodb = medicoOptional.get();
            if (!medicodb.getNombre().isEmpty()){
                medicodb.setNombre(medico.getNombre());
                medicodb.setEspecialidad(medico.getEspecialidad());
                medicodb.setColegiatura(medico.getColegiatura());
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(medicoService.createMedico(medicodb));
            }
                return ResponseEntity.badRequest().build();

        }return ResponseEntity.notFound().build();

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteMedico(@PathVariable Integer id){
        Optional<Medico> optMedic = medicoService.searchById(id);
        if (optMedic.isPresent()){
            medicoService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
