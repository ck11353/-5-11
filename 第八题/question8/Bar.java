package question8;

import java.util.LinkedList;
import java.util.Queue;

public class Bar {
    private final Queue<Integer> bar = new LinkedList<>();
    private final int capacity;

    public Bar(int count) {
        this.capacity = count;
    }

    public synchronized void put(String producer, int number) throws InterruptedException {
        while (bar.size() >= capacity) {
            wait();
        }
        bar.offer(number);
        notifyAll();
        System.out.println("[" + producer + "]制作了奶茶[" + number
                + "]，吧台当前数量：" + bar.size());
    }
    public synchronized void take(String customer) throws InterruptedException {
        while (bar.isEmpty()) {
            wait();
        }
        Integer number = bar.poll();
        notifyAll();
        System.out.println("[" + customer + "]取走了奶茶["  + number + "]，吧台剩余数量：" + bar.size());
    }
}
