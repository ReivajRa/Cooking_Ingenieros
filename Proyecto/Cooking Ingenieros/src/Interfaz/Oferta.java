package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CheapDeal.Cliente;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Oferta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Oferta frame = new Oferta(null, null);
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
	public Oferta(Cliente cliente, CheapDeal.Oferta oferta) {
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
		
		JLabel lblTienda = new JLabel("Tienda: " + oferta.getTienda());
		lblTienda.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTienda.setBounds(10, 87, 210, 27);
		contentPane.add(lblTienda);
		
		JButton btnIr = new JButton("Ir a tienda");
		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tienda obj = new Tienda(cliente, oferta.getTienda());
				obj.setVisible(true);
				dispose();
			}
		});
		btnIr.setFont(new Font("Arial", Font.PLAIN, 15));
		btnIr.setBounds(230, 87, 95, 27);
		contentPane.add(btnIr);
		
		JTextArea txtrDescripcin = new JTextArea();
		txtrDescripcin.setText("Descripci\u00F3n: " + oferta.getDescripcion());
		txtrDescripcin.setFont(new Font("Arial", Font.PLAIN, 15));
		txtrDescripcin.setBounds(10, 125, 774, 194);
		contentPane.add(txtrDescripcin);
		
		JLabel lblOpiniones = new JLabel("Opiniones:");
		lblOpiniones.setFont(new Font("Arial", Font.PLAIN, 15));
		lblOpiniones.setBounds(10, 330, 95, 27);
		contentPane.add(lblOpiniones);
		
		JList list = new JList();
		list.setBounds(10, 368, 774, 192);
		contentPane.add(list);
		
		JButton button_1 = new JButton("Opinar");
		button_1.setFont(new Font("Arial", Font.PLAIN, 15));
		button_1.setBounds(450, 87, 95, 27);
		contentPane.add(button_1);
		setLocationRelativeTo(null);
	}
}
