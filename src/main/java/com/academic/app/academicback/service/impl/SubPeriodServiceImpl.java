package com.academic.app.academicback.service.impl;

import com.academic.app.academicback.dto.SubPeriodDto;
import com.academic.app.academicback.entity.PeriodEntity;
import com.academic.app.academicback.entity.SubPeriodEntity;
import com.academic.app.academicback.repository.PeriodRepository;
import com.academic.app.academicback.repository.SubPeriodRepository;
import com.academic.app.academicback.service.SubPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubPeriodServiceImpl implements SubPeriodService {

    @Autowired
    private SubPeriodRepository respository;

    @Autowired
    private PeriodRepository repository;

    public List<SubPeriodDto> listarSubPeriodo(){
        List<SubPeriodEntity> listaSubPeriodoEntity =respository.findAll();

        List<SubPeriodDto> listaSubPeriodoDTO = new ArrayList<>();

        for (SubPeriodEntity subperiodoEntity : listaSubPeriodoEntity){
            SubPeriodDto subperiodoDto = new SubPeriodDto();
            subperiodoDto.setId(subperiodoEntity.getId());
            subperiodoDto.setNombre(subperiodoEntity.getName());
            subperiodoDto.setTipo(subperiodoEntity.getType());

            //------------ Prueba para agregar persona al curso (demo)---------------------------
            //Optional<PersonEntity>persona = personRepository.findById(1);
            //cursoDTO.setNombrePersona(persona.get().getName());
            listaSubPeriodoDTO.add(subperiodoDto);
        }

        return listaSubPeriodoDTO;
    }

    @Override
    public SubPeriodDto obtenerSubPeriodoPorId(Long id) {
        Optional<SubPeriodEntity> subperiodoEntity =respository.findById(id);
        SubPeriodDto subperiodoDTO = new SubPeriodDto();
        if(subperiodoEntity.isPresent()){
            subperiodoDTO.setId(subperiodoEntity.get().getId());
            subperiodoDTO.setNombre(subperiodoEntity.get().getName());
        }else {
            return new SubPeriodDto();
        }
        return subperiodoDTO;
    }

    @Override
    public SubPeriodDto guardarSubPeriodo(SubPeriodDto request) {
                /*Insertar datos*/
        SubPeriodEntity subperiodoEntity = new SubPeriodEntity();
        subperiodoEntity.setId(request.getId());
        subperiodoEntity.setName(request.getNombre());
        subperiodoEntity.setType(request.getTipo());
        subperiodoEntity.setCondition(request.getEstado());

        PeriodEntity periodEntity = new PeriodEntity();
        periodEntity.setId(request.getId_periodo());

        subperiodoEntity.setPeriod(periodEntity);

        SubPeriodEntity subperiodoGuardado=respository.save(subperiodoEntity);
                /*Mostrar datos*/
        SubPeriodDto subperiodoDto = new SubPeriodDto();
        subperiodoDto.setNombre(subperiodoGuardado.getName());
        subperiodoDto.setTipo(subperiodoGuardado.getType());




        return subperiodoDto;
    }

    @Override
    public void eliminarSubPeriodo(Long id) {
        respository.deleteById(id);
    }


}
