package patterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<Shape> shapes=new ArrayList<>();
        List<Shape> copyShapes=new ArrayList<>();
        Circle circle=new Circle();
        circle.x=10;
        circle.y=20;
        circle.radius=30;
        circle.color="red";
        shapes.add(circle);

        Circle circle2= (Circle) circle.clone();
        shapes.add(circle2);

        Rectangle rectangle=new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";
        shapes.add(rectangle);
        cloneAndCompare(shapes,copyShapes);

    }

    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Shapes are different objects (yay!)");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(i + ": And they are identical (yay!)");
                } else {
                    System.out.println(i + ": But they are not identical (booo!)");
                }
            } else {
                System.out.println(i + ": Shape objects are the same (booo!)");
            }
        }
    }

}
