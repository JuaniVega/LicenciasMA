package mvc.view;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;


public class VentanaAdmin extends JFrame {

	public static JPanel contentPane;
	
	/*DEFINIMOS TODAS LAS VISTAS QUE VAYAMOS A PONER EN EL PANEL*/
	public static PntCrearLicencia pntCrearLicencia= new PntCrearLicencia();
	public static PntImprimirLicencia pntImprimirLicencia= new PntImprimirLicencia();
	public static PntDarAltaTitularUI pntDarAltaTitularUI= new PntDarAltaTitularUI();
	public static PntEmitirCopia pntEmitirCopia= new PntEmitirCopia();
	
	private static Dimension sizePnt;
	private static CardLayout cl= new CardLayout();
	
	/*DEFINIMOS EL NOMBRE TODAS LAS VISTAS QUE VAYAMOS A PONER EN EL PANEL*/
	public static String n_pntCrearLicencia = "n_pntCrearLicencia";
	public static String n_pntImprimirLicencia = "n_pntImprimirLicencia";
	public static String n_pntDarAltaTitularUI = "n_pntDarAltaTitularUI";
	public static String n_pntEmitirCopia = "n_pntEmitirCopia";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public VentanaAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setTitle("Sistema gestor de licencias");
		contentPane.setLayout(cl); // pasa al contentPane el CardLayout que creamos
	
		sizePnt = contentPane.getSize() ;
		
		//cambiarPantalla(pntCrearLicencia, n_pntCrearLicencia);
		//cambiarPantalla(pntImprimirLicencia, n_pntImprimirLicencia);
		//cambiarPantalla(pntDarAltaTitularUI, n_pntDarAltaTitularUI);
		cambiarPantalla(pntEmitirCopia, n_pntEmitirCopia);
	}
	
	public static void cambiarPantalla(JPanel panel, String nombrePnt) {
		contentPane.add(nombrePnt, panel); //Agrego la pantalla a contentPane, previamente debe estar inicializada
		panel.setSize(sizePnt);
		cl.show(contentPane, nombrePnt); // show: muestra esa Pnt en ese contenedor
		contentPane.revalidate(); // "limpiar el contenedor o VentanaAdmin"
		contentPane.repaint(); // "repintar el contenedor"		
	}
	//prueba
	//Ventana de buscar por DNI
	public static String mensajeBusqueda(String[] args, String mensaje) {
		String val =JOptionPane.showInputDialog(
					mensaje,
					JOptionPane.QUESTION_MESSAGE);  // el icono sera un iterrogante
		
		return val;
	}
	
	//Ventana emergente de error
		public static void mensajeError(String error, String titulo) {
			// TODO Auto-generated method stub
			if (JOptionPane.showConfirmDialog(null, error, titulo, 
				JOptionPane.PLAIN_MESSAGE, 
				JOptionPane.ERROR_MESSAGE)==0);
		}
	
}