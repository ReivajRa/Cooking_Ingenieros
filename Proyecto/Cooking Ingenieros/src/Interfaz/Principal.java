package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.JList;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import CheapDeal.Cliente;
import CheapDeal.Oferta;
import CheapDeal.Ordenacion;

import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JLayeredPane;
import java.awt.Window.Type;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String[] cabecera = { "Producto" , "Precio", "Tienda", "Puntuacion", "Distancia"};
	LinkedList<Oferta> ofertasCercanas= new LinkedList<Oferta>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal(null, null);
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
	public Principal(Cliente cliente, Ordenacion ord) {
		setResizable(false);
		setTitle("CookingIngenieros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(800, 600, 0, 0));
		contentPane.setForeground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnCliente = new JButton("Mi perfil");
		btnCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PerfilInt obj = new PerfilInt(cliente, ord);
				obj.setVisible(true);
				dispose();	
			}
		});
		btnCliente.setBounds(552, 227, 200, 100);
		contentPane.add(btnCliente);
		
		JButton btnTiendas = new JButton("Tiendas cercanas");
		btnTiendas.setFont(new Font("Arial", Font.PLAIN, 15));
		btnTiendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TiendasInt obj = new TiendasInt(cliente, ord);
				obj.setVisible(true);
				dispose();
				}
		});
		btnTiendas.setBounds(552, 378, 200, 100);
		contentPane.add(btnTiendas);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusquedaInt obj = new BusquedaInt(cliente, ord);
				obj.setVisible(true);
				dispose();
				}
		});
		btnBuscar.setBounds(552, 75, 200, 100);
		contentPane.add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(500, 13, 3, 527);
		contentPane.add(separator);
		
		
		
		JLabel lblNewLabel = new JLabel("OFERTAS CERCANAS");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel.setBounds(130, 13, 250, 25);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 480, 491);
		contentPane.add(scrollPane);
		

		ofertasCercanas = ord.getOfertasCercanas();
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OfertaVista obj = new OfertaVista(cliente, ofertasCercanas.get(table.getSelectedRowCount()-1), ord);
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
		
		columnModel.getColumn(0).setPreferredWidth(100);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(100);
		columnModel.getColumn(3).setPreferredWidth(100);
		columnModel.getColumn(4).setPreferredWidth(100);
		table.setRowHeight(40);
		table.getTableHeader().setReorderingAllowed(false);
		
		for(Oferta o : ofertasCercanas) {
			dtm.addRow(new Object[] { o.getProducto(), o.getDescuento(), o.getTienda().getNombre(),	
			o.getPuntuacion(), o.getDistancia()});
		}
		scrollPane.setViewportView(table);
		
		JButton btnCerraSesion = new JButton("Cerrar sesion");
		btnCerraSesion.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCerraSesion.setBounds(552, 537, 200, 23);
		contentPane.add(btnCerraSesion);
		btnCerraSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login obj = new Login();
				obj.setVisible(true);
				dispose();
			}
		});
		
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnBuscar, btnCliente, btnTiendas}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, btnBuscar, btnCliente, btnTiendas}));
	}
}
