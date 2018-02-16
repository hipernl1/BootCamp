package co.bootcamp.exercise.fracciones;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FraccionTest {
	
	@Test(expected= IllegalArgumentException.class)
	public void creacionFracionesSimplificadas() {
		new Fraccion.Builder().conDenominador(0).build();
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void creacionEnCeroFracionesSimplificadas() {
		new Fraccion.Builder().conNumerador(0)
								.conDenominador(0).build();
	}
	
	@Test
	public void compararFracionesSimplificadas() {
		Fraccion resultadoEsperado = new Fraccion.Builder()
									.conNumerador(1)
									.conDenominador(1).build();
		assertThat(resultadoEsperado, equalTo(new Fraccion.Builder()
									.conNumerador(4)
									.conDenominador(4).build()));		
	}

	@Test
	public void sumarFracionesSimplificadas() {
		Fraccion resultadoEsperado = new Fraccion.Builder()
				.conNumerador(7)
				.conDenominador(6).build();
		assertThat(resultadoEsperado, equalTo(new Fraccion.Builder()
											.conNumerador(2)
											.conDenominador(3).build()
											.sumar(new Fraccion.Builder()
														.conNumerador(1)
														.conDenominador(2).build())));		
	}
	
	@Test
	public void sumarFracionesSimplificadas2() {
		Fraccion resultadoEsperado = new Fraccion.Builder()
									.conNumerador(5)
									.conDenominador(6).build();
		assertThat(resultadoEsperado, equalTo(new Fraccion.Builder()
										.conNumerador(1)
										.conDenominador(3)
										.build().sumar(new Fraccion.Builder()
														.conNumerador(1)
														.conDenominador(2).build())));		
	}
	
	@Test
	public void restarFracionesSimplificadas() {
		Fraccion resultadoEsperado = new Fraccion.Builder()
									.conNumerador(1)
									.conDenominador(6).build();
		assertThat(resultadoEsperado, equalTo(new Fraccion.Builder()
												.conNumerador(1)
												.conDenominador(2).build()
												.restar(new Fraccion.Builder()
														.conNumerador(1)
														.conDenominador(3).build())));		
	}
	
	@Test
	public void restarFracioccnesSimplificadas() {
		Fraccion resultadoEsperado = new Fraccion.Builder()
									.conNumerador(-115)
									.conDenominador(28).build();
		assertThat(resultadoEsperado, equalTo(new Fraccion.Builder()
												.conNumerador(50)
												.conDenominador(7).build()
												.restar(new Fraccion.Builder()
														.conNumerador(45)
														.conDenominador(4).build())));		
	}

	
	@Test
	public void dividirFracionesSimplificadas() {
		Fraccion resultadoEsperado = new Fraccion.Builder()
				.conNumerador(10)
				.conDenominador(3).build();		
		assertThat(resultadoEsperado, equalTo(new Fraccion.Builder()
						.conNumerador(5)
						.conDenominador(3).build()
						.dividir(new Fraccion.Builder()
								.conNumerador(2)
								.conDenominador(4).build())));		
	}
}
