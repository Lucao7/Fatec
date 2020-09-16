package main;

import java.util.Random;

import controller.ThreadController;

public class Main {

	public static void main(String[] args) {
		int [][] matriz = new int [3][5];
		
		Random random = new Random();
		
		for(int i = 0; i <= 2; i++) {
			for(int j = 0; j <= 4; j++) {
				
				matriz[i][j] = random.nextInt(101);
			}
		}
		
		for(int i = 0; i <= 2; i++) {
			ThreadController thread = new ThreadController(matriz, i);
			thread.start();
		}
		
	}

}
