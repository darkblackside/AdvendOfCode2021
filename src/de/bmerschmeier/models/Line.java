package de.bmerschmeier.models;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private Point from;
    private Point to;

    public Line(int x1, int y1, int x2, int y2)
    {
        this.from = new Point(x1, y1);
        this.to = new Point(x2, y2);
    }

    public boolean isHorizontalOrVertical()
    {
        return (this.from.getX() == this.to.getX() || this.from.getY() == this.to.getY());
    }

    public List<Point> getOccupiedCoordinates()
    {
        ArrayList<Point> allPoints = new ArrayList<>();

        int transposeX = to.getX() < from.getX() ? to.getX() : from.getX();
        int transposeY = to.getY() < from.getY() ? to.getY() : from.getY();

        int arrayLengthX = Math.abs(to.getX() > from.getX() ? to.getX() - transposeX : from.getX() - transposeX);
        int arrayLengthY = Math.abs(to.getY() > from.getY() ? to.getY() - transposeY : from.getY() - transposeY);

        for (int i = 0; i <= arrayLengthX; i++) {
            for (int j = 0; j <= arrayLengthY; j++) {
                Point startTransposed = new Point(from.getX() - transposeX, from.getY() - transposeY);
                Point endTransposed = new Point(to.getX() - transposeX, to.getY() - transposeY);
                Point pointToCheck = new Point(i, j);

                if(inLine(startTransposed, endTransposed, pointToCheck)
                    && lengthSmallerOrEqual(startTransposed, endTransposed, pointToCheck))
                {
                    allPoints.add(new Point(i + transposeX, j + transposeY));
                }
            }
        }

        return allPoints;
    }

    private boolean lengthSmallerOrEqual(Point startTransposed, Point endTransposed, Point pointToCheck) {
        double vectorLengthX = 0.0 + (endTransposed.getX()) - startTransposed.getX();
        double vectorLengthY = 0.0 + (endTransposed.getY()) - startTransposed.getY();

        double checkLengthX = 0.0 + (pointToCheck.getX()) - startTransposed.getX();
        double checkLengthY = 0.0 + (pointToCheck.getY()) - startTransposed.getY();

        return lengthOfVector(vectorLengthX, vectorLengthY) - lengthOfVector(checkLengthX, checkLengthY) >= -0.01;
    }

    private double lengthOfVector(double vectorLengthX, double vectorLengthY)
    {
        return Math.sqrt(Math.pow(vectorLengthX, 2) + Math.pow(vectorLengthY, 2));
    }

    private static boolean inLine(Point A, Point B, Point C) {
        // if vertical
        if (A.getX() == B.getX()) return B.getX() == C.getX();
        // if horizontal
        if (A.getY() == B.getY()) return B.getY() == C.getY();
        // match the gradients
        return (A.getX() - C.getX())*(A.getY() - C.getY()) == (C.getX() - B.getX())*(C.getY() - B.getY());
    }
}
