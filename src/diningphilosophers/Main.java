package diningphilosophers;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static final int NR_PHILOSOPHERS = 5;


    public static void main(String[] args) {
        int dishes = 5;
        
        Forks forks = new Forks(NR_PHILOSOPHERS);
        Philosopher[] philosophers = new Philosopher[NR_PHILOSOPHERS];
        for (int i = 0; i < NR_PHILOSOPHERS; i++){
            philosophers[i] = new Philosopher(forks, i, dishes);
            philosophers[i].start();
        }
        
        for (int i = 0; i < NR_PHILOSOPHERS; i++){
            try {
                philosophers[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Lunch is terminated.");
    }
    
}
