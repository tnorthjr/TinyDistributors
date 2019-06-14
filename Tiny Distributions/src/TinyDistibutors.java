/*
    Author: Tyrone North
    Package; TIny Distributions

    This application is the backend functionality to a website that allows for adding,
    searching and modifying customers, inventory, and orders.
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class TinyDistibutors {
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);

        LinkedList<InventoryItems> inventory = new LinkedList<>();

        // Read info from file add populate objects
        FileInputStream fileByteStream = null; // File input stream
        Scanner inFS = null;                   // Scanner object
        fileByteStream = new FileInputStream("order.txt");

        Customer newCustomer = new Customer();
        newCustomer.populateCustomer();

        InventoryItems newInventory = new InventoryItems();
        newInventory.populateItems();

        CustomerOrders newOrder = new CustomerOrders();
        newOrder.populateOrder();



    }
}
