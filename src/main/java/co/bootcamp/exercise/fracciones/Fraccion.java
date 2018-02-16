package co.bootcamp.exercise.fracciones;

public final class Fraccion {
	private final int numerador;
	private final int denominador;
	
	private Fraccion(Builder builder) {
		this(builder.numerador, builder.denominador);
	}
	
	private Fraccion(int numerador, int denominador) {
		int mcd = OperacionMatematicaUtil.mcd(numerador, denominador);
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
		return sumarORestar(fraccionSuma, true);
	}
	
	public Fraccion restar(Fraccion fraccionResta) {		
		return sumarORestar(fraccionResta, false);
	}
		
	public Fraccion multiplicar(Fraccion fraccionMultiplicador) {
		return dividirOMultiplicar(fraccionMultiplicador, true);
	}
	
	public Fraccion dividir(Fraccion fraccionDivisora) {		
		return dividirOMultiplicar(fraccionDivisora, false);
	}
	
	private Fraccion sumarORestar(Fraccion fraccion, boolean esSuma) {		
		int mcm = OperacionMatematicaUtil.mcm(this.denominador, fraccion.denominador);
		return new Fraccion(obtenerNumerador(mcm, this.denominador, this.numerador) + obtenerNumerador(mcm, (esSuma?1:-1)* fraccion.denominador, fraccion.numerador), mcm);
	}
	
	private Fraccion dividirOMultiplicar(Fraccion fraccion, boolean esMultiplicacion) {		
		return new Fraccion(this.numerador * (esMultiplicacion ? fraccion.numerador : fraccion.denominador) , 
							this.denominador * (esMultiplicacion ? fraccion.denominador : fraccion.numerador));
	}
	
	private static int obtenerNumerador(int mcm, int denominador, int numerador) {
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
