package co.bootcamp.exercise.picasfijas;

import java.util.Scanner;

import co.bootcamp.exercise.picasfijas.service.PicasAndFijasService;

public class Juego {
	private static int INTENTOS = 6;	
	
	public static void main(String... args) {
		Scanner leer = new Scanner(System.in);
		PicasAndFijasService picasAndFijasService = new PicasAndFijasService(leer, INTENTOS);
		picasAndFijasService.jugar();
	}

	

}
