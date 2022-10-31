package mvc;

import java.awt.EventQueue;
import java.sql.Connection;

import view.VentanaAdmin;
import util.ConexionP;

public class Mvc {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
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
		
		Connection con = null;
        try {
            con = ConexionP.conectarDB();
            System.out.println("HOLA MUNDI");
        } catch (Exception ex) {
            throw ex;
        }
        finally{
            if(con != null){
                con.close();
            }
        }
        
      /*  String query= "INSERT INTO public.tipo_documento  (id, tipo_doc  , fecha_ult_mod , usuario) VALUES (1, 'dni', '02/06/88', 'aaa');";
		con = ConexionP.conectarDB();
		try {
			//Comienza transacción
			con.setAutoCommit(false);
			
			con.createStatement().executeUpdate(query);
			
			con.commit();
		}
		catch (Exception e) {
		System.err.println("ERROR: " + e.getMessage());
		try {
			//deshace todos los cambios realizados en los datos
			con.rollback();
			} catch (SQLException ex1) {
				System.err.println( "No se pudo deshacer" + ex1.getMessage() );    
				}
        finally{
            if(con != null){
                con.close();
            }
		}
	}*/

}
}
