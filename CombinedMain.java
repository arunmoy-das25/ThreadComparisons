import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        final int nThreads = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        List<Future<Long>> futures = new ArrayList<>();
        for(int i = 0; i < nThreads; i++){
            Future<Long> future = executorService.submit(new WorkerThread());
            futures.add(future);
        }

        long sum = 0;

        for(Future<Long> f: futures){
            try {
                sum += f.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        executorService.shutdown();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Sum: " + sum + "\tElapsed Time:" + elapsedTime);
    }
}