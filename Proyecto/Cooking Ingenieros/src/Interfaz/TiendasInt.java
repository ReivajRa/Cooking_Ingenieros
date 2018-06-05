package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import CheapDeal.Cliente;
import CheapDeal.Oferta;
import CheapDeal.Ordenacion;
import CheapDeal.Tienda;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TiendasInt extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String[] cabecera = { "Nombre" , "Direccion", "Puntuacion", "Distancia"};
	LinkedList<Tienda> tiendasCercanas= new LinkedList<Tienda>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TiendasInt frame = new TiendasInt(null, null);
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
	public TiendasInt(Cliente cliente, Ordenacion ord) {
		setTitle("CookingIngenieros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal obj = new Principal(cliente, ord);
				obj.setVisible(true);
				dispose();
			}
		});
		
		contentPane.setLayout(null);
		btnAtras.setBounds(10, 537, 89, 23);
		contentPane.add(btnAtras);
		
		JLabel lblNewLabel = new JLabel("TIENDAS CERCANAS");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel.setBounds(272, 11, 250, 25);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 47, 774, 479);
		contentPane.add(scrollPane);
		

		tiendasCercanas = ord.getTiendasCercanas();
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TiendaInt obj = new TiendaInt(cliente, tiendasCercanas.get(table.getSelectedRow()), ord);
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
		table.setRowHeight(40);
		table.getTableHeader().setReorderingAllowed(false);
		
		for(Tienda o : tiendasCercanas) {
			dtm.addRow(new Object[] { o.getNombre() , o.getDireccion(),	
			o.getPuntuacion(), o.getDistancia()});
		}
		
			
		scrollPane.setViewportView(table);
	}
}
