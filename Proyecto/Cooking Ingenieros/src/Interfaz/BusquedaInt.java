package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import CheapDeal.Cliente;
import CheapDeal.Oferta;
import CheapDeal.Ordenacion;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import CheapDeal.Categorias;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BusquedaInt extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private String[] cabecera = { "Producto" , "Precio", "Tienda", "Puntuacion", "Distancia"};
	LinkedList<Oferta> ofertas = new LinkedList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusquedaInt frame = new BusquedaInt(null, null);
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
	public BusquedaInt(Cliente cliente, Ordenacion ord) {
		setTitle("CookingIngenieros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
		contentPane.setLayout(null);
		btnAtras.setBounds(10, 537, 89, 23);
		contentPane.add(btnAtras);
		
		JLabel lblNewLabel = new JLabel("\u00BFQue buscas?");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 108, 23);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setBounds(128, 10, 371, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.GRAY);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(638, 11, 3, 549);
		contentPane.add(separator);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Categorias.values()));
		comboBox.setToolTipText("");
		comboBox.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBox.setBounds(663, 13, 121, 23);
		contentPane.add(comboBox);
		
		
		
		JLabel lblPrecioMinimo = new JLabel("Precio minimo:");
		lblPrecioMinimo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPrecioMinimo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioMinimo.setBounds(663, 54, 121, 23);
		contentPane.add(lblPrecioMinimo);
		
		JLabel lblPrecioMaximo = new JLabel("Precio maximo:");
		lblPrecioMaximo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPrecioMaximo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioMaximo.setBounds(663, 122, 121, 23);
		contentPane.add(lblPrecioMaximo);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));
		spinner.setFont(new Font("Arial", Font.PLAIN, 15));
		spinner.setBounds(663, 156, 121, 23);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spinner_1.setFont(new Font("Arial", Font.PLAIN, 15));
		spinner_1.setBounds(663, 88, 121, 23);
		contentPane.add(spinner_1);
		
		JSlider slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setName("");
		slider.setMinorTickSpacing(1);
		slider.setMaximum(10);
		slider.setMajorTickSpacing(1);
		slider.setFont(new Font("Arial", Font.PLAIN, 15));
		slider.setBounds(638, 224, 156, 49);
		contentPane.add(slider);
		
		JLabel lblPuntuacion = new JLabel("Puntuacion:");
		lblPuntuacion.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntuacion.setBounds(663, 190, 121, 23);
		contentPane.add(lblPuntuacion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 618, 481);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OfertaVista obj = new OfertaVista(cliente, ofertas.get(table.getSelectedRowCount()-1), ord);
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
		columnModel.getColumn(4).setPreferredWidth(50);
		table.setRowHeight(40);
		table.getTableHeader().setReorderingAllowed(false);
		
		
		scrollPane.setViewportView(table);
		
		JCheckBox chckbxAplicarPuntuacion = new JCheckBox("Aplicar puntuacion");
		chckbxAplicarPuntuacion.setFont(new Font("Arial", Font.PLAIN, 15));
		chckbxAplicarPuntuacion.setBounds(648, 280, 146, 23);
		contentPane.add(chckbxAplicarPuntuacion);
		//chckbxAplicarPuntuacion.isSelected();
		
		
		JCheckBox chckbxAplicarCategoria = new JCheckBox("Aplicar categoria");
		chckbxAplicarCategoria.setFont(new Font("Arial", Font.PLAIN, 15));
		chckbxAplicarCategoria.setBounds(647, 306, 146, 23);
		contentPane.add(chckbxAplicarCategoria);
		
		JCheckBox chckbxAplicarPrecio = new JCheckBox("Aplicar precio");
		chckbxAplicarPrecio.setFont(new Font("Arial", Font.PLAIN, 15));
		chckbxAplicarPrecio.setBounds(647, 332, 146, 23);
		contentPane.add(chckbxAplicarPrecio);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ofertas = ord.getOfertasCercanas();
				ofertas = ord.filtrarNombre(ofertas, textField.getText());
				if(chckbxAplicarPuntuacion.isSelected()) {
					ofertas = ord.filtrarPuntuacion(ofertas, slider.getValue());
				}
				if(chckbxAplicarCategoria.isSelected()) {
					ofertas = ord.filtrarCategoria(ofertas, Categorias.values()[slider.getValue()]);
				}
				if(chckbxAplicarPrecio.isSelected()) {
					ofertas = ord.filtrarPrecio(ofertas, (Integer)spinner_1.getValue(), (Integer) spinner.getValue());
				}
				for(Oferta o : ofertas) {
					dtm.addRow(new Object[] { o.getProducto(), o.getDescuento(), o.getTienda().getNombre(),	
							o.getPuntuacion(), o.getTienda().getDistancia()});
				}
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(509, 11, 119, 23);
		contentPane.add(btnNewButton);
		
	}
}
