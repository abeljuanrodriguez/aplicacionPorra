package com.example.myPorra;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.myPorra.controller.EquipoController;
import com.example.myPorra.dto.EquipoGrupoDTO;
import com.example.myPorra.dto.GrupoDTO;
import com.example.myPorra.service.EquipoGrupoService;
import com.example.myPorra.service.EquipoService;
import com.example.myPorra.service.GrupoService;
import com.fasterxml.jackson.databind.ObjectMapper;

class CalculoTest {

	private MockMvc mockMvc;

	@Mock
	private EquipoService equipoService;

	@Mock
	private EquipoGrupoService equipoGrupoService;

	@Mock
	private GrupoService grupoService;

	@InjectMocks
	private EquipoController equipoController;

	private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(equipoController).build();
	}

	@Test
	void testFindByAll() throws Exception {

		GrupoDTO grupoDto = new GrupoDTO("GRUPO A");
		grupoService.guardar(grupoDto);

		List<EquipoGrupoDTO> lista = new ArrayList<EquipoGrupoDTO>();
		EquipoGrupoDTO equipoGrupoDTO = new EquipoGrupoDTO(33L, 1L);
		EquipoGrupoDTO equipoGrupoDTO1 = new EquipoGrupoDTO(40L, 1L);
		EquipoGrupoDTO equipoGrupoDTO2 = new EquipoGrupoDTO(60L, 1L);
		EquipoGrupoDTO equipoGrupoDTO3 = new EquipoGrupoDTO(75L, 1L);
		lista.add(equipoGrupoDTO);
		lista.add(equipoGrupoDTO1);
		lista.add(equipoGrupoDTO2);
		lista.add(equipoGrupoDTO3);
		equipoGrupoService.guardar(lista);
		
		
		

	}

}
