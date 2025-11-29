package com.example.myPorra.mapper;

import com.example.myPorra.dto.GrupoDTO;
import com.example.myPorra.model.Grupo;
import com.example.myPorra.model.Torneo;
import com.example.myPorra.repository.EquipoRepository;
import com.example.myPorra.repository.TorneoRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GrupoMapper {

    GrupoMapper INSTANCE = Mappers.getMapper(GrupoMapper.class);

    @Mapping(target = "id", source = "grupo.id")
    @Mapping(target = "nombre", source = "grupo.nombre")
    @Mapping(target = "idTorneo", source = "grupo.torneo.id")
    GrupoDTO mapGrupoToGrupoDTO(Grupo grupo);

    List<GrupoDTO> mapListGrupoToGrupoDTO(List<Grupo> listaGrupo);

    @Mapping(target = "id", source = "grupoDTO.id")
    @Mapping(target = "nombre", source = "grupoDTO.nombre")
    @Mapping(target = "torneo", source = "idTorneo", qualifiedByName = "idToTorneo")
    Grupo mapGrupoDTOToGrupo(GrupoDTO grupoDTO, @Context TorneoRepository torneoRepository);

    List<Grupo> mapListGrupoDTOToGrupo(List<GrupoDTO> listaGrupoDTO);

    @Named("idToTorneo")
    default Torneo idToTorneo(Long id, @Context TorneoRepository torneoRepository) {
        if (id == null) return null;
        return torneoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Torneo no encontrado con ID: " + id));
    }

}
