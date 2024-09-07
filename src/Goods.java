import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;

//        Item Code: CK10001
//        Address: Tampines
//        Brand: Calvin Klein
//        Received date: 2024-7-19
//        Category: Fashion
//        Urgency level: High
public class Goods extends Brand implements ITaxable{
    private int priority;
    private String address;
    private double price;

    public Goods(){
        super();
        this.priority = 0;
        this.address = "Unknown";
    }
    public Goods(int priority, String address){
        this.priority = priority;
        this.address = address;
    }
    public Goods(String brand, String category, int priority, String address){
        super(brand, category);
        this.priority = priority;
        this.address = address;
    }
    protected String goodsDetail(){
        return "Brand name: " + getBrand() + "\n" +
                "Goods category: " + getCategory() + "\n" +
                "Delivery priority: " + getPriority() + "\n" +
                "Delivery address: " + getAddress();
    }

    //get Goods variable
    public int getPriority() {
        return priority;
    }
    public String getAddress() {
        return address;
    }
    public double getPrice() {
        return price;
    }

    //set Goods variable
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    //lab 5 Polymorphism
    @Override
    public void editDetails(){
        super.editDetails();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the new priority: ");
        int newPriority = scanner.nextInt();
        this.setPriority(newPriority);
        scanner.nextLine();

        System.out.print("Enter new delivery address: ");
        String newAddress = scanner.nextLine();
        this.setAddress(newAddress);
        System.out.println();
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Delivery priority: " + getPriority());
        System.out.println("Delivery address: " + getAddress());
    }

    //Lab 6
    public double calculateSalesTax(){
        double taxPercentage = 0.1; //10% tax rate
        return getPrice() * taxPercentage;
    };

}
