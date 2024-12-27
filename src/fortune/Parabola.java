package fortune;

import java.util.LinkedList;

//Arc
public class Parabola {
    enum Colour{BLACK, RED,}
    Punkt core;;
    Parabola left;
    Parabola right;
    Parabola parent;
    Edge eddgeLeft;
    Edge eddgeRight;
    Colour colour;
    public Parabola(Punkt p){
        core = p;
    }
//    public double edgesIntersectionY(Parabola firstFromDown, Parabola secondFrmoDown, double d) {
//        double up = secondFrmoDown.focus.getY()*(firstFromDown.focus.getX()-d)-firstFromDown.focus.getY()*
//                (secondFrmoDown.focus.getX()-d)+Math.sqrt((firstFromDown.focus.getX()-d)*
//                (secondFrmoDown.focus.getX()-d)*(Math.pow(firstFromDown.focus.getX()-secondFrmoDown.focus.getX(),2)+
//                Math.pow(firstFromDown.focus.getY()-secondFrmoDown.focus.getY(),2)));
//        double down = firstFromDown.focus.getX()-secondFrmoDown.focus.getX();
//        return up/down;
//    }
//    //Function to search intersection from down to up
//    private Parabola search(Punkt p){
//    Parabola n = beachline.get(0);
//    while (n.neighbourRight!=null && edgesIntersectionY(n,n.neighbourRight,p.getX())<p.getY()){
//        n = n.neighbourRight;
//    }
//    return n;
//    }
//    public void addingParabola(Parabola p){
//        if(beachline.isEmpty()){
//            beachline.add(p);
//        }else{
//            Parabola q = search(p.focus);
//        }
//    }
//    public void SetLeft(Parabola p) {
//        childLeft =p;
//        p.parent = this;
//    }
//    public void SetRight(Parabola p) {
//        childRight =p;
//        p.parent = this;
//    }
//    public Parabola GetRight(Parabola p) {
//        return GetRightChild(GetRightParent(p));
//    }
//    public Parabola GetLeft(Parabola p) {
//        return GetLeftChild(GetLeftParent(p));
//    }
//    public static Parabola GetLeftChild(Parabola p) {
//        Parabola left = p.childLeft;
//        while (!left.isLeaf) {
//            left = left.childRight;
//        }
//        return left;
//    }
//    public static Parabola GetRightChild(Parabola p) {
//        Parabola right = p.childRight;
//        while (!right.isLeaf) {
//            right = right.childLeft;
//        }
//        return right;
//    }
//    public static Parabola GetRightParent(Parabola p) {
//        Parabola right = p.parent;
//        Parabola last = p;
//        while (right.childRight ==last) {
//            if(!right.isLeaf) return null;
//            last = right;
//            right = right.parent;
//        }
//        return right;
//    }
//    public static Parabola GetLeftParent(Parabola p) {
//        Parabola left = p.parent;
//        Parabola last = p;
//        while (left.childLeft ==last) {
//            if(!left.isLeaf) return null;
//            last = left;
//            left = left.parent;
//        }
//        return left;
//    }
}
