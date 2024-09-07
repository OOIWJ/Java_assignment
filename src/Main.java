import javax.annotation.processing.SupportedSourceVersion;
import javax.swing.text.Style;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.StreamSupport;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static List<Goods> myGoodsList = new ArrayList<>();
    private static List<Membership> myMembershipList = new ArrayList<>();
    private static List<DeliveryPricing> myDeliveryPricingList = new ArrayList<>();
    private static Scanner scanner;

    public static void main(String[] args) {

//        Goods myGoods1 = new Goods();
//        Goods myGoods2 = new Goods(1, "Jurong");
//        Goods myGoods3 = new Goods("Nike", "Athleticwear", 2, "Hougang");
//
//        myGoods1.setBrand("Lego");
//
//        System.out.println("Brand: " + myGoods1.getBrand());
//        System.out.println("Goods priority: " + myGoods2.getPriority() + ", Delivery address: " + myGoods2.getAddress());
//        System.out.println("Goods brand name: " + myGoods3.getBrand() + ", Brand category: " + myGoods3.getCategory() + ", Goods priority: " + myGoods3.getPriority() + ", Delivery address: " + myGoods3.getAddress());
//        System.out.println(myGoods3.brandRemark());
//        System.out.println(myGoods3.goodsRemark());

        Brand myBrand = new Brand();
        Goods myGoods = new Goods();
//        DeliveryPricing myDeliveryPricing = new DeliveryPricing();
        ArrayList<Brand> myBrandList = new ArrayList<>();
        myBrandList.add(myBrand);
        myBrandList.add(myGoods);


        for (Brand b : myBrandList){
            System.out.println("Brand name: " + b.getBrand());
            System.out.println("Category: " + b.getCategory());

            if (b instanceof Goods g){
                System.out.println("Priority: " + g.getPriority());
                System.out.println("Address: " + g.getAddress());
            }
            System.out.println();
        }

        scanner = new Scanner(System.in);
        do {
            int choice = displayMenu();
            if (choice == 1) {
                addNewGoods();
            } else if (choice == 2) {
                displayGoods();
            } else if (choice == 3) {
                displayGoodsList(myGoodsList);
            } else if (choice == 4) {
                addNewMembership();
            } else if (choice == 5) {
                displayMembership();
            } else if (choice == 6) {
                break;
            }
        }
        while (true) ;
    }

    private static int displayMenu(){
        int choice = 0;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add goods");
            System.out.println("2. List all goods");
            System.out.println("3. Edit or delete the goods");
            System.out.println("4. Add a new membership");
            System.out.println("5. List all membership");
            System.out.println("6. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice >=1 && choice <=6) {
                break;
            }
        }
        return choice;
    }

    private static void addNewGoods(){
        System.out.print("Enter the brand: ");
        String name = scanner.nextLine();
        System.out.print("Enter the category: ");
        String category = scanner.nextLine();
        System.out.print("Enter the delivery priority: ");
        int priority = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the delivery address: ");
        String address = scanner.nextLine();

        Goods myGoods = new Goods(name, category, priority, address);

        myGoodsList.add(myGoods);
        System.out.println("Goods added successfully.");
    }

    private static void displayGoods(){
        System.out.println("List of Goods: ");
        for (Goods myGoods : myGoodsList) {
            System.out.println(myGoods.goodsDetail());
            System.out.println("-------------");
        }
    }

    //lab 5 Polymorphism
    public static void editGoods(Goods g){
        g.editDetails();
    }
    private static void displayGoodsList(List<Goods> myGoodsList){
        for (int i=0; i<myGoodsList.size(); i++){
            Goods g = myGoodsList.get(i);
            System.out.println("Goods #" + i);
            g.displayDetails();
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Exit");
        System.out.println("2. Edit a goods");
        System.out.println("3. Delete a goods");
        int option = scanner.nextInt();

        if (option == 2){
            System.out.print("Enter the index of the goods you want to edit: ");
            int index = scanner.nextInt();
            if (index >=0 && index < myGoodsList.size()){
                Goods goodsToEdit = myGoodsList.get(index);
                editGoods(goodsToEdit);
            } else {
                System.out.println("Invalid index.");
            }
        } else if (option == 3) {
            System.out.print("Enter the index of goods you want to delete: ");
            int index = scanner.nextInt();
            if (index >= 0 && index < myGoodsList.size()){
                myGoodsList.remove(index);
                System.out.println("Goods deleted.");
            } else {
                System.out.println("Invalid index.");
            }
        }
    }

    //Lab 6 Abstract Base Classes and Interface
    private static void addNewMembership(){
        System.out.print("Enter membership type: ");
        String type = scanner.nextLine();
        System.out.print("Enter membership cost: $");
        double cost = scanner.nextDouble();
        scanner.nextLine();

        Membership newMembership = new Membership(type, cost);
        myMembershipList.add(newMembership);

        System.out.println("Membership added successfully!");
    }

    private static void displayMembership(){
        System.out.println("Memberships: ");
        for (Membership myMembership : myMembershipList){
            System.out.println("Type: " + myMembership.getType());
            System.out.println("Cost: $" + myMembership.getCost());
            System.out.println("Sales Tax: $" + myMembership.calculateSalesTax());
            System.out.println("-------------------");
        }
    }

    private static void displayTaxableItems(){
        ArrayList<ITaxable> taxableItems = new ArrayList<>();

        for (Goods myGoods : myGoodsList){
            taxableItems.add(myGoods);
        }
        for (Membership myMembership : myMembershipList) {
            taxableItems.add(myMembership);
        }

        //Display details of each taxable item
        System.out.println("Taxable Items: ");
        for (ITaxable item : taxableItems){
            System.out.println("Sales Tax: $" + item.calculateSalesTax());
            System.out.println("----------------------");
        }
    }



}
