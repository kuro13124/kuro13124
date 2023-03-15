
package bai2;


public class Vehicle {
    public String color;
    public String model;

    public Vehicle() {
    }

    public Vehicle(String color, String model) {
        this.color = color;
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    
    public void run(){
        System.out.println(" run ");
    }
}
