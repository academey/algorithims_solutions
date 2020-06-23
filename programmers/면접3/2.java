import java.util.*;

import java.lang.Runnable;
class Racer implements Runnable {
    private String name;
    public Racer(String name) {
        this.name = name;
    }
    
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println(name);
        } catch (InterruptedException e) {}
    }

}
class Solution {
    public int solution(String skill, String[] skill_trees) throws InterruptedException {
        Thread t1 = new Thread(new Racer("1"));
        Thread t2 = new Thread(new Racer("2"));
        Thread t3 = new Thread(new Racer("3"));
        Thread t4 = new Thread(new Racer("4"));
        Thread t5 = new Thread(new Racer("5"));
        
        t5.start();
        t3.start();
        t1.start();
        t3.join();
        t2.start();
        t1.join();
        t4.start();
        t4.join();
        t5.join();
        return 0;
    }
}