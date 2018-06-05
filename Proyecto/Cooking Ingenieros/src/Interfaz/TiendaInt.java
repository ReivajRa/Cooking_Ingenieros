package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CheapDeal.Cliente;
import CheapDeal.Tienda;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TiendaInt extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda tienda1 = new Tienda("LaTiendaEnCasa", "Calle Ninja N� 13", "Roberto junior", 34.1235, 75.00);
					Cliente cliente1 = new Cliente("Juan","12345","juanito@gmail.com");

					TiendaInt frame = new TiendaInt(cliente1, tienda1);
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
	public TiendaInt(Cliente cliente, Tienda tienda) {
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
		
		JList list = new JList();
		list.setBounds(10, 171, 375, 343);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(408, 171, 376, 343);
		contentPane.add(list_1);
		
		JButton btnOpinar = new JButton("Opinar");
		btnOpinar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpinionTnd obj = new OpinionTnd(cliente, tienda);
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
		btnIrAInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal obj = new Principal(cliente);
				obj.setVisible(true);
				dispose();
			}
		});

	}
}
