package in.shabhushan.cp_trials.concurrent;

import java.util.concurrent.TimeUnit;


public class StopThread {

  public static boolean stopRequested;

  public static void main(String[] args) throws InterruptedException {
    Thread bgThread = new Thread(() -> {
      int i= 0;

      while (!stopRequested) {
        i++;
      }

      System.out.println("Thread Stopped");
    });
    bgThread.start();

    TimeUnit.SECONDS.sleep(1);
    stopRequested = true;
    System.out.println("Finished Main Thread");
  }
}
