package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Processos {
	public Processos() {
		super();
	}
	
	public String os() {
		//Reconhece o Sistema Operacional
		String os = System.getProperty("os.name");
		
		//Ignora a versao do sistema
		os = os.split(" ")[0];
		
		return os;
	}
	
	public void listTask(String os) {
		String process = "tasklist";
		
		if(os.toLowerCase().equals("windows")) {
			JOptionPane.showMessageDialog(null, "Processos Windows");
		} else {
			JOptionPane.showMessageDialog(null, "Processos Linux");
			process = "ps";
		}
		
		try {
			//Inicia Processo
			Process p = Runtime.getRuntime().exec(process);
			
			//Inicia leitor de processo e buffers de string
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			//Executa o processo ate acabarem os processos
			while (linha != null) {
				
				System.out.println(linha);
				
				//Le a proxima linha
				linha = buffer.readLine();

			}
			
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	public void killTask(String os, int pid, String nome) {
		String process = " ";
		
		if (nome != " ") {
			if (os.toLowerCase().equals("windows")) {
				process = "taskkill /im " + nome + ".exe";
			} else {
				process = "killall " + nome;
			}
		}
		
		if (pid != 0) {
			if (os.toLowerCase().equals("windows")) {
				process = "taskkill /PID " + pid;
			} else {
				process = "kill -9 " + pid;
			}
		}
		
		try {	
			Runtime.getRuntime().exec(process);

			JOptionPane.showMessageDialog(null, "Processo encerrado");				
			
			
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro na execucao do programa");
		}
			
	}

}