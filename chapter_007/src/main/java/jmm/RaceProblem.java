package jmm;

public class RaceProblem implements Runnable {
    int adder;

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
                adder = adder + 1;
            System.out.println(adder + " Thread 1");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RaceProblem race = new RaceProblem();
        Thread t1 = new Thread(race);
        Thread t2 = new Thread(race);
        t1.start();
        t2.start();
     //   int adder = race.getAdder();
     //   System.out.println(adder + " Thread 1");
     //   System.out.println(adder + " Thread 2");
     //   System.out.println(adder + " Value of adder");
    }


}
