package controller;

import java.util.concurrent.Semaphore;

public class TransactionController extends Thread{
  private final int bankAccount;
  private int balance;
  private final int valueTransaction;
  private final boolean isEarning;
  private final Semaphore semaphoreDebit;
  private final Semaphore semaphoreCredit;

  public TransactionController(int bankAccount, Semaphore semaphore, boolean isEarning, int valueTransaction, int balance, Semaphore semaphore2) {
    this.bankAccount = bankAccount;
    this.balance = balance;
    this.valueTransaction = valueTransaction;
    this.semaphoreDebit= semaphore;
    this.isEarning = isEarning;
    this.semaphoreCredit = semaphore2;
  }

  @Override
  public void run() {
    try {
      if(isEarning){
      semaphoreCredit.acquire();
      credit();
      }
      else {
        semaphoreDebit.acquire();
        debit();
      }
      sleep();
    } catch (InterruptedException e) {
        e.printStackTrace();
    } finally {
        semaphoreCredit.release();
        semaphoreDebit.release();
        System.out.println("o Saldo da conta " + bankAccount + " é de: R$ " + balance);
    }

  }

  private void debit() {
    balance -= valueTransaction;
    System.out.println("A conta de n " + bankAccount + " teve um debito de R$ " + valueTransaction);
  }

  private void credit() {
    balance += valueTransaction;
    System.out.println("A conta de n " + bankAccount + " teve um credito de R$ " + valueTransaction);
  }

  private void sleep() {
    try {
      sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
