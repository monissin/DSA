package patterns.creational.singleton;

public class MultiThread {

//    A simple way to create a thread-safe singleton class is to make the global access method synchronized so that only one thread can execute this method at a time.
//    provides thread-safety, but it reduces the performance because of the cost associated with the synchronized method,
//    although we need it only for the first few threads that might create separate instances.
//    To avoid this extra overhead every time, double-checked locking principle is used.
//    In this approach, the synchronized block is used inside the if condition with an additional check to ensure that only one instance of a singleton class is created.

    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");

        Thread threadBar=new Thread(new ThreadBar());
        Thread threadFoo=new Thread(new ThreadFoo());

        threadBar.start();
        threadFoo.start();

    }

    static class ThreadFoo implements Runnable{

        @Override
        public void run() {
            Singleton singleton=Singleton.getInstance("foo");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBar implements Runnable{

        @Override
        public void run() {
            Singleton singleton=Singleton.getInstance("bar");
            System.out.println(singleton.value);
        }
    }
}
