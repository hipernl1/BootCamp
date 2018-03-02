package co.bootcamp.exercise.picasfijas.util;

public class Resultado {
	private int picas;
	private int fijas;
	private boolean ganador;

	public Resultado(boolean ganador) {
		this(0, 0);
		this.ganador = ganador;
	}
	
	public Resultado() {
		this(0, 0);
	}

	public Resultado(int picas, int fijas) {
		this.picas = picas;
		this.fijas = fijas;
		this.ganador = false;
	}

	public int getPicas() {
		return picas;
	}

	public int getFijas() {
		return fijas;
	}

	public boolean isGanador() {
		return ganador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fijas;
		result = prime * result + picas;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resultado other = (Resultado) obj;
		if (fijas != other.fijas)
			return false;
		if (picas != other.picas)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Resultado [picas=" + picas + ", fijas=" + fijas + "]";
	}

}
