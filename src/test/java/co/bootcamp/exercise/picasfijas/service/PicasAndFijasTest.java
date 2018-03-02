package co.bootcamp.exercise.picasfijas.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Scanner;

import org.junit.Test;

import co.bootcamp.exercise.picasfijas.util.NumeroAleatorioUtil;

public class PicasAndFijasTest {
	
	@Test
	public void validarNumeroAleatorio(){
		String numeroAleatorio = NumeroAleatorioUtil.generarNumeroAleatorio();
		System.out.println("Numero 1 "+ numeroAleatorio);
		String numeroAleatorio2 = NumeroAleatorioUtil.generarNumeroAleatorio();
		System.out.println("Numero 2 "+ numeroAleatorio2);
		assertThat(numeroAleatorio2.equals(numeroAleatorio), is(false));
	}
	
	@Test
	public void validarJuegoGanador(){
		Scanner leer = new Scanner("1256");
		PicasAndFijasService picasAndFijasService = new PicasAndFijasService(leer, "1256" ,1);
		picasAndFijasService.jugar();
		assertThat("1256".equals(picasAndFijasService.getNumeroSecreto()), is(true));
	}
	
	@Test
	public void validarJuegoPerdedor(){
		Scanner leer = new Scanner("1234");
		PicasAndFijasService picasAndFijasService = new PicasAndFijasService(leer, "4321" ,1);
		picasAndFijasService.jugar();
		assertThat("1234".equals(picasAndFijasService.getNumeroSecreto()), is(false));
	}
	

}
