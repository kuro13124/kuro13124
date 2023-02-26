
package math;
public class Triangle {
    //thuoc tinh
    public float width;
    public float hegth;
    //phuong thuc
    //khoi tao ham ko co tham so
    public Triangle(){
        this.width =0;
        this.hegth =0;
    }
    //khoi tao ham co tham so
    public Triangle(float width, float hegth){
        this.width = width;
        this.hegth = hegth;   
    }
    //cac ham getter
    public float gettwidth(){
        return width;
    }
    public float gethegth(){
        return hegth;
    }
    //ham setter
    public void setwidth(float width){
     this.width = width;  
    }
    public void sethegth(float hegth){
     this.hegth = hegth;
    }
    @Override
    public String toString(){
       return "(" + this.width + "; " + this.hegth + ")";
    }
}