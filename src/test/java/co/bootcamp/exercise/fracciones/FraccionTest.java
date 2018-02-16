package co.bootcamp.exercise.fracciones;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FraccionTest {
	
	@Test(expected= IllegalArgumentException.class)
	public void creacionFracionesSimplificadas() {
		new Fraccion.Builder().conDenominador(0)
									.build();
	}
	
	@Test
	public void compararFracionesSimplificadas() {
		Fraccion fraccionDos = new Fraccion.Builder()
									.conNumerador(4)
									.conDenominador(4)
									.build();

		assertThat(new Fraccion.Builder()
					.conNumerador(1)
					.conDenominador(1)
					.build(), equalTo(fraccionDos));		
	}

	@Test
	public void sumarFracionesSimplificadas() {
		Fraccion fraccion = new Fraccion.Builder()
									.conNumerador(4)
									.conDenominador(8)
									.build();

		assertThat(new Fraccion.Builder()
				.conNumerador(4)
				.conDenominador(2)
				.build(), equalTo(fraccion.sumar(new Fraccion.Builder()
														.conNumerador(3)
														.conDenominador(2)
														.build())));		
	}
	
	@Test
	public void sumarFracionesSimplificadas2() {
		Fraccion fraccion = new Fraccion.Builder()
									.conNumerador(1)
									.conDenominador(3)
									.build();

		assertThat(new Fraccion.Builder()
				.conNumerador(5)
				.conDenominador(6)
				.build(), equalTo(fraccion.sumar(new Fraccion.Builder()
														.conNumerador(1)
														.conDenominador(2)
														.build())));		
	}
	
	@Test
	public void restarFracionesSimplificadas() {
		Fraccion fraccion = new Fraccion.Builder()
									.conNumerador(1)
									.conDenominador(2)
									.build();

		assertThat(new Fraccion.Builder()
				.conNumerador(1)
				.conDenominador(6)
				.build(), equalTo(fraccion.restar(new Fraccion.Builder()
														.conNumerador(1)
														.conDenominador(3)
														.build())));		
	}
	
	@Test
	public void multiplicarFracionesSimplificadas() {
		Fraccion fraccion = new Fraccion.Builder()
									.conNumerador(5)
									.conDenominador(3)
									.build();

		assertThat(new Fraccion.Builder()
				.conNumerador(5)
				.conDenominador(6)
				.build(), equalTo(fraccion.multiplicar(new Fraccion.Builder()
														.conNumerador(2)
														.conDenominador(4)
														.build())));		
	}

	
	@Test
	public void dividirFracionesSimplificadas() {
		Fraccion fraccion = new Fraccion.Builder()
									.conNumerador(5)
									.conDenominador(3)
									.build();
		
		assertThat(new Fraccion.Builder()
				.conNumerador(10)
				.conDenominador(3)
				.build(), equalTo(fraccion.dividir(new Fraccion.Builder()
														.conNumerador(2)
														.conDenominador(4)
														.build())));		
	}
}
