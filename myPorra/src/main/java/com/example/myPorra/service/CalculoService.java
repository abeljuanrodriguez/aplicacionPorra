package com.example.myPorra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myPorra.basic.service.UsuarioPrediccionBasicService;
import com.example.myPorra.model.EnumGanador;
import com.example.myPorra.model.EnumResultado;
import com.example.myPorra.model.Partido;
import com.example.myPorra.model.UsuarioPrediccion;
import com.example.myPorra.repository.TorneoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CalculoService {

	private final UsuarioPrediccionBasicService usuarioPrediccionBasicService;

	public void calcular() {

		List<UsuarioPrediccion> listaPredicciones = this.usuarioPrediccionBasicService.findAll();

		for (UsuarioPrediccion usuarioPrediccion : listaPredicciones) {
			Partido partido = usuarioPrediccion.getPartido();
			if (!resultadoCorrecto(usuarioPrediccion, partido)) {
				this.ganadorCorrecto(usuarioPrediccion, partido);
				this.usuarioPrediccionBasicService.guardar(usuarioPrediccion);
			}
		}

	}

	// Comprueba si el resultado de la prediccion es igual al resultado del partido
	private Boolean resultadoCorrecto(UsuarioPrediccion usuarioPrediccion, Partido partido) {
		// Boolean que comprueba si el partido se ha jugado y si el resultado es
		// correcto
		if (partido.getIsJugado() && partido.getGfEquipo1().equals(usuarioPrediccion.getGfEquipo1())
				&& partido.getGfEquipo2().equals(usuarioPrediccion.getGfEquipo2())) {
			usuarioPrediccion.getUsuario().setPuntuacion(usuarioPrediccion.getUsuario().getPuntuacion() + 3);
			usuarioPrediccion.setResultado(EnumResultado.ACIERTO_TOTAL);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	private void ganadorCorrecto(UsuarioPrediccion usuarioPrediccion, Partido partido) {
		// Boolean que comprueba si el partido se ha jugado y el ganador es el correcto
		if (partido.getIsJugado()) {
			EnumGanador ganador = EnumGanador.calcularGanador(partido.getGfEquipo1(), partido.getGfEquipo2());
			if (ganador.equals(usuarioPrediccion.getGanador())) {
				usuarioPrediccion.getUsuario().setPuntuacion(usuarioPrediccion.getUsuario().getPuntuacion() + 1);
				usuarioPrediccion.setResultado(EnumResultado.ACIERTO_PARCIAL);
			}
		}
	}

}
