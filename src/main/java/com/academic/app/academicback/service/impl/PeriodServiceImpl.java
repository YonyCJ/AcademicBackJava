package com.academic.app.academicback.service.impl;

import com.academic.app.academicback.dto.LevelDto;
import com.academic.app.academicback.dto.PeriodDto;
import com.academic.app.academicback.entity.LevelEntity;
import com.academic.app.academicback.entity.PeriodEntity;
import com.academic.app.academicback.repository.LevelRepository;
import com.academic.app.academicback.repository.PeriodRepository;
import com.academic.app.academicback.service.LevelService;
import com.academic.app.academicback.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeriodServiceImpl implements PeriodService {

    @Autowired
    private PeriodRepository respository;

    public List<PeriodDto> listarPeriodo(){
        List<PeriodEntity> listaPeriodoEntity =respository.findAll();

        List<PeriodDto> listaPeriodoDTO = new ArrayList<>();

        /*for (int i = 1; i < listaPeriodoEntity.size(); i++) {
            PeriodDto periodDto = new PeriodDto();
            periodDto.setNombre(listaPeriodoEntity.get(i).getName());
            listaPeriodoDTO.add(periodDto);
        }*/

        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);

        for (Integer num:numeros) {
            System.out.println("FOR 1 - "+num);
        }

        numeros.forEach(numero ->{
            System.out.println(numero);
        });

        numeros.stream().forEach(number ->{
            System.out.println(number);
        });

        for (PeriodEntity periodoEntity : listaPeriodoEntity){
            PeriodDto periodoDto = new PeriodDto();
            periodoDto.setId(periodoEntity.getId());
            periodoDto.setNombre(periodoEntity.getName());
            periodoDto.setDescripcion(periodoEntity.getDescription());
            listaPeriodoDTO.add(periodoDto);
        }

        return listaPeriodoDTO;
    }

    @Override
    public PeriodDto obtenerPeriodoPorId(Long id) {
        Optional<PeriodEntity> periodoEntity =respository.findById(id);
        PeriodDto periodoDTO = new PeriodDto();
        if(periodoEntity.isPresent()){
            periodoDTO.setId(periodoEntity.get().getId());
            periodoDTO.setNombre(periodoEntity.get().getName());
        }else {
            return new PeriodDto();
        }
        return periodoDTO;
    }

    @Override
    public PeriodDto guardarPeriodo(PeriodDto request) {
                /*Insertar datos*/
        PeriodEntity periodoEntity = new PeriodEntity();
        periodoEntity.setId(request.getId());
        periodoEntity.setName(request.getNombre());
        periodoEntity.setDescription(request.getDescripcion());
        periodoEntity.setCondition(request.getEstado());

        PeriodEntity periodoGuardado=respository.save(periodoEntity);
                /*Mostrar datos*/
        PeriodDto periodoDto = new PeriodDto();
        periodoDto.setNombre(periodoGuardado.getName());
        periodoDto.setDescripcion(periodoGuardado.getDescription());
        periodoDto.setEstado(periodoGuardado.getCondition());



        return periodoDto;
    }

    @Override
    public void eliminarPeriodo(Long id) {
        respository.deleteById(id);
    }


}
