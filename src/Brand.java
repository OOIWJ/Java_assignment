import java.util.Scanner;

//        Code: CK
//        Name: Calvin Klein
//        Category: Fashion
public class Brand {
    private String brand;
    private String category;

    public Brand(){
        this.brand = "Unknown";
        this.category = "Unknown";
    }

    public Brand(String brand, String category){
        this.brand = brand;
        this.category = category;
    }

    //get Brand variables
    public String getBrand() {
        return brand;
    }
    public String getCategory() {
        return category;
    }
    protected String brandDetail() {
        return "Brand: " + brand + "\n" +
                "Category: " + category;
    }

    //set Brand variables
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    //lab 5 Polymorphism
    public void editDetails(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the new brand: ");
        String newBrand = scanner.nextLine();
        this.setBrand(newBrand);

        System.out.print("Enter the new category: ");
        String newCategory = scanner.nextLine();
        this.setCategory(newCategory);
    }

    public void displayDetails() {
        System.out.println("Brand: " + getBrand());
        System.out.println("Category: " + getCategory());
    }


}