package com.example.myPorra;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.myPorra.controller.EquipoController;
import com.example.myPorra.dto.EquipoDTO;
import com.example.myPorra.service.EquipoService;
import com.fasterxml.jackson.databind.ObjectMapper;

class CalculoTest {

    private MockMvc mockMvc;

    @Mock
    private EquipoService equipoService;

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
        List<EquipoDTO> equipos = Arrays.asList(new EquipoDTO(1L, "España","España",null), new EquipoDTO(2L, "Francia", "Francia",null));
        when(equipoService.findAll()).thenReturn(equipos);

        mockMvc.perform(get("/api/equipos"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.size()").value(equipos.size()));
    }

    @Test
    void testFindById() throws Exception {
        EquipoDTO equipo = new EquipoDTO(1L, "España","España",null);
        when(equipoService.findById(1L)).thenReturn(equipo);

        mockMvc.perform(get("/api/equipos/1"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(1L))
               .andExpect(jsonPath("$.nombre").value("Equipo A"));
    }

    @Test
    void testCrear() throws Exception {
        EquipoDTO equipo = new EquipoDTO(1L, "España","España",null);
        when(equipoService.guardar(any(EquipoDTO.class))).thenReturn(equipo);

        mockMvc.perform(post("/api/equipos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(equipo)))
               .andExpect(status().isCreated())
               .andExpect(jsonPath("$.id").value(1L))
               .andExpect(jsonPath("$.nombre").value("Equipo A"));
    }

    @Test
    void testEliminar() throws Exception {
        doNothing().when(equipoService).eliminar(1L);

        mockMvc.perform(delete("/api/equipos/1"))
               .andExpect(status().isOk());

        verify(equipoService, times(1)).eliminar(1L);
    }
}
