import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;

// orders class adds and modifies customer orders in the database(LinkedList)
public class CustomerOrders{
    String orderHeader, orderItems;

    ListIterator<String> listIterator;
    LinkedList<CustomerOrders> orderList = new LinkedList<>();
    CustomerOrders newOrder = new CustomerOrders();

    FileInputStream fileByteStream = null; // File input stream
    Scanner inFS = null;                   // Scanner object

    public CustomerOrders(){
        orderHeader = "Null Order";
        orderItems = "null";
    }

    public void setItems(CustomerOrders items) {
        orderList.add(items);
    }

    public void setOrderHeader(CustomerOrders orderHeader) {
        orderList.add(0, orderHeader);
    }

    public void getItems(int i) {
        orderList.get(i);
    }

    public String getOrderHeader() {
        return orderHeader;
    }

    public void populateOrder() throws IOException {

        fileByteStream = new FileInputStream("order.txt");
        //TODO read from each line for line items

        newOrder.orderHeader = inFS.next();
        while (inFS.hasNextLine()) {
            newOrder.orderItems = inFS.nextLine();
            orderList.add(newOrder);
        }

        fileByteStream.close();
    }

    public void deleteOrder(String key) {
        int i = 0;

        InventoryItems removeOrderItemSet = new InventoryItems();
        removeOrderItemSet.setItemName(key);

        CustomerOrders removeOrder = new CustomerOrders();
        removeOrder.setOrderHeader(removeOrderItemSet);

        while (listIterator.hasNext()) {
            if (orderList.get(i).equals(key)) {
                orderList.remove(i);
            }
            else {
                ++i;
            }
        }
    }


    public void printOrderReport() throws IOException {
        populateOrder();

        for (int i = 0; i < orderList.size(); ++i) {
            System.out.println(newOrder.orderHeader);
        }

    }
    public void printCustomerOrders() throws IOException {
        populateOrder();

        System.out.println(orderHeader);
        for (int i = 0; i < orderList.size(); ++i) {
            System.out.println(orderList.get(i));
        }

    }


}


