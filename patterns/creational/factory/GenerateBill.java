package design.patterns.creational.factory;

public class GenerateBill {

    public static void main(String[] args) {
        GetPlanFactory getPlanFactory=new GetPlanFactory();
        System.out.println("Domestic bill: "+ getPlanFactory.getPlan("DOMESTIC").calculateBill(5));
        System.out.println("Commercial bill: "+ getPlanFactory.getPlan("COMMERCIAL").calculateBill(5));
        System.out.println("Institutional bill: "+ getPlanFactory.getPlan("INSTITUTIONAL").calculateBill(5));

    }

}
