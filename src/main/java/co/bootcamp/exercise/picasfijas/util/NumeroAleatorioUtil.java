package co.bootcamp.exercise.picasfijas.util;

import java.util.Random;

public final class NumeroAleatorioUtil {
	private static int[] BASE = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private final static int DIGITOS = 4;

	public static String generarNumeroAleatorio() {
		generarPermutacion();		
		return generarNumero();
	}
	
	private static String generarNumero() {
		StringBuilder renglon = new StringBuilder(); 
		for (int numero= 0; numero < DIGITOS; ++numero) {
			renglon.append(BASE[numero]);
		} 
		return renglon.toString();
	}

	private static void generarPermutacion() {
		for (int iterador = BASE.length - 1; iterador >= 0; iterador--) {
			int numeroAleatorio = obtenerNumeroAleatorio();		
			int temporal = BASE[iterador];
			BASE[iterador] = BASE[numeroAleatorio];
			BASE[numeroAleatorio] = temporal;
		}
	}

	private static int obtenerNumeroAleatorio() {				
		return new Random().nextInt((BASE.length - 1));
	}

}
