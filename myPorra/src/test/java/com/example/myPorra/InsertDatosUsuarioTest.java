package com.example.myPorra;

import com.example.myPorra.dto.PartidoDTO;
import com.example.myPorra.dto.TorneoDTO;
import com.example.myPorra.dto.UsuarioDTO;
import com.example.myPorra.dto.UsuarioPrediccionDTO;
import com.example.myPorra.model.EnumResultado;
import com.example.myPorra.service.PartidoService;
import com.example.myPorra.service.TorneoService;
import com.example.myPorra.service.UsuarioPrediccionService;
import com.example.myPorra.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@SpringBootTest
@Transactional
public class InsertDatosUsuarioTest {

    @Autowired
    private TorneoService torneoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioPrediccionService usuarioPrediccionService;

    @Autowired
    private PartidoService partidoService;

    @Test
    @Commit
    void insertDataTest() throws Exception {

        TorneoDTO torneoDTO = TorneoDTO.builder().nombre("Mundial 2026").build();
        torneoDTO = torneoService.guardar(torneoDTO);

        UsuarioDTO usuario =
                UsuarioDTO.builder().nombre("Abel").correo("abelelentrego@gmail.com").alias("AJuan").puntuacion(0).idTorneo(torneoDTO.getId()).build();
        usuario = usuarioService.guardar(usuario);

        List<PartidoDTO> listaPartidos = this.partidoService.findAll();

        Random random = new Random();

        for (PartidoDTO partidoDTO : listaPartidos) {
            try {
                UsuarioPrediccionDTO prediccion = new UsuarioPrediccionDTO(null, usuario.getId(), partidoDTO.getId(),
                        random.nextInt(4), random.nextInt(4), null, EnumResultado.FALLO);
                usuarioPrediccionService.guardar(prediccion);
            } catch (Exception e) {
                e.getMessage();
            }
        }

    }

}
