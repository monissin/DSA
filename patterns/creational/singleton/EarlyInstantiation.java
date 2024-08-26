package design.patterns.creational.singleton;

public class EarlyInstantiation {

    private static EarlyInstantiation obj=new EarlyInstantiation();//Early, instance will be created at load time
    private EarlyInstantiation(){}

    public static EarlyInstantiation getEarlyInstantiation(){
        return obj;
    }
}
