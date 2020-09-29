package Controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class KitchenController extends Thread{
  private final int idPlate;
  private final String name;
  private final float upperLimit;
  private final float inferiorLimit;
  private final Semaphore semaphore;
  private float preparTime;

  public KitchenController(int idPlate, Semaphore semaphore) {
    this.idPlate = idPlate;
    if(idPlate % 2 != 0) {
      this.name = "Sopa de Cebola";
      this.inferiorLimit = (float) 0.3;
      this.upperLimit = (float) 0.5;
    }
    else {
      this.name = "Lasanha a Bolanhesa";
      this.inferiorLimit = (float) 0.6;
      this.upperLimit = (float) 0.6;
    }
    this.semaphore = semaphore;
  }

  @Override
  public void run() {
    cook();
    sleep();
    cookPercent();
    try {
      semaphore.acquire();
      delivery();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      System.out.println("O prato #" + idPlate + " foi entregue!");
      semaphore.release();
    }
  }

  private void cook() {
    System.out.println("O prato #" + idPlate + " " + name + " começou a ser feito");
  }

  private void sleep() {
    Random random = new Random();
    preparTime = ((random.nextFloat() * inferiorLimit) + upperLimit);

    try {
      sleep((long) (preparTime * 1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void cookPercent() {
    int cookPercent = 0;
    while(cookPercent < 100) {
      cookPercent += (int) (preparTime / 0.1);
      System.out.println("percentual de cozimento do prato #" + idPlate + ": " + cookPercent + "%");

      try {
        sleep((long) (0.1 * 1000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void delivery() {
    System.out.println("O prato #" + idPlate + " está pronto");
    try {
      sleep((long) (0.1 * 1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
