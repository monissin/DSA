package design.patterns.creational.abstractFactory;

public class AbstractFactoryExample {

    public static void main(String[] args) {
        AbstractFactory bankFactory=FactoryCreator.getFactory("bank");
        AbstractFactory loanFactory=FactoryCreator.getFactory("loan");
        Bank bank=bankFactory.getBank("sbi");
        System.out.println("bank name "+bank.getBankName());
        Loan loan=loanFactory.getLoan("home");
        loan.getInterestRate(3);
        loan.loanAmount(5000,2);
    }
}
