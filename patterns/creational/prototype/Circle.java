package patterns.creational.prototype;

public class Circle extends Shape {

    public int radius;

    public Circle(){}

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    public Circle(Circle target){
        super(target);
        if(target!=null){
            this.radius=target.radius;
        }
    }

    @Override
    public boolean equals(Object object2){
        if(!(object2 instanceof Circle)||(!super.equals(object2))) return false;
        Circle shape2=(Circle) object2;
        return shape2.radius==radius;
    }
}
