package patterns.creational.singleton;

public class Singleton {

    public String value;

    private static Singleton obj;
    private Singleton(String value){
        this.value=value;
    };

    public static Singleton getInstance(String value){
        if(obj==null){
            synchronized (Singleton.class){
                if(obj==null) {
                    obj = new Singleton(value);
                }
            }
        }
        return obj;
    }
}
