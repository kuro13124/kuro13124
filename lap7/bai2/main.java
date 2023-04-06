
package bai2;

public class main {
    public static void main(String[] args) {
        
        MovieablePoint mvp = new MovieablePoint(2, 3, 4, 5);
        MovieableCircle mvc = new MovieableCircle(2,mvp);
        mvc.movieUp();
        mvp.movieUp();
    }
}
