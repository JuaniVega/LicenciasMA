package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import mvc.controller.dao.PersonaDao;
import mvc.model.Persona;
import mvc.view.PntDarAltaTitularUI;


public class TestValidarCampos {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() throws Exception {
	/*
	 * else if (!validarNumerosDoc(txtNumDocTitular.getText().trim())) {
				labelErrorDoc.setText("Ingrese correctamente el numero del Documento");
			}
	 * */
	 
		PntDarAltaTitularUI alta = new PntDarAltaTitularUI();
		String dni = "41216692";
		assertTrue(alta.validarNumerosDoc(dni));
		
	}

}