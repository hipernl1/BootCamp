package co.bootcamp.exercise.fracciones;

public final class Fraccion {
	private final int numerador;
	private final int denominador;
	
	private Fraccion(Builder builder) {
		this(builder.numerador, builder.denominador);
	}
	
	private Fraccion(int numerador, int denominador) {
		int mcd = FraccionUtil.mcd(numerador, denominador);
		this.numerador = numerador / mcd;
		this.denominador = denominador / mcd;		
	}
	
	public static class Builder{
		private int numerador;
		private int denominador;
		
		public Builder conNumerador(int numerador) {
			this.numerador = numerador;
			return this;
		}
		
		public Builder conDenominador(int denominador) {
			if(denominador == 0) {
				throw new IllegalArgumentException("El objeto debe tener denominador mayor a cero.");
			}			
			this.denominador = denominador;
			return this;
		}
		
		public Fraccion build() {
			return new Fraccion(this); 
		}
	}

	public Fraccion sumar(Fraccion fraccionSuma) {		
		int mcm = FraccionUtil.mcm(this.denominador, fraccionSuma.denominador);
		return new Fraccion(obtenerNumerador(mcm, this.denominador, this.numerador) + obtenerNumerador(mcm, fraccionSuma.denominador, fraccionSuma.numerador), mcm);
	}
	
	public Fraccion restar(Fraccion fraccionResta) {		
		int mcm = FraccionUtil.mcm(this.denominador, fraccionResta.denominador);
		return new Fraccion(obtenerNumerador(mcm, this.denominador, this.numerador) - obtenerNumerador(mcm, fraccionResta.denominador, fraccionResta.numerador), mcm);
	}
	
	public Fraccion multiplicar(Fraccion fraccionMultiplicador) {		
		return new Fraccion(this.numerador * fraccionMultiplicador.numerador , this.denominador * fraccionMultiplicador.denominador);
	}
	
	public Fraccion dividir(Fraccion fraccionDivisora) {		
		return new Fraccion(this.numerador * fraccionDivisora.denominador, this.denominador * fraccionDivisora.numerador);
	}
	
	private int obtenerNumerador(int mcm, int denominador, int numerador) {
		return (mcm/denominador)*numerador;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + denominador;
		result = prime * result + numerador;
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
		Fraccion other = (Fraccion) obj;
		if (denominador != other.denominador)
			return false;
		if (numerador != other.numerador)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fraccion [numerador=" + numerador + ", denominador=" + denominador + "]";
	}

	
}
