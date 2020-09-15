package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CassinoController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Cassino extends JFrame {

	private JPanel contentPane;
	private JTextField number1;
	private JTextField number2;
	private JTextField number3;

	/**
	 * Launch the application.
	 */
	public void iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cassino frame = new Cassino();
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
	public Cassino() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnJogar = new JButton("Jogar");
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnJogar.setBounds(335, 227, 89, 23);
		contentPane.add(btnJogar);
		
		number1 = new JTextField();
		number1.setEditable(false);
		number1.setForeground(Color.BLACK);
		number1.setHorizontalAlignment(SwingConstants.CENTER);
		number1.setFont(new Font("Tahoma", Font.BOLD, 40));
		number1.setBounds(32, 65, 100, 100);
		contentPane.add(number1);
		number1.setColumns(10);
		
		number2 = new JTextField();
		number2.setForeground(Color.BLACK);
		number2.setEditable(false);
		number2.setHorizontalAlignment(SwingConstants.CENTER);
		number2.setFont(new Font("Tahoma", Font.BOLD, 40));
		number2.setColumns(10);
		number2.setBounds(166, 65, 100, 100);
		contentPane.add(number2);
		
		number3 = new JTextField();
		number3.setForeground(Color.BLACK);
		number3.setEditable(false);
		number3.setFont(new Font("Tahoma", Font.BOLD, 40));
		number3.setHorizontalAlignment(SwingConstants.CENTER);
		number3.setColumns(10);
		number3.setBounds(298, 65, 100, 100);
		contentPane.add(number3);
		
		ActionListener jogar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CassinoController cassinoControllerEsquerda = new CassinoController();
				CassinoController cassinoControllerCentro = new CassinoController();
				CassinoController cassinoControllerDireita = new CassinoController();
				
				btnJogar.setVisible(false);
				
				cassinoControllerEsquerda.identifyField(number1);
				cassinoControllerEsquerda.start();
				
				cassinoControllerCentro.identifyField(number2);
				cassinoControllerCentro.start();
				
				cassinoControllerDireita.identifyField(number3);
				cassinoControllerDireita.start();
			}
		};
		
		btnJogar.addActionListener(jogar);
	}
}
