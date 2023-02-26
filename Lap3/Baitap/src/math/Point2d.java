
package math;
public class Point2d {
    //thuoc tinh
    public float x;
    public float y;
    //phuong thuc
    //ham khoi tao ko tham so
    public Point2d(){
        this.x =0;
        this.y=0;
    }
    //ham khoi tao co tham so
    public Point2d(float x, float y){
        this.x = x;
        this.y = y;
    }
    //cac ham getter
    public float gettX(){
        return x;
    }
    public float getY(){
        return y;
}
}