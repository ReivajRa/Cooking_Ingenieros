package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.JList;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import CheapDeal.Cliente;

import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JLayeredPane;
import java.awt.Window.Type;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal(null);
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
	public Principal(Cliente cliente) {
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
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PerfilInt obj = new PerfilInt(cliente);
				obj.setVisible(true);
				dispose();	
			}
		});
		btnCliente.setBounds(552, 227, 200, 100);
		contentPane.add(btnCliente);
		
		JButton btnTiendas = new JButton("Tiendas cercanas");
		btnTiendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TiendasInt obj = new TiendasInt(cliente);
				obj.setVisible(true);
				dispose();
				}
		});
		btnTiendas.setBounds(552, 378, 200, 100);
		contentPane.add(btnTiendas);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusquedaInt obj = new BusquedaInt(cliente);
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
		
		JList list = new JList();
		list.setValueIsAdjusting(true);
		list.setVisible(false);
		list.setVerifyInputWhenFocusTarget(false);
		list.setBounds(12, 75, 476, 465);
		contentPane.add(list);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnBuscar, btnCliente, btnTiendas}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, btnBuscar, btnCliente, btnTiendas}));
	}
}
