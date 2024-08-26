package patterns.creational.factory;

public class InstitutionalPlan implements Plan{

    public double getRate(){
        return 6;
    }

    public double calculateBill(int quantity){
        return getRate()*quantity;
    }
}
