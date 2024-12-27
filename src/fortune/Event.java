package fortune;

public class Event implements Comparable<Event>{
    Punkt punkt;
    int index;
    public Event(Punkt punkt, int index) {
        this.punkt = punkt;
        this.index = index;
    }
    public Event(Punkt punkt) {
        this.punkt = punkt;
    }
    @Override
    public int compareTo(Event o) {
        //Going from top to bottom
        return Double.compare(this.punkt.getY(), o.punkt.getY());
    }
}
