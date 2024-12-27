package simple;

import fortune.Punkt;

import java.util.ArrayList;

public class RayCasting {

    public static boolean containsPoint(ArrayList<Punkt> vertices, Punkt pnt) {
        boolean inside = false;
        int len = vertices.size();
        for (int i = 0; i < len; i++) {
            Punkt A = vertices.get(i);
            Punkt B = vertices.get((i + 1) % len);
            if (intersects(A, B, pnt)) {
                inside = !inside;
            }
        }
        return inside;
    }

    static boolean intersects(Punkt A, Punkt B, Punkt P) {
        // A must be lover
        if (A.getY() > B.getY()) {
            Punkt temp = A;
            A = B;
            B = temp;
        }

        // Handle case where point lies on a vertex
        if (P.getY() == A.getY() || P.getY() == B.getY()) {
            P = new Punkt(P.getX(), P.getY() + 0.0001);
        }

        // Check if the point is out of the vertical range of the edge
        if (P.getY() > B.getY() || P.getY() < A.getY()) {
            return false;
        }

        // Check if the point is to the left of the edge
        if (P.getX() < Math.min(A.getX(), B.getX())) {
            return true;
        }

        // Calculate intersection point's x-coordinate
        double intersectX = A.getX() + (P.getY() - A.getY()) * (B.getX() - A.getX()) / (B.getY() - A.getY());
        return P.getX() < intersectX;
    }
}
