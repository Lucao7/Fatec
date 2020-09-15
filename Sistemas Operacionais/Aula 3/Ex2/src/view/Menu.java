package view;

import javax.swing.JOptionPane;

import controller.Adaptadores;

public class Menu {

	public static void main(String[] args) {
		Adaptadores redesController = new Adaptadores();
		String os = redesController.os();
		int opcUsuario;
		
		do {
			opcUsuario = Integer.parseInt(JOptionPane.showInputDialog("Menu de opções\n1- Mostrar IPv4\n2- Testar Ping\n9- Finalizar"));
			
			switch (opcUsuario) {
			case 1:
				redesController.ip(os);
				break;
				
			case 2:
				redesController.ping(os);
				break;
				
			case 9: 
				JOptionPane.showMessageDialog(null, "Finalizando aplicação..");
				break;
				
			default: 
				JOptionPane.showMessageDialog(null, "Opção inválida");
				break;
			}
			

		}while(opcUsuario != 9);
		
	}

}