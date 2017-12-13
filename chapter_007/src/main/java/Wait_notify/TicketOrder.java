package Wait_notify;

public class TicketOrder {

    private int tickets = 100;
    private Object lock = new Object();
    public int price = 50;
    private int cash = 0;
    boolean ticketAvailable = true;

    public void getPrice() throws InterruptedException {
        synchronized (lock) {
            if (!ticketAvailable){
                return;
            }
            System.out.println("Current price is: " + price);
            lock.notify();

        }
    }

    public void buyTicket(int amount) throws InterruptedException {
            synchronized (lock) {
                if (tickets < 51 ) {
                    price = 55;
                    lock.wait();
                }
                while (tickets == 0) {
                    System.out.println("No Tickets left");
                    ticketAvailable = false;
                    System.out.println("Cash gained: " + cash);
                    return;
                }
                tickets = tickets - amount;
                cash = cash + price * amount;
                System.out.println("Cash gained: " + cash);
            }
    }

    public static void main(String[] args) {
        TicketOrder ticketOrder = new TicketOrder();
        new Thread(() -> {
            try {
                while (ticketOrder.ticketAvailable) {
                    ticketOrder.buyTicket(2);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                while (ticketOrder.ticketAvailable) {
                    ticketOrder.getPrice();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}
