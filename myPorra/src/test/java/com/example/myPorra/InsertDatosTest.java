

package com.example.myPorra;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.example.myPorra.dto.TorneoDTO;
import com.example.myPorra.service.TorneoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.example.myPorra.dto.EquipoGrupoDTO;
import com.example.myPorra.dto.GrupoDTO;
import com.example.myPorra.dto.PartidoDTO;
import com.example.myPorra.service.EquipoGrupoService;
import com.example.myPorra.service.GrupoService;
import com.example.myPorra.service.PartidoService;

@SpringBootTest
@Transactional
public class InsertDatosTest {

    @Autowired
    private TorneoService torneoService;

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private PartidoService partidoService;

    @Autowired
    private EquipoGrupoService equipoGrupoService;

    @Test
    @Commit
    void insertDataTest() throws Exception {

        TorneoDTO torneoDTO = TorneoDTO.builder().nombre("Mundial 2026").build();
        torneoDTO = torneoService.guardar(torneoDTO);

        List<String> grupos = Arrays.asList("GRUPO A", "GRUPO B", "GRUPO C", "GRUPO D");
        final Integer NUM_EQUIPOS_GRUPO = 4;
        Random random = new Random();

        for (String grupo : grupos) {

            //Creo los grupos
            GrupoDTO grupoDto = crearGrupo(grupo, torneoDTO.getId());

            //Crea los equipos dentro de los grupos
            //NUM_EQUIPOS_GRUPO numero de equipos por cada grupo
            this.crearEquiposParaGrupos(NUM_EQUIPOS_GRUPO, random, grupoDto);

            //Crea los partidos por grupo de manera que todos juegan contra todos
            this.crearPartidosPorGrupo(grupoDto, random);

        }
    }

    private void crearPartidosPorGrupo(GrupoDTO grupoDto, Random random) {
        List<EquipoGrupoDTO> equiposGrupo = equipoGrupoService.findByIdGrupo(grupoDto.getId());

        for (int i = 0; i < equiposGrupo.size(); i++) {
            for (int j = i + 1; j < equiposGrupo.size(); j++) { // Evitar duplicados
                //IDA
                crearPartidos(grupoDto, random, equiposGrupo, i, j);
                //VUELTA
                crearPartidos(grupoDto, random, equiposGrupo, j, i);
            }
        }
    }

    private void crearEquiposParaGrupos(Integer NUM_EQUIPOS_GRUPO, Random random, GrupoDTO grupoDto) {
        for (int i = 0; i < NUM_EQUIPOS_GRUPO; i++) {
            EquipoGrupoDTO equipoGrupoDTO =
                    EquipoGrupoDTO.builder().idEquipo(random.nextLong(190) + 1).idGrupo(grupoDto.getId()).build();
            this.equipoGrupoService.guardar(equipoGrupoDTO);
        }
    }

    private GrupoDTO crearGrupo(String grupo, Long idTorneo) {
        GrupoDTO grupoDto = GrupoDTO.builder().idTorneo(idTorneo).nombre(grupo).build();
        grupoDto = grupoService.guardar(grupoDto);
        return grupoDto;
    }

    private void crearPartidos(GrupoDTO grupoDto, Random random, List<EquipoGrupoDTO> equiposGrupo, int i, int j) {
        PartidoDTO partido =
                PartidoDTO.builder().idEquipo1(equiposGrupo.get(i).getIdEquipo()).idEquipo2(equiposGrupo.get(j).getIdEquipo()).idGrupo(grupoDto.getId()).fecha(LocalDate.now()).gfEquipo1(random.nextInt(4)).gfEquipo2(random.nextInt(4)).isJugado(Boolean.TRUE).build();
        partidoService.guardar(partido);
    }

}
