package question6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        OrderAnalyzer orderAnalyzer = new OrderAnalyzer();
        Order order1 = new Order("O001", "Alice", 150.0, Arrays.asList("电子", "数码"));
        orderAnalyzer.add(order1);
        Order order2 = new Order("O002", "Bob", -50.0, Arrays.asList("服装"));
        orderAnalyzer.add(order2);
        Order order3 = new Order("O003", "Alice", 200.0, Arrays.asList("图书", "电子"));
        orderAnalyzer.add(order3);
        Order order4 = new Order("O004", "Charlie", 200.0, Arrays.asList("生鲜"));
        orderAnalyzer.add(order4);
        Order order5 = new Order("O005", "Bob", 300.0, Arrays.asList("服装", "户外"));
        orderAnalyzer.add(order5);
        orderAnalyzer.removeInvalidOrders();
        System.out.println(orderAnalyzer.getAllUniqueTags());
        System.out.println(orderAnalyzer.getCustomerSpendMap());
        System.out.println(orderAnalyzer.sortOrdersByCustomerName());
    }
}
