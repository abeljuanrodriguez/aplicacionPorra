package com.example.myPorra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myPorra.basic.service.EquipoBasicService;
import com.example.myPorra.basic.service.PartidoBasicService;
import com.example.myPorra.dto.PartidoDTO;
import com.example.myPorra.dto.PartidoDetalladoDTO;
import com.example.myPorra.dto.UsuarioPrediccionDTO;
import com.example.myPorra.mapper.EquipoMapper;
import com.example.myPorra.mapper.PartidoMapper;
import com.example.myPorra.model.EnumGanador;
import com.example.myPorra.model.Partido;
import com.example.myPorra.repository.EquipoRepository;
import com.example.myPorra.repository.GrupoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartidoService {

    private final PartidoBasicService partidoBasicService;

    private final UsuarioPrediccionService prediccionService;

    private final EquipoRepository equipoRepository;

    private final GrupoRepository grupoRepository;

    private final PartidoMapper partidoMapper;

    public List<PartidoDTO> findAll() {
        return this.partidoMapper.mapListPartidoToPartidoDTO(this.partidoBasicService.findAll());
    }

    public PartidoDTO findById(Long id) {
        Optional<Partido> partido = this.partidoBasicService.findById(id);
        return this.partidoMapper.mapPartidoToPartidoDTO(
                partido.orElseThrow(() -> new IllegalArgumentException("No se encontró el partido con ID: " + id)));
    }

    public List<PartidoDetalladoDTO> findByIdGrupo(Long idGrupo, Long idUsuario) {
        List<Partido> listaPartidos = this.partidoBasicService.findByIdGrupo(idGrupo);
        List<PartidoDetalladoDTO> partidoDetallado = new ArrayList<PartidoDetalladoDTO>();
        for (Partido partido : listaPartidos) {
            UsuarioPrediccionDTO prediccion = this.prediccionService.findByIdUsuarioAndIdPartido(idUsuario,
                    partido.getId());
            partidoDetallado.add(this.partidoMapper.mapPartidoToPartidoDetalladoDTO(partido, prediccion));
        }

        return partidoDetallado;
    }

    public PartidoDTO guardar(PartidoDTO partidoDto) {
        Partido entity = this.partidoMapper.mapPartidoDTOToPartido(partidoDto, equipoRepository, grupoRepository);
        entity = this.partidoBasicService.guardar(this.calcularGanadorEncuentro(entity));
        return this.findById(entity.getId());
    }

    public Partido calcularGanadorEncuentro(Partido entity) {
        EnumGanador ganador = EnumGanador.calcularGanador(entity.getGfEquipo1(), entity.getGfEquipo2());
        entity.setGanador(ganador);
        return entity;
    }

    public void eliminar(Long id) {
        this.partidoBasicService.eliminar(id);
    }
}
