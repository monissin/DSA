package design.patterns.creational.abstractFactory;

public class LoanFactory extends AbstractFactory{
    @Override
    public Bank getBank(String bank) {
        return null;
    }

    @Override
    public Loan getLoan(String loan) {
        if (loan == null) {
            return null;
        }
        return switch (loan) {
            case "home" -> new HomeLoan();
            case "education" -> new EducationLoan();
            case "business" -> new BusinessLoan();
            default -> null;
        };
    }
}
