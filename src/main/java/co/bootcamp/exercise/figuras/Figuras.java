package co.bootcamp.exercise.figuras;

import co.bootcamp.exercise.figuras.util.FiguraUtil;

public final class Figuras {
	
	public static String generarCuadrado(int tamaño) {
		StringBuilder cuadrado = new StringBuilder();
		cuadrado.append(generarFigura(tamaño, 0, tamaño, 0, 0));
		return cuadrado.toString();
	}
	
	public static String generarTriangulo(int tamaño) {
		StringBuilder triangulo = new StringBuilder();
		triangulo.append(generarFigura(tamaño, tamaño - 1, 1, -1, +2));
		return triangulo.toString();
	}
	
	public static String generarRombo(int tamaño) {
		StringBuilder rombo = new StringBuilder();
		rombo.append(generarTriangulo(tamaño))
			 .append(generarFigura(tamaño - 1, 1, (tamaño * 2 -3), +1, -2));		
		return rombo.toString();
	}
	
	public static String generarFigura(int tamaño, int espacios,int caracteres, int modificadorEspacios, int modificadorCaracteres) {
		StringBuilder figura = new StringBuilder();
		for (int filas = 0; filas < tamaño; ++filas) {
			figura.append(dibujarCaracter(espacios, FiguraUtil.ESPACIO))
					.append(dibujarCaracter(caracteres, FiguraUtil.CARACTER))
					.append(FiguraUtil.SALTO_LINEA);
			espacios += modificadorEspacios;
			caracteres += modificadorCaracteres;
		}
		return figura.toString();
	}
	
	private static String dibujarCaracter(int cantidad, char caracter) {
		StringBuilder renglon = new StringBuilder(); 
		for (int columnas = 0; columnas < cantidad; ++columnas) {
			renglon.append(caracter);
		} 
		return renglon.toString();
	}

}
