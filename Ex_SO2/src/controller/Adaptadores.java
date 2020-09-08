package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Adaptadores {
	public Adaptadores() {
		super();
	}
	
	public String os() {
		//Reconhece o Sistema Operacional
		String os = System.getProperty("os.name");
		
		//Ignora a vers�o do sistema
		os = os.split(" ")[0];
		
		return os;
	}
	
	public void ip(String os) {
		String process = " ";
		String ipv4 = "ipv4";
		String adaptador = "adaptador";
		String nomeAdaptador = " ";
		
		if (os.equals("Windows")) {
			System.out.println("É Windows");
			process = "ipconfig";
		} else {
			System.out.println("É Linux");
			process = "ip addr show";
			adaptador = "<";
			ipv4 = "inet ";
		}
			
		try {
			//Inicia o processo
			Process p = Runtime.getRuntime().exec(process);
			
			//Inicia leitor de processo e buffers de string
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			StringBuffer bufferPrint = new StringBuffer();
			
			//Executa o processo at� acabarem os adaptadores
			while (linha != null) {
				
				if (os.toLowerCase().equals("windows")) {
					//Captura o Adaptador
					if (linha.toLowerCase().contains(adaptador) ) {
						bufferPrint.append("Adaptador: " + linha + "\n\n");
					}
					//Captura o endereço ip
					if (linha.toLowerCase().contains(ipv4)) {
						bufferPrint.append(linha + "\n\n");
					}
				}else {
					//Captura o adaptador
					if (linha.toLowerCase().contains(adaptador)) {
						linha = linha.split(" ")[1];
						
						//Salva o nome do adaptador
						nomeAdaptador = linha;
						
						//Avança uma linha
						linha = buffer.readLine();
					}
					
					//Captura o endereço ip
					if (linha.toLowerCase().contains(ipv4)) {
						//Caso seja encontrado IPv4 no adaptador, envia-lo para o buffer
						bufferPrint.append("Adaptador: " + nomeAdaptador + "\n");
						
						bufferPrint.append(linha + "\n\n");
						
					}
					
				}
				
				//L� a pr�xima linha
				linha = buffer.readLine();

			}
			
			//Printa dados capturados
			JOptionPane.showMessageDialog(null, bufferPrint);
			
			//Fechar os buffers e leitores
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public void ping(String os) {
		String process = " ";
		String response = " ";
		String approach = " ";
		
		int i = 1;
		
		if (os.equals("Windows")) {
			JOptionPane.showMessageDialog(null,"Teste de Ping Windows");
			process = "ping -n 10 www.google.com";
			response = "resposta";
			approach = "aproximar";
			
		} else {
			System.out.println("Teste de Ping Linux");
			process = "ping -c 10 www.google.com";
			response = "64 bytes";
			approach = "rtt";
		}
			
		try {
			//Inicia o processo
			Process p = Runtime.getRuntime().exec(process);
			
			//Inicia leitor de processo e buffers de string
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			//Executa o processo at� acabarem os adaptadores
			while (linha != null) {
				
				if (os.equals("Windows")) {
					//Encontra as linhas com o Ping
					if (linha.toLowerCase().contains(response)) {
						//Encontra a coluna com o tempo da resposta
						linha = linha.split(" ")[3];
						//Separa o tempo do texto
						linha = linha.split("=")[1];

						System.out.println(i + "� Teste " + linha);
						//Incrementa contador de x de teste
						i++;
					}
					
					
					//Encontra a linha antes do resultado com a m�dia
					if (linha.toLowerCase().contains(approach)) {
						linha = buffer.readLine();
						//Encontra a coluna com a m�dia
						linha = linha.split(",")[2];
						//Separa o tempo do texto
						linha = linha.split(" ")[3];
						
						JOptionPane.showMessageDialog(null, "M�dia = " + linha);
					}
				} else {
					if (linha.toLowerCase().contains(response)) {
						//Encontra a coluna com o tempo da resposta
						linha = linha.split(" ")[6];
						//Separa o tempo do texto
						linha = linha.split("=")[1];
						
						System.out.println(i + "° Teste " + linha + "ms");
						//Incrementa contador de x de teste
						i++;
					}
					
					//Encontra a linha do resultado com a m�dia
					if (linha.toLowerCase().contains(approach)) {
						//Encontra a coluna com a m�dia
						linha = linha.split(" ")[3];
						//Separa o tempo do texto
						linha = linha.split("/")[1];
						
						JOptionPane.showMessageDialog(null, "Média = " + linha + "ms");
					}
					
				}

				//L� a pr�xima linha
				linha = buffer.readLine();

			}
			
			//Fechar os buffers e leitores
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}