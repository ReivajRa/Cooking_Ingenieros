package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CheapDeal.Categorias;
import CheapDeal.Cliente;
import CheapDeal.Oferta;
import CheapDeal.Opinion;
import CheapDeal.Ordenacion;
import CheapDeal.Tienda;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.DataBufferFloat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OfertaVista extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String[] cabecera = {"Usuario", "Mensaje" , "Puntacion"};
	
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				HashSet<Categorias> cat = new HashSet<Categorias>();
		Cliente cliente1 = new Cliente("Juan","12345","juanito@gmail.com");
		Tienda tienda1 = new Tienda("LaTiendaEnCasa", "Calle Ninja N� 13", "Roberto junior", 40.0, 50.0);
		cat.add(Categorias.MUEBLES);
		Oferta of = new Oferta("Mesa", 20.0, tienda1, 200.0, "La ca�a de espa�a.", cat);
		of.aniadirOp(cliente1, "Caaa", 10);
		OfertaVista frame = new OfertaVista(cliente1 , of, null);
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
	public OfertaVista(Cliente cliente, Oferta oferta, Ordenacion ord) {
		setTitle("CookingIngenieros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: " + oferta.getProducto());
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre.setBounds(10, 11, 774, 31);
		contentPane.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio: " + oferta.getPrecio());
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPrecio.setBounds(10, 53, 220, 31);
		contentPane.add(lblPrecio);
		
		JLabel lblDescuento = new JLabel("Descuento: " + oferta.getDescuento());
		lblDescuento.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDescuento.setBounds(240, 53, 220, 31);
		contentPane.add(lblDescuento);
		
		JLabel lblPuntuacion = new JLabel("Puntuacion: " + oferta.getPuntuacion());
		lblPuntuacion.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPuntuacion.setBounds(470, 53, 220, 31);
		contentPane.add(lblPuntuacion);
		
		JLabel lblTienda = new JLabel("Tienda: " + oferta.getTienda().getNombre());
		lblTienda.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTienda.setBounds(10, 95, 220, 31);
		contentPane.add(lblTienda);
		
		JTextPane txtpnDescripcion = new JTextPane();
		txtpnDescripcion.setEditable(false);
		txtpnDescripcion.setFont(new Font("Arial", Font.PLAIN, 15));
		txtpnDescripcion.setText("Descripcion: " + oferta.getDescripcion());
		txtpnDescripcion.setBounds(10, 137, 774, 139);
		
		contentPane.add(txtpnDescripcion);
		
		JLabel lblOpiniones = new JLabel("Opiniones:");
		lblOpiniones.setFont(new Font("Arial", Font.PLAIN, 15));
		lblOpiniones.setBounds(10, 287, 220, 31);
		contentPane.add(lblOpiniones);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 329, 774, 171);
		contentPane.add(scrollPane);
		
		ArrayList<Opinion> opiniones = new ArrayList<>(oferta.getOpiniones().values());
		
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
		
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(550);
		columnModel.getColumn(2).setPreferredWidth(10);
		table.setRowHeight(40);
		table.getTableHeader().setReorderingAllowed(false);
		
		for(Opinion o : opiniones) {
			dtm.addRow(new Object[] { o.getUsuario().getUsuario(), o.getMensaje(), 
			o.getPuntuacion()});
		}
		scrollPane.setViewportView(table);
		
		JButton btnIrAInicio = new JButton("Ir a inicio");
		btnIrAInicio.setFont(new Font("Arial", Font.PLAIN, 15));
		btnIrAInicio.setBounds(10, 527, 97, 25);
		contentPane.add(btnIrAInicio);
		
		JButton btnIrATienda = new JButton("Ir a tienda");
		btnIrATienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TiendaInt obj = new TiendaInt(cliente, oferta.getTienda(), ord);
				obj.setVisible(true);
				dispose();
			}
		});
		btnIrATienda.setFont(new Font("Arial", Font.PLAIN, 15));
		btnIrATienda.setBounds(240, 95, 140, 25);
		contentPane.add(btnIrATienda);
		
		JButton btnOpinar = new JButton("Opinar");
		btnOpinar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpinionOf obj = new OpinionOf(cliente, oferta, ord);
				obj.setVisible(true);
				dispose();
			}
		});
		btnOpinar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnOpinar.setBounds(470, 95, 97, 25);
		contentPane.add(btnOpinar);
		btnIrAInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal obj = new Principal(cliente, ord);
				obj.setVisible(true);
				dispose();
			}
		});
	}
	
	
}
