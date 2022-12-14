package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import mvc.controller.dao.PersonaDao;
import mvc.model.Persona;


public class TestUpdateDonante {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() throws Exception {

        PersonaDao persona = new PersonaDao();
        Integer dni = 41216693;
        
       List<Persona> list = new ArrayList<Persona>();
        //boolean b= false;
        list= persona.getPersonaxEsDonante(true);
        
        for(int f=0;f<list.size();f++){
            if(list.get(f).getDni().equals(dni)){
            
                persona.updateConductorDonante(list.get(f).getDni(), false);
            }
        }
        PersonaDao personaActualizada = new PersonaDao();
        assertEquals(personaActualizada.getConductorxDni(dni).get(0).getDonaOrganos(), false); 

    }

}