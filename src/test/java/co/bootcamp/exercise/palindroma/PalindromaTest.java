package co.bootcamp.exercise.palindroma;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * 
 * @author leonardo Cruz
 *
 */
public class PalindromaTest {
	@Test
	public void unStringVacioEsPalíndromo() {
		assertThat(Frases.isPalindromo(""), is(true));
	}
	
	@Test
	public void unaSolaLetraESPalíndromo() {
		assertThat(Frases.isPalindromo("a"), is(true));
	}
	
	@Test
	public void abNoEsPalíndromo() {
		assertThat(Frases.isPalindromo("ab"), is(false));
	}
	
	@Test
	public void abaEsPalíndromo() {
		assertThat(Frases.isPalindromo("aba"), is(true));
	}
	
	@Test
	public void radarEsPalíndromo() {
		assertThat(Frases.isPalindromo("radar"), is(true));
	}
	
	@Test
	public void readerNoEsPalíndromo() {
		assertThat(Frases.isPalindromo("reader"), is(false));
	}
	
	@Test
	public void unStringConEspaciosNoLetrasTambienPuedeSerPalíndromo() {
		assertThat(Frases.isPalindromo("anita lava la tina"), is(true));
	}
	
	@Test
	public void unStringConEspaciosYCaracteresNoLetrasTambienPuedeSerPalíndromo() {
		assertThat(Frases.isPalindromo("¡anita, lava la tina!"), is(true));
	}
	
	@Test
	public void unStringConMayucsculasTembiénEsPalíndromo() {
		assertThat(Frases.isPalindromo("¡Anita, lava la Tina!"), is(true));
	}
	
	@Test
	public void unStringConAsentoEsPalíndromo() {
		assertThat(Frases.isPalindromo("A mamá Roma le aviva el amor a papá y a papá Roma le aviva el amor a mamá."), is(true));
	}
	
	
}
