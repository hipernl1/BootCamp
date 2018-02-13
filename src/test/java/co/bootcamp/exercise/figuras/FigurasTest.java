package co.bootcamp.exercise.figuras;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import co.bootcamp.exercise.figuras.util.FiguraUtil;

public class FigurasTest {
	
	@Test
	public void generarCuadradoStandar() {				
		assertThat(Figuras.generarCuadrado(3), 
							  equalTo(new StringBuilder("***").append(FiguraUtil.SALTO_LINEA)
											    .append("***").append(FiguraUtil.SALTO_LINEA)
											    .append("***").append(FiguraUtil.SALTO_LINEA).toString()));
	}
	
	@Test
	public void generarCuadrado4x4() {
		assertThat(Figuras.generarCuadrado(4), 
							  equalTo(new StringBuilder("****").append(FiguraUtil.SALTO_LINEA)
												.append("****").append(FiguraUtil.SALTO_LINEA)
												.append("****").append(FiguraUtil.SALTO_LINEA)
												.append("****").append(FiguraUtil.SALTO_LINEA).toString()));
	}
	
	@Test
	public void generarTrianguloStandar() {		
		assertThat(Figuras.generarTriangulo(3), 
							  equalTo(new StringBuilder("  *").append(FiguraUtil.SALTO_LINEA)
												.append(" ***").append(FiguraUtil.SALTO_LINEA)
												.append("*****").append(FiguraUtil.SALTO_LINEA).toString()));
	}
	
	@Test
	public void generarTriangulo4() {
		assertThat(Figuras.generarTriangulo(4), 
							  equalTo(new StringBuilder("   *").append(FiguraUtil.SALTO_LINEA)
												.append("  ***").append(FiguraUtil.SALTO_LINEA)
												.append(" *****").append(FiguraUtil.SALTO_LINEA)
											    .append("*******").append(FiguraUtil.SALTO_LINEA).toString()));
	}
	
	@Test
	public void generarRomboStandar() {
		assertThat(Figuras.generarRombo(3), 
							  equalTo(new StringBuilder("  *").append(FiguraUtil.SALTO_LINEA)
												.append(" ***").append(FiguraUtil.SALTO_LINEA)
												.append("*****").append(FiguraUtil.SALTO_LINEA)
												.append(" ***").append(FiguraUtil.SALTO_LINEA)
												.append("  *").append(FiguraUtil.SALTO_LINEA).toString()));
	}
	
	@Test
	public void generarRombo4() {
		assertThat(Figuras.generarRombo(4), 
							  equalTo(new StringBuilder("   *").append(FiguraUtil.SALTO_LINEA)
												.append("  ***").append(FiguraUtil.SALTO_LINEA)
												.append(" *****").append(FiguraUtil.SALTO_LINEA)
											    .append("*******").append(FiguraUtil.SALTO_LINEA)
											    .append(" *****").append(FiguraUtil.SALTO_LINEA)
											    .append("  ***").append(FiguraUtil.SALTO_LINEA)
											    .append("   *").append(FiguraUtil.SALTO_LINEA).toString()));
	}

}
