package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Server extends Thread {
  private int idServer;
  private float limitInf;
  private float limitSup;
  private Semaphore semaphore;
  private int repeat = 3;

  public Server(float limitA, float limitB, int idServer, Semaphore semaphore) {
    this.idServer = idServer;
    this.limitInf = limitA;
    this.limitSup = limitB;
    this.semaphore = semaphore;
 }

  @Override
  public void run() {
    if((idServer - 1) % 3 == 1) {
      repeat = 2;
    }

    for(int i = 0; i < repeat; i++) {
      calc();

      try {
        semaphore.acquire();
        transaction();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        semaphore.release();
      }
    }
  }

  private void transaction() {
    Random random = new Random();
    float sleepTime = (random.nextFloat() * limitSup) + limitInf;
    System.out.println("A Thread " + idServer + " está realizando a transação.");

    try {
      sleep((long) (sleepTime * 1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void calc() {
    Random random = new Random();
    float sleepTime = (random.nextFloat() * limitSup) + limitInf;
    System.out.println("A Thread " + idServer + " está realizando a operação.");

    try {
      sleep((long) (sleepTime * 1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
