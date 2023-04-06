
package bai2;

class MovieablePoint implements Movieable{
    int x,y,xSpeed,ySpeed;

    public MovieablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return "MovieablePoint{" + "x=" + x + ", y=" + y + ", xSpeed=" + xSpeed + ", ySpeed=" + ySpeed + '}';
    }
    
    @Override
    public void movieUp() {
        System.out.println(" " + ySpeed);
    }

    @Override
    public void movieDown(){
        System.out.println(" " + xSpeed);
    }

    @Override
    public void movieLefr() {
        System.out.println(" " + x);
    }

    @Override
    public void movieRight() {
        System.out.println(" " + y);
        
    }
    
}
