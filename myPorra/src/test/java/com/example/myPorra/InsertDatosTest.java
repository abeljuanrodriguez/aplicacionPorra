package com.example.myPorra;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
	private GrupoService grupoService;

	@Autowired
	private EquipoGrupoService equipoGrupoService;

	@Autowired
	private PartidoService partidoService;

	@Test
	@Commit
	void insertDataTest() throws Exception {

		List<String> grupos = Arrays.asList("GRUPO A", "GRUPO B", "GRUPO C", "GRUPO D");

		for (String grupo : grupos) {

			GrupoDTO grupoDto = new GrupoDTO(grupo);
			grupoDto = grupoService.guardar(grupoDto);

			Random random = new Random();

			for (int i = 0; i < 4; i++) {
				EquipoGrupoDTO equipoGrupoDTO = new EquipoGrupoDTO(random.nextLong(190) + 1, grupoDto.getId());
				equipoGrupoService.guardar(equipoGrupoDTO);
			}

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
	}

	private void crearPartidos(GrupoDTO grupoDto, Random random, List<EquipoGrupoDTO> equiposGrupo, int i, int j) {
		partidoService.guardar(new PartidoDTO(
		    null, 
		    equiposGrupo.get(i).getIdEquipo(), 
		    equiposGrupo.get(j).getIdEquipo(), 
		    grupoDto.getId(), 
		    LocalDate.now(), 
		    random.nextInt(4), // Goles equipo local
		    random.nextInt(4), // Goles equipo visitante
		    Boolean.TRUE // Partido activo
		));
	}

}
