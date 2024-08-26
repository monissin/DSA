package design.patterns.creational.abstractFactory;

public abstract class Loan {
    protected double rate;

    abstract void getInterestRate(double rate);

    public void loanAmount(double loan,int years){
       double EMI=(loan/(12*years))*(rate*0.01);
        System.out.println("EMI: "+EMI);
    }
}
