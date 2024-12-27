package fortune;

public abstract class ArcAbst implements Comparable<ArcAbst> {
        protected abstract Punkt left();
        protected abstract Punkt right();

        public int compareTo(ArcAbst o) {
            Punkt myL = this.left();
            Punkt myR = this.right();
            Punkt otherL = o.left();
            Punkt otherR = o.right();

            /// TODO if arc contains another
            //if(){
            // return 0;
            // }
            if(left().getX()==otherL.getX() && right().getX()==otherR.getX()) return 0;
            if(left().getX()>= otherR.getX()) return 1;
            if(right().getX()>= myL.getX()) return -1;
            return Punkt.middlePunkt(left(),right()).compareTo(Punkt.middlePunkt(otherL,otherR));
        }
}
