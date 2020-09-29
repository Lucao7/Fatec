package view;

import controller.Server;

import java.util.concurrent.Semaphore;

public class Main {

  public static void main(String[] args){
    float limitInf = 0;
    float limitSup = 0;
    Semaphore semaphore = new Semaphore(1);

    for(int i = 0; i < 21; i++) {
      if(i % 3 == 0) {
        limitInf = 1;
        limitSup = 2;

      } else if(i % 3 == 1) {
        limitInf = (float) 0.2;
        limitSup = 1;

      } else {
        limitInf = (float) 0.5;
        limitSup = (float) 1.5;

      }
      Server server = new Server(limitInf, limitSup, i + 1, semaphore);

      server.start();
    }
  }
}
