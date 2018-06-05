package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CheapDeal.Cliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
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
	private String[] cabecera = {"Usuario", "Mensaje" , "Puntacion"};


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente cliente1 = new Cliente("Juan","12345","juanito@gmail.com");

					PerfilInt frame = new PerfilInt(cliente1);
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
	public PerfilInt(Cliente cliente) {
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
				Principal obj = new Principal(cliente);
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
		
		table = new JTable();
		DefaultTableModel dtm = new DefaultTableModel(0, 3);
		
		dtm.setColumnIdentifiers(cabecera);
		table.setModel(dtm);
		scrollPane.setViewportView(table);
	}
}
