package simple;

import fortune.Punkt;

import java.util.List;

public class Region {
    Punkt focus;
    //Wierchołki
    List<Punkt> vertices;
    public Region(Punkt punkt) {
        this.focus = punkt;
    }
    public Region(Punkt punkt, List<Punkt> vertices) {
        this.focus = punkt;
        this.vertices = vertices;
    }
    public void addVertices(Punkt punkt) {
        this.vertices.add(punkt);
    }
    public void setVertices(List<Punkt> vertices) {
        this.vertices = vertices;
    }
}
