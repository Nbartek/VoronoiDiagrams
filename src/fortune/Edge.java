package fortune;

public class Edge {
    Punkt start;
    Punkt finish;
    //because two cells share and edge
    Edge twin;
    Punkt thisSideCell;
    //Because in dcel cells are implemented as linked double list
    Edge previousEdge;
    Edge nextEdge;

    public Edge(Punkt start,Punkt finish){
        this.start = start;
        this.finish = finish;
    }
    public Edge(){
        start=null;
        finish=null;
        twin=null;
        thisSideCell=null;
        previousEdge=null;
        nextEdge=null;
    }
}

