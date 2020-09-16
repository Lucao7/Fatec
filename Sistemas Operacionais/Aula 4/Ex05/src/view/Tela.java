package view;

import controller.Corrida;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;

public class Tela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldPerdedor;
	private JTextField textFieldGanhador;
	
	
	public void iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 421);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCarro1 = new JLabel("");
		lblCarro1.setIcon(new ImageIcon(Tela.class.getResource("/images/icon-relampago.png")));
		lblCarro1.setBounds(10, 72, 50, 27);
		contentPane.add(lblCarro1);
		
		JLabel lblCarro2 = new JLabel("");
		lblCarro2.setIcon(new ImageIcon(Tela.class.getResource("/images/iconChickHicks.png")));
		lblCarro2.setBounds(10, 149, 60, 27);
		contentPane.add(lblCarro2);
		
		JButton btnCorrer = new JButton("Correr");
		btnCorrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCorrer.setBounds(10, 292, 89, 23);
		contentPane.add(btnCorrer);
		
		JLabel lblVendedor = new JLabel("Vencedor");
		lblVendedor.setBounds(261, 199, 60, 14);
		contentPane.add(lblVendedor);
		
		JLabel lblPerdedor = new JLabel("Perdedor");
		lblPerdedor.setBounds(261, 236, 56, 14);
		contentPane.add(lblPerdedor);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 121, 726, 2);
		contentPane.add(separator);
		
		textFieldPerdedor = new JTextField();
		textFieldPerdedor.setEnabled(false);
		textFieldPerdedor.setEditable(false);
		textFieldPerdedor.setBounds(353, 236, 86, 20);
		contentPane.add(textFieldPerdedor);
		textFieldPerdedor.setColumns(10);
		
		textFieldGanhador = new JTextField();
		textFieldGanhador.setEnabled(false);
		textFieldGanhador.setEditable(false);
		textFieldGanhador.setBounds(353, 199, 86, 20);
		contentPane.add(textFieldGanhador);
		textFieldGanhador.setColumns(10);
		
		ActionListener correr = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Corrida corrida= new Corrida(lblCarro1, lblCarro2);
				corrida.iniciarCorrida();
				btnCorrer.setVisible(false);
			}
		};
		
		btnCorrer.addActionListener(correr);
		
	}
	
	public void finalizar(String nome) {
		
	}
	
}
