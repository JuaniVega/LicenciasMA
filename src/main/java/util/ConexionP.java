package util;

import java.sql.*;

public class ConexionP {
	
	private static final String url = "jdbc:postgresql://localhost:5432/postgres";
	private static final String user = "postgres";
	private static final String pass = "postgres";
	
	public ConexionP() {
		
	}
	
	static Connection conexion = null;
	static Statement sentencia;
	
	public static Connection conectarDB() {
		try {
			Class.forName("org.postgresql.Driver");
			conexion = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexion exitosa");
		} catch (Exception e) {
			System.out.println("Error en la conexion a la BDD");
		}
		return conexion;
	}
	
    public static ResultSet consultarDatos(String query) throws Exception {
    	Connection con = null;
    	ResultSet rs = null;
        try {
            con =ConexionP.conectarDB();
            PreparedStatement pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
        }catch (Exception ex) {
        	throw ex;
		}
        finally{
            if(con != null){
                con.close();
            }
        }
        return rs;
    }
	
	// Metodo que ejecuta una acci�n en la BDD (insertar, eliminar etc.)
	
	public static void ejecutar(String query) throws Exception{
        Connection con = null;
        try {
            con = ConexionP.conectarDB();
            con.createStatement().executeUpdate(query);
        } catch (Exception ex) {
            throw ex;
        }
        finally{
            if(con != null){
                con.close();
            }
        }
	}
    

}
