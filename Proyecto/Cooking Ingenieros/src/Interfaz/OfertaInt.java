package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import CheapDeal.Categorias;
import CheapDeal.Cliente;
import CheapDeal.Oferta;
import CheapDeal.Tienda;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.TreeMap;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class OfertaInt extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String[][] datos;
	private String[] columnas = {"Usuario", "Mensaje", "Puntuacion"};

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HashSet<Categorias> cat = new HashSet<Categorias>();cat.add(Categorias.MUEBLES);
					Tienda tienda1 = new Tienda("LaTiendaEnCasa", "Calle Ninja N� 13", "Roberto junior", 34.1235, 75.00);
					Cliente cliente1 = new Cliente("Juan","12345","juanito@gmail.com");
					Oferta of = new Oferta("Mesa", 22.5, tienda1, 50, "Una mesa muy bonita", cat);
					of.aniadirOp(cliente1, "De puta pena", 7);
					OfertaInt frame = new OfertaInt(cliente1, of);
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
	public OfertaInt(Cliente cliente, Oferta oferta) {
		setTitle("CookingIngenieros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Producto: " + oferta.getProducto());
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 774, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblPrecio = new JLabel("Precio: " + oferta.getPrecio());
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPrecio.setBounds(10, 49, 210, 27);
		contentPane.add(lblPrecio);
		
		JLabel lblDescuento = new JLabel("Descuento: " + oferta.getDescuento());
		lblDescuento.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDescuento.setBounds(230, 49, 210, 27);
		contentPane.add(lblDescuento);
		
		JLabel lblPuntuacin = new JLabel("Puntuaci\u00F3n: " + oferta.getPuntuacion());
		lblPuntuacin.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPuntuacin.setBounds(450, 49, 210, 27);
		contentPane.add(lblPuntuacin);
		
		JLabel lblTienda = new JLabel("Tienda: " + oferta.getTienda().getNombre());
		lblTienda.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTienda.setBounds(10, 87, 210, 27);
		contentPane.add(lblTienda);
		
		JButton btnIr = new JButton("Ir a tienda");
		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TiendaInt obj = new TiendaInt(cliente, oferta.getTienda());
				obj.setVisible(true);
				dispose();
			}
		});
		btnIr.setFont(new Font("Arial", Font.PLAIN, 15));
		btnIr.setBounds(230, 87, 129, 27);
		contentPane.add(btnIr);
		
		JTextArea txtrDescripcin = new JTextArea();
		txtrDescripcin.setText("Descripci\u00F3n: " + oferta.getDescripcion());
		txtrDescripcin.setFont(new Font("Arial", Font.PLAIN, 15));
		txtrDescripcin.setBounds(10, 125, 774, 194);
		txtrDescripcin.setEditable(false);;
		contentPane.add(txtrDescripcin);
		
		JLabel lblOpiniones = new JLabel("Opiniones:");
		lblOpiniones.setFont(new Font("Arial", Font.PLAIN, 15));
		lblOpiniones.setBounds(10, 330, 95, 27);
		contentPane.add(lblOpiniones);
		
		JButton button_1 = new JButton("Opinar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OpinionOf obj = new OpinionOf(cliente, oferta);
				obj.setVisible(true);
				dispose();
			}
		});
		button_1.setFont(new Font("Arial", Font.PLAIN, 15));
		button_1.setBounds(450, 87, 95, 27);
		contentPane.add(button_1);
		
		JButton btnIrAInicio = new JButton("Ir a inicio");
		btnIrAInicio.setFont(new Font("Arial", Font.PLAIN, 15));
		btnIrAInicio.setBounds(10, 527, 97, 25);
		contentPane.add(btnIrAInicio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 355, 774, 161);
		contentPane.add(scrollPane);
		
		
		TreeMap<Integer, CheapDeal.Opinion> aux = new TreeMap<Integer, CheapDeal.Opinion>(oferta.getOpiniones());
		
		
		int f = 0;
		while(aux.containsKey(f)) {
			datos[f][0] = aux.get(f).getUsuario().getUsuario();
			datos[f][1] = aux.get(f).getMensaje();
			datos[f][2] = String.valueOf(aux.get(f).getPuntuacion());
			f++;
		}
		
		

		table = new JTable(datos, columnas);
		scrollPane.setViewportView(table);
		
		/*int cont = 0;
		while(aux.containsKey(cont)) {
			Object[] fila = new Object[3];
			fila[0] = aux.get(cont).getUsuario();
			fila[1] = aux.get(cont).getMensaje();
			fila[2] = aux.get(cont).getPuntuacion();
			((DefaultTableModel) table.getModel()).addRow(fila);
			cont++;
		}
		
		
		//table.("Usuario");
	
		
		/*DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Usuario");
		modelo.addColumn("Mensaje");
		modelo.addColumn("Puntuacion");
		TreeMap<Integer, CheapDeal.Opinion> aux = new TreeMap<Integer, CheapDeal.Opinion>(oferta.getOpiniones());
		
		int cont = 0;
		while(aux.containsKey(cont)) {
			Object[] fila = new Object[3];
			fila[0] = aux.get(cont).getUsuario();
			fila[1] = aux.get(cont).getMensaje();
			fila[2] = aux.get(cont).getPuntuacion();
			modelo.addRow(fila);
			cont++;
		}
		
		
		table = new JTable(modelo);   new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Usuario", "Mensaje", "Puntuacion"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		table.setBounds(10, 356, 774, 160);
		contentPane.add(table);*/
		
		
		
		
		btnIrAInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal obj = new Principal(cliente);
				obj.setVisible(true);
				dispose();
			}
		});
		
		
	}
}
