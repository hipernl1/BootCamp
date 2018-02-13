package co.bootcamp.exercise.palindroma;

import java.text.Normalizer;

/**
 * 
 * @author leonardo Cruz
 *
 */
public final class Frases {

	private final static String PATRON = "[^\\dA-Za-z]";

	public static Boolean isPalindromo(String frase) {
		String palabra = Normalizer.normalize(frase, Normalizer.Form.NFD).replaceAll(PATRON, "").toLowerCase();
		if (palabra.length() == 0 || palabra.length() == 1) {
			return true;
		} else if (palabra.charAt(0) == palabra.charAt(palabra.length() - 1)) {
			return isPalindromo(palabra.substring(1, palabra.length() - 1));
		} else {
			return false;
		}
	}

}
