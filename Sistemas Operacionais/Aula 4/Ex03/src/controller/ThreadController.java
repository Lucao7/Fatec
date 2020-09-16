package controller;

public class ThreadController extends Thread {
	private int [][] mat;
	private int soma;
	private int linha;
	
	public ThreadController(int [][] matriz, int i) {
		this.mat = matriz;
		this.linha = i;
		soma = 0;
	}
	
	public void run() {
		soma();
		
	}
	
	public void soma() {
		for (int i = 0; i <= 4; i++) {
			soma += mat[linha][i];
		}
		
		System.out.println("Matriz na linha " + (linha + 1) + " soma = " + soma + " ID: " + getId());
	}
	
}
