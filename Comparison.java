public class Comparison {
    public static void main(String[] args){
        Main singleThread = new Main();
        CombinedMain multiThread = new CombinedMain();

        singleThread.count(1000, 1_000_000);
        multiThread.count(1000);

        int comparison = (int) (singleThread.getElapsedTime() - multiThread.getElapsedTime());

        System.out.println("Single Thread Time: " + singleThread.getElapsedTime());
        System.out.println("Multi Thread Time: " + multiThread.getElapsedTime());

        if(comparison > 0){
            System.out.println("The mutli threaded approach is faster by " + comparison + " ns");
        }
        else System.out.println("The single threaded approach is faster by " + Math.abs(comparison) + " ns");
    }

    /*Why does the multithreaded approach take longer at time?
        Creating each thread takes extra time for a multithreaded approach.
        Meanwhile, the single threaded approach only needs to make one thread.
        Hence, the more threads in the multithreaded approach, the slower it is in comparison to a single thread.
    */
}
