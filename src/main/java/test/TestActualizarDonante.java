package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import mvc.controller.dao.PersonaDao;
import mvc.controller.dto.EmitirLicenciaDTO;
import mvc.controller.gestores.GestorPersona;
import mvc.model.Persona;


public class TestActualizarDonante {
	
	private EmitirLicenciaDTO emitirLicenciaDTO = new EmitirLicenciaDTO();

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() throws Exception {

        Integer dni = 41216693;

       List<Persona> list = new ArrayList<Persona>();
        list= GestorPersona.obtenerPersonaxEsDonante(true);

        for(int f=0;f<list.size();f++){
            if(list.get(f).getDni().equals(dni)){
            	cargarEmitirLicenciaDTO(list.get(f).getDni(), false);

                GestorPersona.actualizarConductorDonante(emitirLicenciaDTO);
            }
        }
        assertEquals(GestorPersona.obtenerConductorxDni(dni).get(0).getDonaOrganos(), false); 

    }

	private void cargarEmitirLicenciaDTO(Integer dni, boolean b) {
		emitirLicenciaDTO.setNumDoc(dni);
		emitirLicenciaDTO.setEsDonante(b);
	}

}
