package in.shabhushan.cp_trials.concurrent;

import java.util.concurrent.TimeUnit;

public class StopThreadVersion2 {
  private static boolean stopRequested;

  private static synchronized boolean isStopRequested() {
    return stopRequested;
  }

  private static synchronized void setStopRequested(boolean stopRequested) {
    StopThreadVersion2.stopRequested = stopRequested;
  }

  public static void main(String[] args) throws InterruptedException {
    Thread bgThread = new Thread(() -> {
      int i= 0;

      while (!isStopRequested()) {
        i++;
      }

      System.out.println("Thread Stopped");
    });
    bgThread.start();

    TimeUnit.SECONDS.sleep(1);
    setStopRequested(true);
    System.out.println("Finished Main Thread");
  }
}
