package com.academic.app.academicback.controller;

import com.academic.app.academicback.entity.PersonRelationEntity;
import com.academic.app.academicback.entity.RelationshipEntity;
import com.academic.app.academicback.repository.PersonRelationshipRepository;
import com.academic.app.academicback.repository.RelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personrelationship")
public class PersonRelationshipController {
    @Autowired
    private PersonRelationshipRepository respository;

    @GetMapping
    public List<PersonRelationEntity> listar(){
        return respository.findAll();
    }

    @GetMapping("/filtrar/{name}")
    public List<PersonRelationEntity> listar(@PathVariable("name") String name){
        return respository.findAllByPersonName(name);
    }

    @GetMapping("/{id}")
    public PersonRelationEntity listarPerParentescoPorId(@PathVariable("id") Long id){

        Optional<PersonRelationEntity> perparentesco =respository.findById(id);
        if(perparentesco.isPresent()){
            return perparentesco.get();
        }else {
            return new PersonRelationEntity();
        }
    }

    @PostMapping
    public PersonRelationEntity guardar(@RequestBody PersonRelationEntity data){
        return respository.save(data);
    }


    @PutMapping
    public PersonRelationEntity actualizar(@RequestBody PersonRelationEntity data){
        return respository.save(data);
    }

    @DeleteMapping("/{id}")
    public List<PersonRelationEntity>  eliminar(@PathVariable("id") Long id){
        respository.deleteById(id);
        return respository.findAll();
    }

}
