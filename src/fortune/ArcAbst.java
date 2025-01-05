package fortune;

public abstract class ArcAbst implements Comparable<ArcAbst> {
        protected abstract Punkt left();
        protected abstract Punkt right();

        public int compareTo(ArcAbst o) {
            Punkt myL = this.left();
            Punkt myR = this.right();
            Punkt otherL = o.left();
            Punkt otherR = o.right();

            if(((o.getClass()==ArcQueue.class)||(this.getClass() ==ArcQueue.class))
                    &&
                    ((myL.getX()<= otherL.getX()&&myR.getX()>=otherR.getX())||
                            (otherL.getX()<=myL.getX()&&myR.getX()<=otherR.getX()))){
             return 0;
             }
            if(myL.getX()==otherL.getX() && myR.getX()==otherR.getX()) return 0;
            if(myL.getX()>= otherR.getX()) return 1;
            if(myR.getX()>= otherL.getX()) return -1;
            return Punkt.middlePunkt(myL,myR).compareTo(Punkt.middlePunkt(otherL,otherR));
        }
}
