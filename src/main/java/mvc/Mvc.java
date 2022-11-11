package mvc;

import java.awt.EventQueue;
import java.sql.Connection;

import mvc.view.VentanaAdmin;
import util.ConexionP;

public class Mvc {

	public static void main(String[] args) throws Exception {
		
		//Llama a VentanaAdmin e inicia el panel seteado alli
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdmin frame = new VentanaAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		//Prueba de conexion TODO: borrar
		/*Connection con = null;
        try {
            con = ConexionP.conectarDB();
            System.out.println("PROBANDO CONEXION");
        } catch (Exception ex) {
            throw ex;
        }
        finally{
            if(con != null){
                con.close();
            }
        }*/

}
}
