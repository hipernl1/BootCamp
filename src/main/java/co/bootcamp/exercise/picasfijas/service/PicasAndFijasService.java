package co.bootcamp.exercise.picasfijas.service;

import static co.bootcamp.exercise.picasfijas.util.DescripcionUtil.*;

import java.util.ResourceBundle;
import java.util.Scanner;

import co.bootcamp.exercise.picasfijas.util.NumeroAleatorioUtil;
import co.bootcamp.exercise.picasfijas.util.Resultado;

public class PicasAndFijasService {
	
	private int intentos;
	private Scanner leer;
	private String numeroSecreto;
	
	private static ResourceBundle resourceBundle;

	static {
		try {
			resourceBundle = ResourceBundle.getBundle("lenguaje");
		} catch (Throwable e) {
			System.err.println("No fue posible carga el archivo. " + e.fillInStackTrace());
		}
	}
	
	PicasAndFijasService(Scanner leer, String numeroSecreto, int intentos) {
		this.intentos = intentos;
		this.leer = leer;
		this.numeroSecreto = numeroSecreto;
	}
	
	String getNumeroSecreto(){
		return this.numeroSecreto;
	}
	
	public PicasAndFijasService(Scanner leer, int intentos) {
		this(leer, NumeroAleatorioUtil.generarNumeroAleatorio(), intentos);
	}
	
	public void jugar() {
		do {
			System.out.println(resourceBundle.getString(NUMERO_SECRETO) + numeroSecreto);
			System.out.println(resourceBundle.getString(SOLICITAR_NUMERO));
			String numero = leer.nextLine();
			Resultado resultado = encontrarCoincidencias(numeroSecreto, numero);
			if (!resultado.isGanador()) {
				imprimirResultado(intentos, numero, resultado);
				intentos -= 1;
			}else {
				intentos = 0;
			}			
		} while (intentos > 0);
		mensajeFinalizado();
	}

	private static void imprimirResultado(int intento, String numero, Resultado resultado) {
		System.out.println(resourceBundle.getString(INTENTO)+ intento+" "+ resourceBundle.getString(INTENTO_PEND)+" " + numero);
		System.out.println(resourceBundle.getString(PICAS) + resultado.getPicas());
		System.out.println(resourceBundle.getString(FIJAS) + resultado.getFijas());
	}
	
	private static void mensajeFinalizado() {		
		System.out.println(resourceBundle.getString(JUEGO_FINALIZADO));		
	}
	
	private static Resultado encontrarCoincidencias(String numeroSecreto, String numeroIngresado) {
		if (!mensajeGanador(numeroSecreto, numeroIngresado)) {
			return calcularCoincidencias(numeroSecreto, numeroIngresado);
		}
		return new Resultado(true);
	}

	private static Resultado calcularCoincidencias(String numeroSecreto, String numeroIngresado) {
		int picas = 0, fijas = 0;
		for (int i = 0; i < numeroIngresado.length(); i++) {
			if (encontrarFijas(numeroSecreto.charAt(i), numeroIngresado.charAt(i))) {
				fijas += 1;
			} else {
				picas += encontrarPicas(numeroSecreto, numeroIngresado.charAt(i)) ? 1 : 0;
			}
		}
		return new Resultado(picas, fijas);
	}

	private static boolean mensajeGanador(String numeroSecreto, String numeroIngresado) {
		if (numeroSecreto.equals(numeroIngresado)) {			
			System.out.println(resourceBundle.getString(GANADOR));
			return true;
		}
		return false;
	}

	private static boolean encontrarFijas(char numSecreto, char numIngresado) {
		return numSecreto == numIngresado ? true : false;
	}

	private static boolean encontrarPicas(String numeroSecreto, char caracter) {
		for (char numSecreto : numeroSecreto.toCharArray()) {
			if (numSecreto == caracter) {
				return true;
			}
		}
		return false;
	}
}
