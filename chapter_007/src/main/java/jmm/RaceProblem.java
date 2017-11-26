package jmm;

public class RaceProblem implements Runnable {
    int adder;

    public RaceProblem(int adder){
        this.adder = adder;
    }

    public void calculateAdder() {
        for (int i = 0; i < 1000; i++) {
            adder = adder + 1;
        }
    }

    public int getAdder(){
        return adder;
    }
    @Override
    public void run() {
        calculateAdder();
    }

    public static class Thread2 implements Runnable {
        int adder;

        public Thread2(int adder){
            this.adder = adder;
        }

        public void calculateAdder(){
            for ( int i = 0; i < 1000; i++ )
            {
                adder = adder + 1;
            }
        }
        public int getAdder(){
            return adder;
        }

        @Override
        public void run() {
            calculateAdder();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        int adder = 0;
        RaceProblem thread1 = new RaceProblem(adder);
        Thread2 thread2 = new Thread2(adder);
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        t1.start();
        t2.start();
        adder = thread1.getAdder();
        System.out.println(thread1.getAdder() + " Thread 1");
        System.out.println(thread2.getAdder() + " Thread 2");
        System.out.println(adder + " Value of adder");
    }

}
