package fortune;

public class ArcQueue extends ArcAbst {
    private Punkt p;
    public ArcQueue(Punkt p) {
        this.p = p;
    }
    @Override
    protected Punkt left() {
        return p;
    }
    protected Punkt right() {
        return p;
    }
}
