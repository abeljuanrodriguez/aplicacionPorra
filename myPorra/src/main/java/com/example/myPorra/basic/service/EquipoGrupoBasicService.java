package com.example.myPorra.basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myPorra.model.EquipoGrupo;
import com.example.myPorra.repository.EquipoGrupoRepository;

@Service
public class EquipoGrupoBasicService {

	@Autowired
    private EquipoGrupoRepository equipoGrupoRepository;
    
    public List<EquipoGrupo> findAll() {
        return equipoGrupoRepository.findAll();
    }

    public Optional<EquipoGrupo> findById(Long id) {
    	return equipoGrupoRepository.findById(id);
    }

    public EquipoGrupo guardar(EquipoGrupo equipoGrupo) {
        return equipoGrupoRepository.save(equipoGrupo);
    }
    
    public List<EquipoGrupo> guardar(List<EquipoGrupo> equipoGrupo) {
        return equipoGrupoRepository.saveAll(equipoGrupo);
    }

    public void eliminar(Long id) {
    	equipoGrupoRepository.deleteById(id);
    }

	public List<EquipoGrupo> findByIdGrupo(Long idGrupo) {
		return equipoGrupoRepository.findByIdGrupo(idGrupo);
	}
}
