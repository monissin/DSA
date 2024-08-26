package patterns.creational.abstractFactory;

public class FactoryCreator{

    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("bank")){
            return new BankFactory();
        } else if (choice.equalsIgnoreCase("loan")) {
            return new LoanFactory();
        }
        return null;
    }
}
