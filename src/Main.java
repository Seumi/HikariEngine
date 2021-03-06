import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        OrderType orderType = OrderType.ASK;
        Map<Order, Integer> m = new TreeMap<>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                if(o1.orderID.equals(o2.orderID)) {
                    return 0;
                }
                if (o1.orderPrice == o2.orderPrice) {
                    if(o1.orderTime < o2.orderTime){
                        //o1 > o2
                        return orderType == OrderType.ASK ? 1 : -1;
                    } else if(o1.orderTime > o2.orderTime){
                        //o1 < o2
                        return orderType == OrderType.ASK ? -1 : 1;
                    } else {
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


        Order o1 = new Order(OrderType.ASK, 100, 100, 100, "asdf");
        Order o2 = new Order(OrderType.ASK, 110, 110, 110, "asdfc");
        Order o3 = new Order(OrderType.CANCLE,"asdf");
        Order o4 = new Order(OrderType.ASK, 100, 100, 100, "asdf");


        m.put(o1,1);
        m.put(o2,2);
        //m.put(o4,4);

        System.out.println(m.get(o3));
    }
}
