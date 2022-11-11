package com.academic.app.academicback.controller;


import com.academic.app.academicback.dto.SubPeriodDto;
import com.academic.app.academicback.service.SubPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subperiod")
public class SubPeriodController {
    @Autowired
    private SubPeriodService service;

    @GetMapping
    public List<SubPeriodDto> listarSubPeriodo(){
        return service.listarSubPeriodo();
    }

    @GetMapping("/{id}")
    public SubPeriodDto listarSubPeriodoPorId(@PathVariable("id") Long id){
        return service.obtenerSubPeriodoPorId(id);
    }

    @PostMapping
    public SubPeriodDto guardarSubPeriodo(@RequestBody SubPeriodDto request){
        return service.guardarSubPeriodo(request);
    }


    @PutMapping
    public SubPeriodDto actualizarSubPeriodo(@RequestBody SubPeriodDto request){
        return service.guardarSubPeriodo(request);
    }

    @DeleteMapping("/{id}")
    public void eliminarSubPeriodo(@PathVariable("id") Long id){
        service.eliminarSubPeriodo(id);
    }

}
