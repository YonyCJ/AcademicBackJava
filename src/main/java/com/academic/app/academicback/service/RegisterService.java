package com.academic.app.academicback.service;

import com.academic.app.academicback.dto.RegisterDto;

import java.util.List;


public interface RegisterService {

    List<RegisterDto.Response> listarMatricula();

    /*RegisterDto obtenerMatriculaPorId(Long id);

    RegisterDto guardarMatricula(RegisterDto request);

    void eliminarMatricula(Long id);*/

}
