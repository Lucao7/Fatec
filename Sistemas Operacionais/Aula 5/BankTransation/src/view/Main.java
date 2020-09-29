package view;

import controller.TransactionController;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {
  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore(1);
    Semaphore semaphore2 = new Semaphore(1);
    boolean isEarning;
    int value;
    int balance;

    for(int i = 0; i < 20; i++) {
      Random random = new Random();
      isEarning = random.nextBoolean();
      value = (random.nextInt(1000000) + 1);
      balance = (random.nextInt(100) + 1);

      TransactionController transaction = new TransactionController((i+1), semaphore, isEarning, value, balance, semaphore2);
      transaction.start();
    }
  }
}
