
package bai3;


public class Circle extends Shape{
   public double radius = 1.0;
   final double pi = 3.14;
   
    public Circle() {
    }

    public Circle(String color, boolean filled,double radius) {
        super(color, filled);
        this.radius = radius;
        
        
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
   public double getArea(){
       return 2*pi*radius;
   }
   public double getPerimeter(){
       return 2*pi*radius*radius;
   }

    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + ", pi=" + pi + '}';
    }
   
}
