package com.loayza.medico.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MedicoResponse {

    private Integer status;
    private String message;
}
