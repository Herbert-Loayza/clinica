package com.loayza.clinica.controller.response;

import com.loayza.clinica.model.Medico;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MedicoResponse {

    private Integer status;
    private String message;
    private Medico medico;
}
