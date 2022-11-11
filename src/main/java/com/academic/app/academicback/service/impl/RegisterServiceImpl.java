package com.academic.app.academicback.service.impl;

import com.academic.app.academicback.dto.CourseDto;
import com.academic.app.academicback.dto.PersonDto;
import com.academic.app.academicback.dto.RegisterDto;
import com.academic.app.academicback.entity.AcademicPlanEntity;
import com.academic.app.academicback.entity.CourseEntity;
import com.academic.app.academicback.entity.RegisterEntity;
import com.academic.app.academicback.entity.StudentEntity;
import com.academic.app.academicback.repository.CourseRepository;
import com.academic.app.academicback.repository.PersonRepository;
import com.academic.app.academicback.repository.RegisterRepository;
import com.academic.app.academicback.repository.StudentRepository;
import com.academic.app.academicback.service.CourseService;
import com.academic.app.academicback.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterRepository respository;

    @Autowired
    private StudentRepository alumnoRespository;


    public List<RegisterDto.Response> listarMatricula(){
        List<RegisterEntity> listaMatriculaEntity =respository.findAll();

        List<RegisterDto.Response> listaMatriculaDTO = new ArrayList<>();

        for (RegisterEntity matriculaEntity : listaMatriculaEntity){
            RegisterDto.Response matriculaDTO = new RegisterDto.Response();
            matriculaDTO.setId(matriculaEntity.getId());

            Optional<StudentEntity> alumno = alumnoRespository.findById(matriculaEntity.getStudent().getId());
            PersonDto person = new PersonDto();
            person.setName(alumno.get().getPerson().getName());
            person.setApellido_paterno(alumno.get().getPerson().getLastName());
            matriculaDTO.setPersona(person);
            //------------ Prueba para agregar persona al curso (demo)---------------------------
            //Optional<PersonEntity>persona = personRepository.findById(1);
            //cursoDTO.setNombrePersona(persona.get().getName());
            listaMatriculaDTO.add(matriculaDTO);
        }

        return listaMatriculaDTO;
    }
/*
    @Override
    public CourseDto obtenerMatriculaPorId(Long id) {
        Optional<CourseEntity> cursoEntity =respository.findById(id);
        CourseDto cursoDTO = new CourseDto();
        if(cursoEntity.isPresent()){
            cursoDTO.setId(cursoEntity.get().getId());

        }else {
            return new CourseDto();
        }
        return cursoDTO;
    }

    @Override
    public CourseDto guardarCurso(CourseDto request) {
                *//*Insertar datos*//*
        CourseEntity cursoEntity = new CourseEntity();
        cursoEntity.setId(request.getId());
        cursoEntity.setName(request.getName());

        AcademicPlanEntity academicPlanEntity = new AcademicPlanEntity();
        academicPlanEntity.setId(request.getAcademicPlanId());

        cursoEntity.setAcademicPlan(academicPlanEntity);
        CourseEntity cursoGuardado=respository.save(cursoEntity);
                *//*Mostrar datos*//*
        CourseDto cursoDto = new CourseDto();
        cursoDto.setName(cursoGuardado.getName());

        return cursoDto;
    }

    @Override
    public void eliminarCurso(Long id) {
        respository.deleteById(id);
    }*/


}
