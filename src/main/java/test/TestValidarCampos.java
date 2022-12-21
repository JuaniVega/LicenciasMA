package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import mvc.view.PntDarAltaTitularUI;


public class TestValidarCampos {

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() throws Exception {

		PntDarAltaTitularUI alta = new PntDarAltaTitularUI();
		String dni = "41216692";
		assertTrue(alta.validarNumerosDoc(dni));

	}

}