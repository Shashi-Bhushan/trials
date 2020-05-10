package in.shabhushan.cp_trials.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.joining;

class Counter {
    private List<Integer> numbers = new ArrayList<>();

    public void count(int n) {
        numbers.add(n);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        String setString = this.numbers.stream().map(String::valueOf).collect(joining(", ", "{", "}"));
        return "Counter{" +
                "set=" + setString +
                '}';
    }
}

public class ThreadedCounting {
    public static void countInThreads(Counter counter) {
        ExecutorService[] services = new ExecutorService[3];
        services[0] = Executors.newSingleThreadExecutor();
        services[1] = Executors.newSingleThreadExecutor();
        services[2] = Executors.newSingleThreadExecutor();

        try {
            for (int index = 0; index < 100; index++) {
                int finalIndex = index + 1;
                services[index % 3].execute(() -> {
                    counter.count(finalIndex);
                });


                TimeUnit.MILLISECONDS.sleep(10);

            }
            for (ExecutorService service : services) {
                service.shutdown();
                service.awaitTermination(1, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            throw new Error("Not gonna happen");
        }
    }
}
