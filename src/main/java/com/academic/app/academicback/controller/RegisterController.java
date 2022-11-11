package com.academic.app.academicback.controller;

import com.academic.app.academicback.dto.AcademicPlanDto;
import com.academic.app.academicback.dto.RegisterDto;
import com.academic.app.academicback.entity.GradeEntity;
import com.academic.app.academicback.entity.RegisterEntity;
import com.academic.app.academicback.repository.GradeRepository;
import com.academic.app.academicback.repository.RegisterRepository;
import com.academic.app.academicback.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
    @Autowired
    private RegisterService service;

    @GetMapping
    public List<RegisterDto.Response> listarMatricula(){
        return service.listarMatricula();
    }
/*

    @GetMapping("/filtrar/{name}")
    public List<RegisterEntity> listar(@PathVariable("name") String code){
        return respository.findAllByStudentCode(code);
    }

    @GetMapping("/{id}")
    public RegisterEntity listarMatriculaPorId(@PathVariable("id") Long id){

        Optional<RegisterEntity> matricula =respository.findById(id);
        if(matricula.isPresent()){
            return matricula.get();
        }else {
            return new RegisterEntity();
        }
    }

    @PostMapping
    public RegisterEntity guardar(@RequestBody RegisterEntity data){
        return respository.save(data);
    }


    @PutMapping
    public RegisterEntity actualizar(@RequestBody RegisterEntity data){
        return respository.save(data);
    }

    @DeleteMapping("/{id}")
    public List<RegisterEntity>  eliminar(@PathVariable("id") Long id){
        respository.deleteById(id);
        return respository.findAll();
    }
*/

}
