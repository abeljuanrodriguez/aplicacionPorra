package com.example.myPorra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.myPorra.dto.EquipoGrupoDTO;
import com.example.myPorra.service.EquipoGrupoService;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/equipoGrupo")
@Getter
@Setter
public class EquipoGrupoController {

    @Autowired
    private EquipoGrupoService equipoGrupoService;

    @GetMapping
    public List<EquipoGrupoDTO> findByAll() {
        return this.equipoGrupoService.findAll();
    }

    @GetMapping("/findByIdGrupo/{idGrupo}")
    public List<EquipoGrupoDTO> findByIdGrupo(@PathVariable Long idGrupo) {
        return this.equipoGrupoService.findByIdGrupo(idGrupo);
    }

    @GetMapping("/{id}")
    public EquipoGrupoDTO findById(@PathVariable Long id) {
        return this.equipoGrupoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EquipoGrupoDTO crear(@Valid @RequestBody EquipoGrupoDTO usuario) {
        return this.equipoGrupoService.guardar(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        this.equipoGrupoService.eliminar(id);
    }
}
