public class Main {

    private static long elapsedTime;

    public static void count(int numThreads, int range){
        long startTime = System.nanoTime();
        Thread[] threads = new Thread[numThreads];
        long[] counts = new long[numThreads];

        for(int i = 0; i < numThreads; i++){
            final int threadId = i + 1;
            int finalI = i;
            threads[i] = new Thread(()-> {
                long count = 0;
                for(int j = 1; j <= range; j++)
                    count++;
                counts[finalI] = count;
            });
        }

        for(Thread thread: threads){
            thread.start();
        }

        try{
            for(Thread thread: threads){
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }
}