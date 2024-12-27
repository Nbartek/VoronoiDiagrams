package fortune;

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
}
