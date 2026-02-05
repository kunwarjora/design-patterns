package creational;

public class Prototype {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        Circle c2 = (Circle) circle.clone();
        System.out.println(circle.toString());
        System.out.println(c2.toString());
    }
}
// Abstract Prototype
abstract class Shape{
    int x;
    int y;
    public Shape() {
    }
    public Shape(Shape target) {
        if (target != null) {
            this.x = target.x;
            this.y = target.y;
        }
    }
    public abstract Shape clone();

    @Override
    public String toString() {
        return "x: "+x+" y: "+y+" ";
    }
}

// Concrete Prototype
class Circle extends Shape{
    int radius;
    Circle(){}
    Circle(Circle target){
        super(target);  // We are calling argument constructor.
        this.radius= target.radius;
    }
    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public String toString() {
        return super.toString()+"radius: "+radius;
    }
}

class Rectangle extends Shape{
    public int width;
    public int height;
    Rectangle(){}

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    Rectangle(Rectangle target){
        super(target);
        this.width= target.width;
        this.height= target.height;
    }

}