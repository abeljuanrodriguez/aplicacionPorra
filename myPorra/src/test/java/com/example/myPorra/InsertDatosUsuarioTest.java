package com.example.myPorra;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.example.myPorra.dto.PartidoDTO;
import com.example.myPorra.dto.UsuarioDTO;
import com.example.myPorra.dto.UsuarioPrediccionDTO;
import com.example.myPorra.model.EnumResultado;
import com.example.myPorra.service.PartidoService;
import com.example.myPorra.service.UsuarioPrediccionService;
import com.example.myPorra.service.UsuarioService;

@SpringBootTest
@Transactional
public class InsertDatosUsuarioTest {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioPrediccionService usuarioPrediccionService;

	@Autowired
	private PartidoService partidoService;

	@Test
	@Commit
	void insertDataTest() throws Exception {

		UsuarioDTO usuario = new UsuarioDTO(null, "Abel", "AJuan", "abelelentrego@gmail.com", 0);
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
