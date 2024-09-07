public class Membership implements ITaxable{
    private String type;
    private double cost;

    public Membership(){
        this.type = "Unknown";
        this.cost = 0.00;
    }
    public Membership(String type, double cost){
        this.type = type;
        this.cost = cost;
    }

    //get Membership variables
    public String getType() {
        return type;
    }
    public double getCost() {
        return cost;
    }

    //set Membership variables
    public void setType(String type) {
        this.type = type;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public double calculateSalesTax(){
        double taxPercentage = 0.05; // 5% tax rate
        return getCost() * taxPercentage;
    }
}
