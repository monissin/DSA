package design.patterns.creational.abstractFactory;

public class BankFactory extends AbstractFactory{

    @Override
    public Bank getBank(String bank){
        if(bank==null){
            return null;
        }
        return switch (bank) {
            case "sbi" -> new SBIBank();
            case "hdfc" -> new HDFCBank();
            case "citi" -> new CitiBank();
            default -> null;
        };
    }

    @Override
    public Loan getLoan(String loan) {
        return null;
    }
}
