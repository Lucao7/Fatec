package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField tfSearch;
	private JButton btnCancel;
	private JButton btnSearch;
	private JLabel lblTitle;
	private JLabel lblImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(67, 82, 326, 20);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);
		
		JLabel lblOpen = new JLabel("Abrir:");
		lblOpen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOpen.setBounds(10, 85, 47, 14);
		contentPane.add(lblOpen);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOk.setBounds(61, 131, 89, 23);
		contentPane.add(btnOk);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setBounds(185, 131, 89, 23);
		contentPane.add(btnCancel);
		
		btnSearch = new JButton("Procurar");
		btnSearch.setBounds(304, 131, 89, 23);
		contentPane.add(btnSearch);
		
		lblTitle = new JLabel("Digite o caminho do executavel ou clique em procurar");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitle.setBounds(81, 37, 312, 14);
		contentPane.add(lblTitle);
		
		lblImage = new JLabel();
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setIcon(new ImageIcon(Menu.class.getResource("/images/java-icon-2.png")));
		lblImage.setBounds(10, 11, 61, 56);
		contentPane.add(lblImage);
		
		ActionListener search = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				searchArchive();
			}
		};
		
		btnSearch.addActionListener(search);
		
		ActionListener open = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openArchive(tfSearch.getText());
				
			}
		};
		
		btnOk.addActionListener(open);
		
		ActionListener close = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				closeApp();
				
			}
		};
		
		btnCancel.addActionListener(close);
	}
	
	public void searchArchive() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos Executaveis (.exe)", "exe");
		
		String baseDirectory = System.getProperty("user.home") + "/Desktop";
		File dir = new File(baseDirectory);
		
		JFileChooser choose = new JFileChooser();
		choose.setCurrentDirectory(dir);
		choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
		choose.setAcceptAllFileFilterUsed(false);
		choose.addChoosableFileFilter(filter);
		String filePath = "";
		
		int response = choose.showOpenDialog(null);
		if (response == JFileChooser.APPROVE_OPTION) {
			filePath = choose.getSelectedFile().getAbsolutePath();
			tfSearch.setText(filePath);
		}
	}
	
	public void openArchive(String filePath) {
		try {
			
			if(filePath.isEmpty()) {
				JOptionPane.showMessageDialog(null, "O caminho nao pode estar vazio", "Campo vazio", JOptionPane.ERROR_MESSAGE);
			}
			
			//Inicia Processo
			Runtime.getRuntime().exec(filePath);
			closeApp();
			
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao abrir o diretorio selecionado", "Diretorio Invalido", JOptionPane.ERROR_MESSAGE);
		};
	}
	
	public void closeApp() {
		this.dispose();
		
	}
}