package simple;

import fortune.Punkt;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class SimpleVoronoi {
    private double x1 =0;
    private double xr = 1;
    private double y1 = 0;
    private double yr =1;
    private Pair<Double, Punkt> bestPlaceForNewFocus = null;
    private ArrayList<Region> mapaOfRegions = new ArrayList<>();
    //It's nt real a used variable, to make it useful and optimise search algorithm I would have make TreeSet a Pair with second as a List of neighbouring cells
    TreeSet<Punkt> vertex = new TreeSet<>();
    public SimpleVoronoi(ArrayList<Punkt> punkty) {
            //SetArea(punkty,0.5);
            ArrayList<Punkt> borders = new ArrayList<>();
            borders.add(new Punkt(x1,y1));
            borders.add(new Punkt(x1,yr));
            borders.add(new Punkt(xr,yr));
            borders.add(new Punkt(xr,y1));
        for (int i = 0; i < punkty.size(); i++) {
            Region region = new Region(punkty.get(i),borders);
            for (Punkt punkt : punkty) {
                if (punkty.get(i) != punkt) {
                    Bisector B = new Bisector(punkty.get(i), punkt);
                    List<Punkt> t = new ArrayList<>();
                    ArrayList<Punkt> direction = new ArrayList<>();
                    for (int k = 0; k < region.vertices.size(); k++) {
                        Punkt temp = Intersects(B, region.vertices.get(k), region.vertices.get((k + 1) % region.vertices.size()));
                        if (temp != null) {
                            t.add(temp);
                            direction.add(region.vertices.get((k + 1) % region.vertices.size()));
                        }
                    }
                    if (t.size() == 2) {
                        ArrayList<Punkt> vertices = new ArrayList<>();
                        for (int j = 0; j < region.vertices.size(); j++) {
                            if(region.vertices.get(j) == direction.get(0)) {
                                vertices.add(t.get(0));
                            }else if(region.vertices.get(j) == direction.get(1)) {
                                vertices.add(t.get(1));
                            }
                            vertices.add(region.vertices.get(j));
                        }
                        ArrayList<Punkt> final_vertices = new ArrayList<>();
                        int index = 0;
                        boolean startAdding = false;
                            while(true) {
                                if (vertices.get(index) == t.get(0)) startAdding = true;
                                if (startAdding) {
                                    final_vertices.add(vertices.get(index));
                                    if (vertices.get(index) == t.get(1)) break;
                                }
                                index++;
                                if (index >= vertices.size()) {
                                    index = 0;
                                }
                            }
                        if(!RayCasting.containsPoint(final_vertices, region.focus)){
                            index = 0;
                            final_vertices = new ArrayList<>();
                            startAdding = false;
                                while(true){
                                    if(vertices.get(index) == t.get(1)) startAdding = true;
                                    if(startAdding){
                                        final_vertices.add(vertices.get(index));
                                        if(vertices.get(index) == t.get(0))break;
                                    }
                                    index++;
                                    if(index>= vertices.size()){index = 0;}
                                }
                        }
                        region.setVertices(final_vertices);
                        //mapaOfRegions.add(region);
                    }
                }
            }
            vertex.addAll(region.vertices);
            mapaOfRegions.add(region);
        }
    }

    public Punkt findBestPlace(ArrayList<Punkt> punkty){
        for (Region r :mapaOfRegions){
            for(Punkt p :r.vertices){
                //I see a voronoi diagram as an island
                if(p.getX() ==0.0||p.getX() ==1.0 || p.getY() ==0.0||p.getY() ==1.0){}
                else{
                    double distance = Math.hypot(p.getX()-r.focus.getX(),p.getY()-r.focus.getY());
                if(bestPlaceForNewFocus == null){
                    bestPlaceForNewFocus = new Pair<>(distance,p);
                }else if(distance> bestPlaceForNewFocus.getKey()){
                    bestPlaceForNewFocus = new Pair<>(distance,p);
                }
                }
            }
        }
        return bestPlaceForNewFocus.getValue();
    }
    //Check if bisector intersects 2 points, separates given area
    public static Punkt Intersects(Bisector b,Punkt A,Punkt B) {
        double[] u = {b.a,b.b,b.c};
        double[] v = {A.getY()-B.getY(),B.getX()-A.getX(),A.getX()*B.getY()-B.getX()*A.getY()};
        double[] z = {u[1]*v[2]-u[2]*v[1],u[2]*v[0]-u[0]*v[2],u[0]*v[1]-u[1]*v[0]};
        if(z[2]!=0){
            Punkt temp = new Punkt(z[0]/z[2],z[1]/z[2]);
            if(Math.min(A.getX(),B.getX())<= temp.getX() &&
                    temp.getX()<=Math.max(A.getX(),B.getX()) &&
                    Math.min(A.getY(),B.getY())<=temp.getY() &&
                    temp.getY()<=Math.max(A.getY(),B.getY())
            )return temp;
        }
        return null;
    }
    //If you don't have already set borders of area
    private void SetArea(ArrayList<Punkt> punkty, double padding) {
        x1 =xr = punkty.get(0).getX();
        y1 =yr = punkty.get(0).getY();
        for (int i = 1; i < punkty.size(); i++) {
            double x = punkty.get(i).getX();
            double y = punkty.get(i).getY();
            if(x<x1) x1 =x;
            if(y<y1) y1 =y;
            if(x>xr) xr =x;
            if(y>yr) yr =y;
        }
    }
    //class for perpendicular bisector
    public class Bisector{
        public double a;
        public double b;
        public double c;
        public Bisector(Punkt p,Punkt q) {
            Punkt temp = new Punkt((p.getX()+q.getX())/2,(p.getY()+q.getY())/2);
            this.a = q.getX()-p.getX();
            this.b = q.getY()-p.getY();
            this.c = -a*temp.getX()-b*temp.getY();
        }
    }
}
