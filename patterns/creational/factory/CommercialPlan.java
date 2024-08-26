package patterns.creational.factory;

public class CommercialPlan implements Plan{

    public double getRate(){
        return 4;
    }

    public double calculateBill(int quantity){
        return getRate()*quantity;
    }
}
