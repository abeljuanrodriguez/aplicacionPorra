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

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.myPorra.controller.UsuarioController;
import com.example.myPorra.dto.UsuarioDTO;
import com.example.myPorra.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class UsuarioTest {

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
        objectMapper = new ObjectMapper();
    }

    // Test para obtener todos los usuarios
    @Test
    public void testFindAll() throws Exception {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(1L);
        usuarioDTO.setNombre("Juan");
        usuarioDTO.setCorreo("juan@example.com");

        when(usuarioService.findAll()).thenReturn(List.of(usuarioDTO));

        mockMvc.perform(get("/api/usuarios"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].id").value(1))
               .andExpect(jsonPath("$[0].nombre").value("Juan"))
               .andExpect(jsonPath("$[0].correo").value("juan@example.com"));

        verify(usuarioService, times(1)).findAll();
    }

    // Test para obtener un usuario por id
    @Test
    public void testFindById() throws Exception {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(1L);
        usuarioDTO.setNombre("Juan");
        usuarioDTO.setCorreo("juan@example.com");

        when(usuarioService.findById(1L)).thenReturn(usuarioDTO);

        mockMvc.perform(get("/api/usuarios/{id}", 1L))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(1))
               .andExpect(jsonPath("$.nombre").value("Juan"))
               .andExpect(jsonPath("$.correo").value("juan@example.com"));

        verify(usuarioService, times(1)).findById(1L);
    }

    // Test para crear un nuevo usuario
    @Test
    public void testCrearUsuario() throws Exception {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(1L);
        usuarioDTO.setNombre("Juan");
        usuarioDTO.setCorreo("juan@example.com");

        when(usuarioService.guardar(any(UsuarioDTO.class))).thenReturn(usuarioDTO);

        mockMvc.perform(post("/api/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuarioDTO)))
               .andExpect(status().isCreated())
               .andExpect(jsonPath("$.id").value(1))
               .andExpect(jsonPath("$.nombre").value("Juan"))
               .andExpect(jsonPath("$.correo").value("juan@example.com"));

        verify(usuarioService, times(1)).guardar(any(UsuarioDTO.class));
    }

    // Test para eliminar un usuario
    @Test
    public void testEliminarUsuario() throws Exception {
        doNothing().when(usuarioService).eliminar(1L);

        mockMvc.perform(delete("/api/usuarios/{id}", 1L))
               .andExpect(status().isOk());

        verify(usuarioService, times(1)).eliminar(1L);
    }
}
