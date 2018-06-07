package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.mockito.internal.matchers.Or;

import CheapDeal.Categorias;
import CheapDeal.Cliente;
import CheapDeal.Oferta;
import CheapDeal.Opinion;
import CheapDeal.Ordenacion;
import CheapDeal.Tienda;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PerfilInt extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String[] cabecera = {"Tienda", "Oferta", "Mensaje" , "Puntacion"};


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente cliente1 = new Cliente("Juan","12345","juanito@gmail.com");
					HashSet<Categorias> cat = new HashSet<Categorias>();
					Tienda tienda1 = new Tienda("LaTiendaEnCasa", "Calle Ninja Nï¿½ 13", "Roberto junior", 40.0, 50.0);
					cat.add(Categorias.MUEBLES);
					Oferta of = new Oferta("Mesa", 20.0, tienda1, 200.0, "La caña de españa.", cat);
					of.aniadirOp(cliente1, "Caaa", 10);
					PerfilInt frame = new PerfilInt(cliente1, null);
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
	public PerfilInt(Cliente cliente, Ordenacion ord) {
		setTitle("CookingIngenieros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal obj = new Principal(cliente, ord);
				obj.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(10, 537, 89, 23);
		contentPane.add(btnAtras);
		
		JLabel lblNombre = new JLabel("Nombre: " + cliente.getUsuario());
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre.setBounds(74, 47, 315, 31);
		contentPane.add(lblNombre);
		
		JLabel lblReputacion = new JLabel("Reputacion: " + cliente.getReputacion());
		lblReputacion.setFont(new Font("Arial", Font.PLAIN, 15));
		lblReputacion.setBounds(74, 89, 315, 31);
		contentPane.add(lblReputacion);
		
		JLabel lblSeguidores = new JLabel("Seguidores: " + cliente.getSeguidores().size());
		lblSeguidores.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSeguidores.setBounds(74, 131, 315, 31);
		contentPane.add(lblSeguidores);
		
		JLabel lblSeguidos = new JLabel("Seguidos: " + cliente.getSeguidos().size());
		lblSeguidos.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSeguidos.setBounds(74, 173, 315, 31);
		contentPane.add(lblSeguidos);
		
		JLabel lblMisOpiniones = new JLabel("Mis opiniones");
		lblMisOpiniones.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMisOpiniones.setBounds(348, 235, 97, 23);
		contentPane.add(lblMisOpiniones);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 269, 760, 257);
		contentPane.add(scrollPane);
		
		HashSet<Opinion> opiniones = new HashSet<>(cliente.getOpiniones());
		table = new JTable();
		table.setFocusable(false);
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		DefaultTableModel dtm = new DefaultTableModel(0, 3) {
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
				
			}
		};
		dtm.setColumnIdentifiers(cabecera);
		table.setModel(dtm);
		
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(60);
		columnModel.getColumn(1).setPreferredWidth(60);
		columnModel.getColumn(2).setPreferredWidth(500);
		columnModel.getColumn(3).setPreferredWidth(10);
		table.setRowHeight(40);
		table.getTableHeader().setReorderingAllowed(false);
		
		for(Opinion o : opiniones) {
			if(o.getOferta() != null){
				dtm.addRow(new Object[] {o.getTienda().getNombre(), o.getOferta().getProducto(), o.getMensaje(), 
				o.getPuntuacion()});
				
			} else {
				dtm.addRow(new Object[] { o.getTienda().getNombre(), "", o.getMensaje(), 
				o.getPuntuacion()});
			}
			
			
			
			
		}
		
		
		scrollPane.setViewportView(table);
	}
}
