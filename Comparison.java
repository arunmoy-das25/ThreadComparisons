public class Comparison {
    public static void main(String[] args){
        Main singleThread = new Main();
        CombinedMain multiThread = new CombinedMain();

        singleThread.count(1000, 1_000_000);
        multiThread.count(1000);

        int comparison = (int) (singleThread.getElapsedTime() - multiThread.getElapsedTime());

        if(comparison > 0){
            System.out.println("The mutli threaded approach is faster by " + comparison + " ns");
        }
        else System.out.println("The single threaded approach is faster by " + Math.abs(comparison) + " ns");
    }
}
