import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

// InventoryItems class adds and modifies Inventory in the database(LinkedList)

public class InventoryItems {
    String itemName;

    ListIterator<String> listIterator;
    LinkedList<InventoryItems> stock = new LinkedList<InventoryItems>();
    InventoryItems newItem = new InventoryItems();

    FileInputStream fileByteStream = null; // File input stream
    Scanner inFS = null;                   // Scanner object

    public InventoryItems(){
        itemName = "Null";
    }

    public InventoryItems(String itemName){
        this.itemName = itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void addInventoryOrderItem(String nextItem) {

    }

    public void populateItems() throws IOException {
        fileByteStream = new FileInputStream("inventory.txt");

        String nameOfItem = inFS.next();
        newItem.setItemName(nameOfItem);

        stock.add(newItem);


        fileByteStream.close();
    }

    public void printInventoryReport() throws IOException {
        populateItems();

        for (int i = 0; i < stock.size(); ++i) {
            System.out.println(stock.get(i));
        }

    }
    // TODO fix search i think
    public InventoryItems searchInventory(String key){
        int i = 0;
        InventoryItems noItem  = new InventoryItems();
        noItem.setItemName("Not Found");
        InventoryItems keyItem = new InventoryItems();
        keyItem.setItemName(key);

       while (listIterator.hasNext()) {
           if (stock.get(i).equals(keyItem)) {
               return stock.get(i);

           }
           else {
               ++i;
           }
       }
        return noItem;
    }

}
