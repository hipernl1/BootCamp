package co.bootcamp.exercise.fracciones;

public final class FraccionUtil {

	public static int mcd(final int a, final int b) {
		return b == 0 ? a : mcd(b, a % b);
	}

	public static int mcm(final int a,final int b) {
		return (a * b) / mcd(a, b);
	}

}
