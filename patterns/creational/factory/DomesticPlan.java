package design.patterns.creational.factory;

public class DomesticPlan implements Plan{
    public double getRate(){
        return 2;
    }

    public double calculateBill(int quantity){
        return getRate()*quantity;
    }
}
