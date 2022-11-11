package com.academic.app.academicback.service;

import com.academic.app.academicback.dto.PeriodDto;
import com.academic.app.academicback.dto.SubPeriodDto;

import java.util.List;


public interface SubPeriodService {

    List<SubPeriodDto> listarSubPeriodo();

    SubPeriodDto obtenerSubPeriodoPorId(Long id);

    SubPeriodDto guardarSubPeriodo(SubPeriodDto request);

    void eliminarSubPeriodo(Long id);

}
