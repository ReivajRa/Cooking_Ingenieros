package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CheapDeal.Cliente;
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

public class BusquedaInt extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusquedaInt frame = new BusquedaInt(null);
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
	public BusquedaInt(Cliente cliente) {
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
				Principal obj = new Principal(cliente);
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
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(509, 11, 119, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblPrecioMinimo = new JLabel("Precio minimo:");
		lblPrecioMinimo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPrecioMinimo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioMinimo.setBounds(663, 215, 121, 23);
		contentPane.add(lblPrecioMinimo);
		
		JLabel lblPrecioMaximo = new JLabel("Precio maximo:");
		lblPrecioMaximo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPrecioMaximo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioMaximo.setBounds(663, 283, 121, 23);
		contentPane.add(lblPrecioMaximo);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));
		spinner.setFont(new Font("Arial", Font.PLAIN, 15));
		spinner.setBounds(663, 317, 121, 23);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spinner_1.setFont(new Font("Arial", Font.PLAIN, 15));
		spinner_1.setBounds(663, 249, 121, 23);
		contentPane.add(spinner_1);
		
		JSlider slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setName("");
		slider.setMinorTickSpacing(1);
		slider.setMaximum(10);
		slider.setMajorTickSpacing(1);
		slider.setFont(new Font("Arial", Font.PLAIN, 15));
		slider.setBounds(638, 423, 156, 49);
		contentPane.add(slider);
		
		JLabel lblPuntuacion = new JLabel("Puntuacion:");
		lblPuntuacion.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntuacion.setBounds(663, 374, 121, 23);
		contentPane.add(lblPuntuacion);
	}
}
