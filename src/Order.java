public class Order {

    public OrderType orderType;
    public int orderQuantity;
    public double orderPrice;
    public int orderTime;
    public String orderID;

    public Order(OrderType orderType, int orderQuantity, double orderPrice, int orderTime, String orderID) {
        this.orderType = orderType;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
        this.orderTime = orderTime;
        this.orderID = orderID;
    }

    public Order(OrderType orderType, String orderID) {
        this.orderType = orderType;
        this.orderID = orderID;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof Order) {
//            Order order = (Order) obj;
//            if (orderID.equals(order.orderID)){
//                return true;
//            }
//        }
//        return false;
//    }
}
