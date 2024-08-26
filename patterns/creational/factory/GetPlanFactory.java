package design.patterns.creational.factory;

public class GetPlanFactory {

    public Plan getPlan(String planType){
        switch (planType){
            case "DOMESTIC": return new DomesticPlan();
            case "COMMERCIAL": return new CommercialPlan();
            case "INSTITUTIONAL": return new InstitutionalPlan();
            default: return null;
        }
    }
}
