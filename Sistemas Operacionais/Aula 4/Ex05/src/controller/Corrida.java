package controller;

import javax.swing.JLabel;

import controller.Carro;

public class Corrida {
	private int totalCorrida = 100;
	private static int posicao = 1;
	private JLabel relampago;
	private JLabel chick;
	
	public Corrida() {
		
	}
	
	public Corrida(JLabel carro1, JLabel carro2) {
		this.relampago = carro1;
		this.chick = carro2;

	}
	
	public void iniciarCorrida() {
		Carro relampago = new Carro(this.relampago, "Relampago");
		Carro chick = new Carro(this.chick, "Chick");
		relampago.start();
		chick.start();
			
		System.out.println("Corrida Iniciada");

	}
	
	public boolean podium(int distancia, long id, boolean terminou) {
		
		if (distancia >= totalCorrida) {
			System.out.println("O carro " + id + " chegou na " + posicao + "° posicao, percorrendo " + distancia + " metros");
			posicao++;
			return true;
		}
		return false;
		
	}

}
