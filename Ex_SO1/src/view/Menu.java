package view;

import javax.swing.JOptionPane;

import controller.Processos;

public class Menu {

	public static void main(String[] args) {
		Processos taskController = new Processos();
		String os = taskController.os();
		int opcUsuario;
		int pid = 0;
		String nome = " ";
		int opcKill;
		
		do {
			opcUsuario = Integer.parseInt(JOptionPane.showInputDialog("Menu de opcoes\n1- Listar Processos\n2- Finalizar Tarefas\n9- Finalizar"));
			
			switch (opcUsuario) {
			case 1:
				taskController.listTask(os);
				break;
				
			case 2:

				opcKill = Integer.parseInt(JOptionPane.showInputDialog("Deseja encerar o processo por:\n1- PID\n2- Nome"));
				
				switch (opcKill) {
					case 1:
						pid = Integer.parseInt(JOptionPane.showInputDialog("Informe o PID do processo que deseja encerrar"));
						break;
					
					case 2:
						nome = JOptionPane.showInputDialog("Informe o nome do processo que deseja encerrar");
						break;
						
					default: 
						JOptionPane.showMessageDialog(null, "Opcao invalida");
				}

				taskController.killTask(os, pid, nome);
				nome = " ";
				pid = 0;
				break;
				
			case 9: 
				JOptionPane.showMessageDialog(null, "Finalizando aplicacao..");
				break;
				
			default: 
				JOptionPane.showMessageDialog(null, "Opcao invalida");
				break;
			}
			

		}while(opcUsuario != 9);
	}

}