package design.patterns.creational.prototype;

import java.util.Objects;

public class Rectangle extends Shape{
    public int height;
    public int width;
    public Rectangle(){}

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    public Rectangle(Rectangle target){
        super(target);
        if(target!=null){
            this.width=target.width;
            this.height=target.height;
        }
    }

    @Override
    public boolean equals(Object object2){
        if(!(object2 instanceof Rectangle)||(!super.equals(object2))) return false;
        Rectangle shape2=(Rectangle) object2;
        return shape2.height==height&&shape2.width==width;
    }
}
