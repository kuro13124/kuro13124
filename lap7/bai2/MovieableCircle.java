
package bai2;


public class MovieableCircle implements Movieable{
    int radius ;
    MovieablePoint Center;

    public MovieableCircle(int radius, MovieablePoint Center) {
        this.radius = radius;
        this.Center = Center;
    }

    public MovieableCircle() {
       
    }

    @Override
    public String toString() {
        return "MovieableCircle{" + "radius=" + radius + ", Center=" + Center + '}';
    }

    @Override
    public void movieUp() {
        System.out.println("up");
    }

    @Override
    public void movieDown() {
       System.out.println("down");
    }

    @Override
    public void movieLefr() {
        System.out.println("left");
    }

    @Override
    public void movieRight() {
        System.out.println("right");
    }
    
    
    
}
