package fortune;

public class CircleEvent extends Event {
    public ArcAbst arc;
    public Punkt vertex;
    public CircleEvent(ArcAbst arc, Punkt vertex, Punkt p) {
        //using extended constructor
        super(p);
        this.arc = arc;
        this.vertex = vertex;
    }
}
