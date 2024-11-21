import java.util.concurrent.Callable;

public class WorkerThread implements Callable<Long> {
    @Override
    public Long call() throws Exception {
        long range = 1_000_000;
        long count = 0;
        for(int i = 1; i <= range; i++) count++;
        return count;
    }
}
