import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Customer {
    String custName, custPhone, custAddress;

    LinkedList<Customer> customerList = new LinkedList<>();
    Customer newCustomer = new Customer();

    FileInputStream fileByteStream = null; // File input stream
    Scanner inFS = null;                   // Scanner object

    // Customer class adds and modifies customer in the database(LinkedList)

    public Customer () {
        custName = "NoName";
        custPhone = "NoPhone";
        custAddress = "NoAddress";
    }
    public Customer (String userName,String userPhone, String userAddress) {
        custName = userName;
        custPhone = userPhone;
        custAddress = userAddress;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public String getCustName() {
        return custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void populateCustomer() throws IOException {
        fileByteStream = new FileInputStream("customers.txt");

        String newName = inFS.next();
        String newAddress = inFS.next();
        String newPhone = inFS.next();

        newCustomer.setCustName(newName);
        newCustomer.setCustPhone(newPhone);
        newCustomer.setCustAddress(newAddress);

        customerList.add(newCustomer);

        fileByteStream.close(); // close() may throw IOException if fails
    }

    public void printCustomerData() throws IOException{
        fileByteStream = new FileInputStream("customers.txt");

        String newName = inFS.next();
        String newAddress = inFS.next();
        String newPhone = inFS.next();

        setCustName(newName);
        setCustPhone(newPhone);
        setCustAddress(newAddress);

        fileByteStream.close(); // close() may throw IOException if fails

        System.out.print(custName + " " + custPhone + " " + custAddress);
    }
    public void printCustomerReport() throws IOException{
        populateCustomer();

        for (int i = 0; i < customerList.size(); ++i) {
            System.out.println(newCustomer.custName + " " + newCustomer.custPhone + " " + newCustomer.custAddress);
        }
    }


}
