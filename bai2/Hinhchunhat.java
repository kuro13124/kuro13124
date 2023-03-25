
package bai2;



public class Hinhchunhat extends Hinh {
    public float cd,cr;

    public Hinhchunhat() {
    }

    public Hinhchunhat(float cd, float cr) {
        this.cd = cd;
        this.cr = cr;
    }

    public float getCd() {
        return cd;
    }

    public void setCd(float cd) {
        this.cd = cd;
    }

    public float getCr() {
        return cr;
    }

    public void setCr(float cr) {
        this.cr = cr;
    }
    
    @Override
    public double dientich(){

        float s = (cd + cr)*2;
        
        return s;
    }

    @Override
    public String toString() {
        return "Hinhchunhat{" + "cd=" + cd + ", cr=" + cr + '}';
    }
}
