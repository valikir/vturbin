package jmm;

public class VisibilityProblem implements Runnable {

    @Override
    public void run() {
        SharedObject.adder++;
    }

    public static class SecondThread implements Runnable {
        int adder;
        @Override
        public void run() {
        adder = SharedObject.adder;
        System.out.println(getAdder());
        }
        public int getAdder(){
            return adder;
        }
    }

     public static class SharedObject {
        private static int adder = 0;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new VisibilityProblem());
        Thread t2 = new Thread(new SecondThread());
        t1.start();
        t2.start();
        int adder = SharedObject.adder;
        System.out.println(adder);
    }
}
