
package bai2;

/**
 *
 * @author ThienLaptop
 */
public class Bicycle extends Vehicle {

    public Bicycle() {
    }

    public Bicycle(String color, String model) {
        super(color, model);
    }
    
    @Override
    public void run(){
        System.out.println(" run  bicycle");
    }
}
