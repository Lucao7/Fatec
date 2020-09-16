package controller;

import controller.Corrida;
import view.Tela;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JLabel;

public class Carro extends Thread{
	private int arrancada;
	private String nome;
	private int distancia;
	private long id;
	private boolean terminou;
	private JLabel icon;
	
	public Carro(JLabel icon, String nome) {
		this.arrancada = 0;
		this.nome = nome;
		this.distancia = 0;
		this.id = getId();
		this.terminou = false;
		this.icon = icon;
	}
	
	
	@Override
	public void run() {
		arrancar();
	}
	
	public void arrancar() {
		Corrida corrida = new Corrida();
		Random random = new Random();
		Rectangle posicao = icon.getBounds();
		Tela tela = new Tela();

		while(!terminou) {
			arrancada = random.nextInt(11);
			distancia += arrancada;
			posicao.x += (arrancada * 6.5);
			icon.setBounds(posicao);
			System.out.println("O carro " + getId() + " correu " + arrancada + " metros e percorreu no total " + distancia);
			terminou = corrida.podium(distancia, id, terminou);
			if(terminou) {
				tela.finalizar(nome);
				
			}
			esperar();
		}
	}
	
	public void esperar() {
	
		try {
			sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
