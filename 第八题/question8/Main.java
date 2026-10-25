package question8;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bar bar = new Bar(5);
        Thread t1 = new Thread(new Producer(bar, "店员1"), "店员1");
        Thread t2 = new Thread(new Producer(bar, "店员2"), "店员2");
        Thread t3 = new Thread(new Customer(bar, "顾客1"), "顾客1");
        Thread t4 = new Thread(new Customer(bar, "顾客2"), "顾客2");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
}
