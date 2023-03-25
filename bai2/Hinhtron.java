
package bai2;



public class Hinhtron extends Hinh {
    public float r;

    public Hinhtron() {
    }

    public Hinhtron(float r) {
        this.r = r;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "Hinhtron{" + "r=" + r + '}';
    }

    @Override
    public double dientich(){
        float s = (float) (2*3.14*r);

        return s;
    }
    
    
}
