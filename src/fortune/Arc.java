package fortune;

public class Arc extends ArcAbst{
    private Voronoi voronoi;
    public CollisionPunkt collisionLeft, collisionRight;
    public Punkt cell;

    public Arc(CollisionPunkt left, CollisionPunkt right, Voronoi voronoi) {
        this.voronoi = voronoi;
        if (left != null&&right != null) throw new RuntimeException("There are no points to mkae an arc from");
            this.collisionLeft = left;
            this.collisionRight = right;
            //this.cell = (left!=null)? left.s2:right.s1;
    }
    @Override
    protected Punkt left() {
        return null;
    }
    protected Punkt right() {
        return null;
    }
}
