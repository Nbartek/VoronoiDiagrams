package fortune;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

public class Punkt implements Comparable<Punkt> {
    private double x;
    private double y;
    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Punkt middlePunkt(Punkt left, Punkt right) {
        double x = (left.x + right.x) / 2;
        double y = (left.y + right.y) / 2;
        return new Punkt(x,y);
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    @Override
    public int compareTo(Punkt o){
        if ((this.x == o.x) || (Double.isNaN(this.x) && Double.isNaN(o.x))) {
            if (this.y == o.y) {
                return 0;
            }
            return (this.y < o.y) ? -1 : 1;
        }
        return (this.x < o.x) ? -1 : 1;
    }
    public static int checkSmaller(Punkt first, Punkt secodn) {
        if(secodn.getY() > first.getY()) {
            return 1;
        }
        if(first.getY() > secodn.getY()) {
            return -1;
        }
        if(first.getX() == secodn.getX())return 0;
        return (first.getX() > secodn.getX()) ? 1 : -1;
    }
    public static int checkIfCounterclockwise(Punkt first, Punkt second, Punkt third) {
        double area = (second.x-first.x)* (third.y-first.y)-(second.y- first.y)*(third.x-first.x);
        if(area > 0) return 1;
        if(area < 0) return -1;
        return 0;
    }
    public double distance(Punkt p) {
        return Math.sqrt(Math.pow(this.x-p.x, 2) + Math.pow(this.y-p.y, 2));
    }
    private static boolean equal(double a, double b) {
        if(a == b) return true;
        return Math.abs(a - b) <= 1e-6;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Punkt) {
            Punkt p = (Punkt) obj;
            return equal(this.x, p.x) && equal(this.y, p.y);
        }
        return false;
    }
    //Methods needed for display
    public void draw(){
        StdDraw.setPenRadius(0.1);
        StdDraw.point(this.x, this.y);
        StdDraw.setPenRadius();
    }
    public void draw(Color color){
        Color old = StdDraw.getPenColor();
        StdDraw.setPenColor(color);
        this.draw();
        StdDraw.setPenColor(old);
    }
}
