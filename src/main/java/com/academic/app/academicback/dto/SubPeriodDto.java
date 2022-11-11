package com.academic.app.academicback.dto;

import lombok.Data;

@Data
public class SubPeriodDto {

    private Long id;
    private String nombre;
    private String tipo;
    private Long id_periodo;
    private Boolean estado;

}
