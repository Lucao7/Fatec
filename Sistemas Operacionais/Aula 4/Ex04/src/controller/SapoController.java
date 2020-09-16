package controller;


import controller.CorridaController;
import java.util.Random;

public class SapoController extends Thread {
	private int distancia;
	private int pulo;
	private int pulos;
	private boolean terminou;
	
	public SapoController(int i) {
		this.distancia = 0;
		this.pulo = 0;
		this.pulos = 0;
		this.terminou = false;
	}
	
	
	public void run() {
		pular();
		
	}

	public void pular() {
		CorridaController corridaController = new CorridaController();
		Random random = new Random();
		
		while(!terminou) {
			
			pulo = random.nextInt(11);
			pulos++;
			distancia += pulo;
			System.out.println("O sapo " + getId() + " saltou " + pulo + " metros e percorreu no total " + distancia);
			terminou = corridaController.podium(distancia, getId(), terminou, pulos);
			descansar();
		}
		
	}
		
	private void descansar() {
				
		Random rd = new Random();
        int interval = rd.nextInt(500 - 100 + 1) + 100;
		
		try {
			sleep(interval);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
