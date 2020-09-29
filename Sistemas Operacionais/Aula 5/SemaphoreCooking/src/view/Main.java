package view;

import Controller.KitchenController;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {
  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore(1);

    for (int i = 0; i < 5; i++) {
      KitchenController kitchen = new KitchenController((i + 1), semaphore);
      kitchen.start();
    }
  }
}
