import java.util.Random;
import java.util.Scanner;

public class prob1 {

    public static int numOfMazeRuns = 0;
    public static int countPasses = 0;
    public static boolean cupcake = true;
    public static boolean endFlag = true;
    // guest object
    // bool hasEaten

    // protocol:
    // counter: ask for new cupcake if no cupcake (count if no cupcake); dont eat

    // others: eat cupcake only once (if its there and you haven't, eat it)
    //         if no cupcake, do nothing
    //         if cupcake and already eated, do nothing
    public static void main(String[] args) throws InterruptedException{

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        System.out.print("Please enter an integer > 1: ");
        int n = scan.nextInt();

        Thread guests[] = new Thread[n+1]; 
        for(int i = 0; i < n; i++){
            guests[i] = new Thread(new childThread());
        }

        boolean hasEaten[] = new boolean[n+1];

        do {
            numOfMazeRuns++;
            int r = rand.nextInt(n);
            // System.out.println("Calling guest: " + r);
            if(cupcake && !hasEaten[r]){
                guests[r].start();
                guests[r].join();
                hasEaten[r] = true;
                // System.out.println("Guest #" + r + "has now eaten.");
            }
            if(r == 0){
                if(!cupcake){
                    // System.out.println("Counter replaced the cupcake");
                    countPasses++;
                    cupcake = true;
                    // System.out.println(" - - - - Count passes is now: " + countPasses + " - - - - - ");
                }
                if(countPasses == n){
                    endFlag = false;
                }
            }
        } while (endFlag);

        System.out.println("Everyone has passed through the Labyrinth after " + numOfMazeRuns + " runs.");


    }

    public static class childThread implements Runnable {

        @Override
        public void run() {
            cupcake = false;     
        }
        
    }
}