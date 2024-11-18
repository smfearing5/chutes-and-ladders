import java.awt.geom.Point2D;

import graphics.Vector;

public class VectorTester {
    private static void display(Vector vector) {
        System.out.println("x: " + vector.getX());
        System.out.println("y: " + vector.getY());
        System.out.println("M: " + vector.getMagnitude());
        System.out.println();
    }
    public static void main(String[] args) {
        Vector v1 = new Vector();
        System.out.println("Vector 1:");
        display(v1);

        System.out.println("Unit Vector for Vector 1:");
        display(v1.getUnitVector());

        System.out.println("Testing magnitude setter on Vector 1...");
        System.out.println("(ERROR expected for Zero Vector)");
        v1.setMagnitude(5);
        System.out.println();

        Vector v2 = new Vector(3, 4);
        System.out.println("Vector 2:");
        display(v2);

        System.out.println("Testing setters on Vector 2...\n");
        v2.setX(6);
        v2.setY(8);
        System.out.println("New Vector 2:");
        display(v2);

        System.out.println("Testing magnitude setter on Vector 2...\n");
        v2.setMagnitude(8);
        display(v2);

        System.out.println("Unit Vector for Vector 2:");
        display(v2.getUnitVector());

        Point2D p1 = new Point2D.Double(5, 5);
        System.out.printf("Point 1: (%3.1f, %3.1f)\n", p1.getX(), p1.getY());
        System.out.println("Point 1 + Vector 2 -> Point 2");
        Point2D p2 = v2.getPointFrom(p1);
        System.out.printf("Point 2: (%3.1f, %3.1f)\n", p2.getX(), p2.getY());
        System.out.println();

        Point2D p3 = new Point2D.Double(15, 20);
        System.out.printf("Point 3: (%3.1f, %3.1f)\n", p3.getX(), p3.getY());
        System.out.println("Point 1 + Vector 3 -> Point 3");
        Vector v3 = new Vector(p1, p3);
        System.out.println("Vector 3:");
        display(v3);

        System.out.println("Vector 3's reverse is Vector 4:");
        Vector v4 = v3.reverse();
        display(v4);

        Vector[] orthogonals = v4.orthogonal();
        System.out.println("Two vectors orthogonal to Vector 4:");
        System.out.println("Orthogonal Vector 1:");
        display(orthogonals[0]);
        System.out.println("Orthogonal Vector 2:");
        display(orthogonals[1]);
    }
}
