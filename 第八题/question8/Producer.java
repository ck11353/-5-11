package question8;

public class Producer implements Runnable{
    private final Bar bar;
    private final String name;
    public Producer(Bar bar, String name) {
            this.bar = bar;
            this.name = name;
    }
    @Override
    public void run() {
        try{
            for (int i = 0; i < 10; i++) {
                Thread.sleep(300);
                bar.put(name, i);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
