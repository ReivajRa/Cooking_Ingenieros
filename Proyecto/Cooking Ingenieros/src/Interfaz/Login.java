package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import CheapDeal.Cliente;
import CheapDeal.Main;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsu;
	private JPasswordField txtPass;
	private JLabel lblPass;
	private JLabel lblUsu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("CookingIngenieros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		lblUsu = new JLabel("Usuario:");
		lblUsu.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUsu.setBounds(119, 204, 91, 30);
		contentPane.add(lblUsu);
		
		lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPass.setBounds(119, 263, 91, 30);
		contentPane.add(lblPass);
		
		txtUsu = new JTextField();
		txtUsu.setFont(new Font("Arial", Font.PLAIN, 16));
		txtUsu.setBounds(220, 206, 180, 30);
		contentPane.add(txtUsu);
		txtUsu.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Arial", Font.PLAIN, 16));
		txtPass.setBounds(220, 265, 180, 30);
		contentPane.add(txtPass);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usu = txtUsu.getText().toUpperCase();
				String pass = txtPass.getText();
				Cliente[] aux = Main.clientes.clone();
				for(int i=0; i<aux.length; i++) {
					if(usu.equals(aux[i].getUsuario()) && pass.equals(aux[i].getContrasenia())) {
						Principal obj = new Principal(aux[i]);
						obj.setVisible(true);
						dispose();
						break;
					}else if(lblUsu.getText().equals("") || lblPass.equals("")){
						JOptionPane.showMessageDialog(null, "Usuario y/o Contrase�a estan vacios\n");
						setLocationRelativeTo(null);
						break;
					}else {
						JOptionPane.showMessageDialog(null, "Usuario y/o Contrase�a invalidos\n");
						setLocationRelativeTo(null);
						break;
					}
				}
			}
		});
		btnNewButton.setBounds(220, 324, 180, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblCookingIngenieros = new JLabel("Cooking Ingenieros");
		lblCookingIngenieros.setHorizontalAlignment(SwingConstants.CENTER);
		lblCookingIngenieros.setFont(new Font("Arial", Font.PLAIN, 22));
		lblCookingIngenieros.setBounds(144, 108, 281, 50);
		contentPane.add(lblCookingIngenieros);
	}
}
