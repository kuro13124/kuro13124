
package bai2;

/**
 *
 * @author ThienLaptop
 */
public class Car extends Vehicle {

    public Car() {
    }

    public Car(String color, String model) {
        super(color, model);
    }
    @Override
    public void run(){
        System.out.println(" run car ");
    }
}
