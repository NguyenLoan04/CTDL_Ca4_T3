package lab_3;

import java.util.Comparator;

public class ByNameAndPrice implements Comparator<OrderItem> {
    @Override
    public int compare(OrderItem o1, OrderItem o2) {
       return o1.getProduct().compareTo(o2.getProduct());
    }
}
