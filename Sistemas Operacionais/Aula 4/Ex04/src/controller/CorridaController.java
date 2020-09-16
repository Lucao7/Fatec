package controller;

import controller.SapoController;

public class CorridaController {
	private int totalCorrida = 50;
	private static int posicao = 1;
	
	public CorridaController() {
		
	}
	
	public void iniciarCorrida() {
		for(int i = 0; i <= 4; i++) {
			
			SapoController sapo = new SapoController(i);
			sapo.start();
		}
		System.out.println("Corrida Iniciada");

	}
	
	public boolean podium(int distancia, long id, boolean terminou, int pulos) {
		
		if (distancia >= totalCorrida) {
			System.out.println("\n---------------------------O " + posicao + "° TERMINOU------------------------------");
			System.out.println("O sapo " + id + " chegou na " + posicao + "° posicao com " + pulos + " pulos, percorrendo " + distancia + " metros");
			System.out.println("----------------------------------------------------------------------");
			posicao++;
			return true;
		}
		return false;
		
	}
}
