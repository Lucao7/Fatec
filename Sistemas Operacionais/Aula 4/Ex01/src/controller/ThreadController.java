package controller;

public class ThreadController extends Thread{
	private int num;
	private int [] vet;
	private double inicio;
	private double fim;
	private double duracao;
	private double soma;
	
	public ThreadController(int num, int [] vet) {
		this.num = num;
		this.vet = vet;
		this.soma = 0.0;

	}
	
	@Override
	public void run() {
		switch (num) {
		case 1:
			inicio = System.currentTimeMillis();
			
			for(Integer item: vet) {
				soma += item;
			}
			
			fim = System.currentTimeMillis();
			duracao = ((fim - inicio) / Math.pow(10, 3));
			System.out.println("Foreach Thread id " + getId() + " Duracao => " + duracao);
			
			break;
		case 2:
			inicio = System.currentTimeMillis();
			
			for(int i = 0; i < vet.length; i++) {
				soma += vet[i];
			}
			
			fim = System.currentTimeMillis();
			duracao = ((fim - inicio) / Math.pow(10, 3));
			System.out.println("For Thread id " + getId() + " Duracao => " + duracao);
			
			break;
		}
	
	}
	
}
