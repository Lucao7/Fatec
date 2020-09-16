package main;

import java.util.Random;

import controller.ThreadController;

public class Main {

	public static void main(String[] args) {
		Random random = new Random();
		
		int [] vetor = new int[1000];
		
		for(int i = 0; i < 1000; i++) {
			vetor[i] = random.nextInt(101);
		}
		
		for(int i = 1; i <= 2; i++) {
			ThreadController thread = new ThreadController(i, vetor);
			thread.run();
		}

	}

}
