package controller;

import java.util.Random;

import javax.swing.JTextField;

public class CassinoController extends Thread {
	
	JTextField field;
	
	private int loop, number;

	@Override
	public void run() {
		rolarNumeros();
	}
	
	public void rolarNumeros() {
		Random random = new Random();
		
		loop = random.nextInt(151);
		
		for(int i = 0; i < loop; i++) {
			number = random.nextInt(8);
			field.setText(Integer.toString(number));
			pause();
		}
	}
	
	public void identifyField(JTextField field) {
		this.field = field;
	}
	
	public void pause() {
		try {
			sleep(25);
		} catch (Exception e) {
			System.out.println("Deu merda: " + e);
		}
	}

}
