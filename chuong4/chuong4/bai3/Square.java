
package bai3;


public class Square extends Rectangle{
    public double side;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    @Override
    public void setWidth(double side){
        
    }
    @Override
    public void setLength(double side){
        
    }

    @Override
    public String toString() {
        return "Square{" + "side=" + side + '}';
    }
    
}
