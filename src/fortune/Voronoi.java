package fortune;
import java.util.*;

public class Voronoi {
    private ArrayList<Punkt> sites;
    private ArrayList<Punkt> eadges;
    private HashSet<CollisionPunkt> collisionPoints;
    private TreeMap<ArcAbst,CircleEvent> arcs;
    private TreeSet<Event> events;
    private double sweepLine;
    public Voronoi(ArrayList<Punkt> sites) {
        this.sites = sites;
        eadges = new ArrayList<>(sites.size());
        events = new TreeSet<>();
        arcs = new TreeMap<>();
        collisionPoints = new HashSet<>();
    }

}



