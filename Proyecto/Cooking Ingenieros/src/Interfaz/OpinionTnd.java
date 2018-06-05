package Interfaz;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;

import CheapDeal.Cliente;
import CheapDeal.Tienda;

public class OpinionTnd extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpinionTnd frame = new OpinionTnd(null, null);
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
	public OpinionTnd(Cliente cliente, Tienda tienda) {
		setTitle("CookingIngenieros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setName("Puntuación");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAadirOpininDe = new JLabel("Anadir opinion de la tienda <dynamic>");
		lblAadirOpininDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblAadirOpininDe.setBounds(161, 13, 471, 41);
		contentPane.add(lblAadirOpininDe);
		
		JEditorPane dtrpnOpinion = new JEditorPane();
		dtrpnOpinion.setFont(new Font("Arial", Font.PLAIN, 15));
		dtrpnOpinion.setBounds(12, 125, 770, 250);
		contentPane.add(dtrpnOpinion);
		
		JLabel lblOpinin = new JLabel("Opinión:");
		lblOpinin.setFont(new Font("Arial", Font.PLAIN, 15));
		lblOpinin.setBounds(12, 96, 70, 16);
		contentPane.add(lblOpinin);
		
		JLabel lblPuntuacin = new JLabel("Puntuacion:");
		lblPuntuacin.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPuntuacin.setBounds(12, 388, 85, 16);
		contentPane.add(lblPuntuacin);
		
		JSlider slider = new JSlider();
		slider.setFont(new Font("Arial", Font.PLAIN, 15));
		slider.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		slider.setName("");
		slider.setPaintTicks(true);
		slider.setMaximum(10);
		slider.setBounds(12, 417, 770, 41);
		contentPane.add(slider);
		setLocationRelativeTo(null);
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		JButton btnOpinar = new JButton("OPINAR");
		btnOpinar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tienda.aniadirOp(cliente, dtrpnOpinion.getText(), slider.getValue());
				Principal obj = new Principal(cliente);
				obj.setVisible(true);
				dispose();
			}
		});
		btnOpinar.setFont(new Font("Arial", Font.BOLD, 15));
		btnOpinar.setBounds(348, 527, 97, 25);
		contentPane.add(btnOpinar);
		
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
