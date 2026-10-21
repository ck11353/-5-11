package question6;

import java.util.*;

public class OrderAnalyzer {
    private List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        orders.add(order);
    }

    public void removeInvalidOrders() {
        orders.removeIf(order -> order.getOrderTotal() <= 0);
    }

    public Set<String> getAllUniqueTags() {
        Set<String> uniqueTags = new HashSet<>();
        for (Order order : orders) {
            uniqueTags.addAll(order.getProductTag());
        }
        return uniqueTags;
    }

    public Map<String, Double> getCustomerSpendMap() {
        Map<String, Double> customerSpendMap = new HashMap<>();
        for (int i = 0; i < orders.size(); i++) {
            String name = orders.get(i).getCustomerName();
            customerSpendMap.put(name, customerSpendMap.getOrDefault(name, 0.0) + orders.get(i).getOrderTotal());
        }
        return customerSpendMap;
    }

    public List<Order> sortOrdersByCustomerName() {
        List<Order> newOrder = new ArrayList<>(orders);
        newOrder.sort(Comparator.comparing(Order::getCustomerName));
        return newOrder;
    }


}


