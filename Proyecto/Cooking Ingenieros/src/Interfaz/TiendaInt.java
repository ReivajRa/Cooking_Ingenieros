package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import CheapDeal.Categorias;
import CheapDeal.Cliente;
import CheapDeal.Oferta;
import CheapDeal.Opinion;
import CheapDeal.Ordenacion;
import CheapDeal.Tienda;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TiendaInt extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private String[] cabecera = { "Producto" , "Precio", "Tienda", "Puntuacion", "Distancia"};
	private String[] cabecera_1 = {"Usuario", "Mensaje" , "Puntacion"};
	ArrayList<Oferta> ofertas = new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HashSet<Categorias> cat = new HashSet<Categorias>();
					Cliente cliente1 = new Cliente("Juan","12345","juanito@gmail.com");
					Tienda tienda1 = new Tienda("LaTiendaEnCasa", "Calle Ninja Nï¿½ 13", "Roberto junior", 40.0, 50.0);
					cat.add(Categorias.MUEBLES);
					tienda1.anadirOferta("Mesa", 20.0, 400, "Una mesa muy bonita", cat);
					Oferta of = new Oferta("Mesa", 20.0, tienda1, 200.0, "La caña de españa.", cat);
					of.aniadirOp(cliente1, "Caaa", 10);
					tienda1.aniadirOp(cliente1, "Locoo esto funciona", 10);
					TiendaInt frame = new TiendaInt(cliente1, tienda1, null);
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
	public TiendaInt(Cliente cliente, Tienda tienda, Ordenacion ord) {
		setTitle("CookingIngenieros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: " + tienda.getNombre());
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre.setBounds(10, 11, 350, 32);
		contentPane.add(lblNombre);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n: " + tienda.getDireccion());
		lblDireccin.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDireccin.setBounds(10, 54, 350, 32);
		contentPane.add(lblDireccin);
		
		JLabel lblPuntuacin = new JLabel("Puntuaci\u00F3n: " + tienda.getPuntuacion());
		lblPuntuacin.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPuntuacin.setBounds(10, 97, 350, 32);
		contentPane.add(lblPuntuacin);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setBackground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(395, 127, 3, 433);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Ofertas");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(88, 127, 189, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblOpiniones = new JLabel("Opiniones");
		lblOpiniones.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpiniones.setFont(new Font("Arial", Font.PLAIN, 15));
		lblOpiniones.setBounds(497, 127, 189, 32);
		contentPane.add(lblOpiniones);
		
		JButton btnOpinar = new JButton("Opinar");
		btnOpinar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpinionTnd obj = new OpinionTnd(cliente, tienda, ord);
				obj.setVisible(true);
				dispose();
			}
		});
		btnOpinar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnOpinar.setBounds(597, 60, 89, 23);
		contentPane.add(btnOpinar);
		setLocationRelativeTo(null);
		
		JButton btnIrAInicio = new JButton("Ir a inicio");
		btnIrAInicio.setFont(new Font("Arial", Font.PLAIN, 15));
		btnIrAInicio.setBounds(10, 527, 97, 25);
		contentPane.add(btnIrAInicio);
		
		//Oferta
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 157, 375, 359);
		contentPane.add(scrollPane);
		
		ofertas = new ArrayList<>(tienda.getOfertas().values()); 
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OfertaVista obj = new OfertaVista(cliente, ofertas.get(table.getSelectedRow()), ord);
				obj.setVisible(true);
				dispose();
			}
		});
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
		columnModel.getColumn(1).setPreferredWidth(50);
		columnModel.getColumn(2).setPreferredWidth(50);
		columnModel.getColumn(3).setPreferredWidth(50);
		columnModel.getColumn(3).setPreferredWidth(50);
		table.setRowHeight(40);
		table.getTableHeader().setReorderingAllowed(false);
		
		for(Oferta o : ofertas) {
			dtm.addRow(new Object[] { o.getProducto(), o.getDescuento(), o.getTienda().getNombre(),	
			o.getPuntuacion(), Math.round(o.getTienda().getDistancia())});
		}
		
		scrollPane.setViewportView(table);
		
		//Opiniones
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(408, 157, 365, 359);
		contentPane.add(scrollPane_1);
		
		ArrayList<Opinion> opiniones = new ArrayList<>(tienda.getOpiniones().values());
		
		table_1 = new JTable();
		table_1.setFocusable(true);
		table_1.setFont(new Font("Arial" , Font.PLAIN, 15));
		DefaultTableModel dtm_1 = new DefaultTableModel(0, 3) {
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
				
			}
		};
		
		dtm_1.setColumnIdentifiers(cabecera_1);
		table_1.setModel(dtm_1);
		TableColumnModel columnModel_1 = table_1.getColumnModel();
		
		columnModel_1.getColumn(0).setPreferredWidth(30);
		columnModel_1.getColumn(1).setPreferredWidth(190);
		columnModel_1.getColumn(2).setPreferredWidth(15);
		table_1.setRowHeight(40);
		table_1.getTableHeader().setReorderingAllowed(false);
		

		for(Opinion o : opiniones) {
			dtm_1.addRow(new Object[] { o.getUsuario().getUsuario(), o.getMensaje(), 
					o.getPuntuacion()});
		}
		
		scrollPane_1.setViewportView(table_1);
		
		btnIrAInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal obj = new Principal(cliente, ord);
				obj.setVisible(true);
				dispose();
			}
		});

	}
}
