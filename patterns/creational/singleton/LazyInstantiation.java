package design.patterns.creational.singleton;


// If class is loaded by two classloaders,
// two instance of the class will be created, one for each classloader.
public class LazyInstantiation {

    private static LazyInstantiation obj;
    private LazyInstantiation(){};

    public static LazyInstantiation getLazyInstantiation() {
        if (obj == null) {
            synchronized (LazyInstantiation.class) {
                if (obj == null) {
                    obj = new LazyInstantiation();//instance will be created at request time
                }
            }
        }
        return obj;
    }
}
