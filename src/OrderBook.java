import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class OrderBook {

    public Map<Order, String> orderQueue;
    public OrderType orderType;

    public OrderBook(OrderType orderType) {
        this.orderType = orderType;
        this.orderQueue = new TreeMap<>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {

                // Determine whether two order are equal.
                // Used by TreeMap to get an order only by its orderID.
                if(o1.orderID.equals(o2.orderID)) {
                    return 0;
                }

                // Price priority, time priority, quantity priority.
                // If all equal, depend on god's random
                if (o1.orderPrice == o2.orderPrice) {
                    if(o1.orderTime < o2.orderTime){
                        //o1 > o2
                        return orderType == OrderType.ASK ? 1 : -1;
                    } else if(o1.orderTime > o2.orderTime){
                        //o1 < o2
                        return orderType == OrderType.ASK ? -1 : 1;
                    } else {
                        //o1 = o2
                        if (o1.orderQuantity > o2.orderQuantity) {
                            return 1;
                        } else if (o1.orderQuantity < o2.orderQuantity){
                            return -1;
                        } else {
                            Random rnd = new Random();
                            return rnd.nextInt(10)>4?1:-1;
                        }
                    }

                } else if (o1.orderPrice > o2.orderPrice) {
                    //o1 > o2
                    return orderType == OrderType.ASK ? 1 : -1;
                } else {
                    //o1 < o2
                    return orderType == OrderType.ASK ? -1 : 1;
                }
            }
        });
    }

    public void addOrder(Order order) {
        if (order.orderType == OrderType.CANCLE){
            cancleOrder(order);
        }
        orderQueue.put(order, order.orderID);
    }

    private void cancleOrder(Order order){
        orderQueue.remove(order);
    }
}
