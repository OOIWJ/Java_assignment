public class DeliveryPricing{
    private double price;
    private double weight;

    public DeliveryPricing(){
//        super();
        this.price = 0.00;
        this.weight = 0.00;
    }

    public DeliveryPricing(double price, double weight){
        this.price = price;
        this.weight = weight;
    }
//    public DeliveryPricing(String brand, String category, int priority, String address, double price, double weight){
//        super(brand, category, priority, address);
//        this.price = price;
//        this.weight = weight;
//    }

    //get Packages variable
    public double getPrice() {
        return price;
    }
    public double getWeight() {
        return weight;
    }

    //get Packages variable
    public void setPrice(double price) {
        this.price = price;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double calculateSalesTax(){
        double taxPercentage = 0.1; //10% tax rate
        return getPrice() * taxPercentage;
    }
}
