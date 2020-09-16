package main;

import controller.ThreadController;

public class Main {

	public static void main(String[] args) {
		for(int i = 0; i <= 4; i++) {
			ThreadController thread = new ThreadController();
			thread.start();
		}

	}

}
