package mvc.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import mvc.controller.dao.LicenciaDao;
import mvc.model.Licencia;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Panel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PntBuscarConductor extends JPanel{
	private JTextField tfNumeroDoc;
	private JTextField tfNombreAdm;
	private JTextField tfApellidoAdm;
	private JLabel lblErrorNumeroDoc;
	private JLabel lblErrorTipoDoc;
	
	public PntBuscarConductor() {
		
		
		
 		setBackground(UIManager.getColor("Button.background"));  
 		setPreferredSize(new Dimension(980, 650));
 		setLayout(null);
 		
 		JPanel PaneDocumento = new JPanel();
 		PaneDocumento.setToolTipText("Documento ");
 		PaneDocumento.setBorder(new TitledBorder(null, "Documento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
 		PaneDocumento.setBounds(76, 152, 806, 86);
 		add(PaneDocumento);
 		PaneDocumento.setLayout(null);
 		
 		JLabel lblTipoDocConductor = new JLabel("Tipo (*)");
 		lblTipoDocConductor.setBounds(115, 39, 73, 14);
 		PaneDocumento.add(lblTipoDocConductor);
 		
 		JLabel lblNumDocConductor = new JLabel("Numero (*)");
 		lblNumDocConductor.setBounds(385, 39, 111, 14);
 		PaneDocumento.add(lblNumDocConductor);
 		
 		tfNumeroDoc = new JTextField();
 		tfNumeroDoc.setBounds(483, 36, 156, 20);
 		PaneDocumento.add(tfNumeroDoc);
 		tfNumeroDoc.setColumns(10);
 		
 		final JComboBox cbTipoDoc = new JComboBox();
 		cbTipoDoc.setModel(new DefaultComboBoxModel(new String[] {"- Seleccione -", "DNI", "LC", "LE"}));
 		cbTipoDoc.setBounds(198, 35, 125, 22);
 		PaneDocumento.add(cbTipoDoc);
 		
 		lblErrorNumeroDoc = new JLabel("");
 		lblErrorNumeroDoc.setForeground(Color.RED);
 		lblErrorNumeroDoc.setBounds(407, 64, 247, 14);
 		PaneDocumento.add(lblErrorNumeroDoc);
 		
 		lblErrorTipoDoc = new JLabel("");
 		lblErrorTipoDoc.setForeground(Color.RED);
 		lblErrorTipoDoc.setBounds(104, 64, 260, 14);
 		PaneDocumento.add(lblErrorTipoDoc);
 		
 		JTextPane txtpnAltaTitular = new JTextPane();
 		txtpnAltaTitular.setText("MODIFICAR DATOS DEL CONDUCTOR");
 		txtpnAltaTitular.setBounds(197, 54, 686, 42);
 		txtpnAltaTitular.setFont(new Font("Tahoma", Font.BOLD, 30));
 		txtpnAltaTitular.setEditable(false);
 		txtpnAltaTitular.setBackground(SystemColor.menu);
 		txtpnAltaTitular.setBounds(197, 54, 686, 42);
 		add(txtpnAltaTitular);
 		
 
 		
 		JPanel PaneDatosAdmi = new JPanel();
 		PaneDatosAdmi.setToolTipText("Datos Administrativo ");
 		PaneDatosAdmi.setBorder(new TitledBorder(null, "Datos Administrativo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
 		PaneDatosAdmi.setBounds(76, 270, 806, 202);
 		add(PaneDatosAdmi);
 		PaneDatosAdmi.setLayout(null);
 		
 		JLabel lblNombreAdm = new JLabel("Nombre Completo (*)");
 		lblNombreAdm.setBounds(66, 72, 133, 14);
 		PaneDatosAdmi.add(lblNombreAdm);
 		
 		tfNombreAdm = new JTextField();
 		tfNombreAdm.setBounds(226, 69, 193, 20);
 		PaneDatosAdmi.add(tfNombreAdm);
 		tfNombreAdm.setColumns(10);
 		
 		JLabel lblNewLabel_1 = new JLabel("Fecha de Emision (*)");
 		lblNewLabel_1.setBounds(66, 136, 156, 14);
 		PaneDatosAdmi.add(lblNewLabel_1);
 		
 		JDateChooser dateChooser = new JDateChooser();
 		dateChooser.setDateFormatString("dd/mm/yyyy\r\n");
 		dateChooser.setBounds(226, 130, 193, 20);
 		PaneDatosAdmi.add(dateChooser);
 		
 		JLabel lblApellidoAdm = new JLabel("Apellido(s) (*)");
 		lblApellidoAdm.setBounds(455, 72, 123, 14);
 		PaneDatosAdmi.add(lblApellidoAdm);
 		
 		tfApellidoAdm = new JTextField();
 		tfApellidoAdm.setBounds(563, 69, 171, 20);
 		PaneDatosAdmi.add(tfApellidoAdm);
 		tfApellidoAdm.setColumns(10);
 		
 		JButton btnBuscarConductor = new JButton("Buscar");
 		btnBuscarConductor.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				
 				limpiarCamposErrores();
 				
 				if (cbTipoDoc.getSelectedItem().equals("- Seleccione -")) {
 					lblErrorTipoDoc.setText("Por favor, seleccione el Tipo de Documento");
 				}
 				else if (tfNumeroDoc.getText().isEmpty()) { 
 					lblErrorNumeroDoc.setText("Por favor, ingrese el numero de Documento" );
 				}
 				else if (!validarCampos(tfNumeroDoc.getText().trim())) {
 					lblErrorNumeroDoc.setText("Por favor, ingrese solo numeros" );
 				}
 			}
 		});
 		
 		btnBuscarConductor.setBounds(794, 547, 112, 47);
 		add(btnBuscarConductor);
 		
 		JButton btnNewButton = new JButton("Cancelar");
 		btnNewButton.setBounds(614, 547, 112, 47);
 		add(btnNewButton);
 		
 		
 		 	
	
	/*public static List<Licencia> obtenerLicenciaxDnixTipo(int dni, int tipo) throws Exception{
		return LicenciaDao.getLicenciaxDnixTipo(dni, tipo);
		}*/
	}
	protected void limpiarCamposErrores() {
		//definir todos los label de los errores 
		lblErrorNumeroDoc.setText("");
		
	}
	public static boolean validarCampos(String datos) {
		return datos.matches("[0-9] {8,10}");
	}
	
}
