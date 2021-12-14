package de.bmerschmeier;

import de.bmerschmeier.models.Line;
import de.bmerschmeier.models.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day5Tasks {
    public void Task1() {
        List<String> input = Helper.ReadFileLineByLine("resources/Day5/Day5Input.txt");
        List<Line> lines = new ArrayList<Line>();

        int maxNumberX = 0;
        int maxNumberY = 0;

        for(String line : input)
        {
            String[] splittedAtArrow = line.split("->");
            String firstPoint = splittedAtArrow[0].strip();
            String secondPoint = splittedAtArrow[1].strip();

            String[] firstPointSplitted = firstPoint.split(",");
            String[] secondPointSplitted = secondPoint.split(",");

            int x1 = Integer.parseInt(firstPointSplitted[0]);
            int y1 = Integer.parseInt(firstPointSplitted[1]);
            int x2 = Integer.parseInt(secondPointSplitted[0]);
            int y2 = Integer.parseInt(secondPointSplitted[1]);

            if(maxNumberX < x1 || maxNumberX < x2) {
                if (maxNumberX < x1) {
                    maxNumberX = x1;
                } else {
                    maxNumberX = x2;
                }
            }
            if(maxNumberY < y1 || maxNumberY < y2)
            {
                if (maxNumberY < y1)
                {
                    maxNumberY = y1;
                }
                else
                {
                    maxNumberY = y2;
                }
            }

            lines.add(new Line(x1, y1, x2, y2));
        }

        List<Line> linesFilteredForHorizontalOrVertical = lines.stream().filter(x -> x.isHorizontalOrVertical()).collect(Collectors.toList());

        int[][] gameboard = new int[maxNumberX+1][maxNumberY+1];

        for(Line lineToDraw : linesFilteredForHorizontalOrVertical)
        {
            List<Point> occupiedCoordinates = lineToDraw.getOccupiedCoordinates();

            for (Point occupiedPoint : occupiedCoordinates) {
                gameboard[occupiedPoint.getX()][occupiedPoint.getY()]++;
            }
        }

        int countOccupied = 0;

        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                if(gameboard[i][j] > 1)
                {
                    countOccupied++;
                }
            }
        }

        System.out.println(countOccupied);
    }

    public void Task2() {
        List<String> input = Helper.ReadFileLineByLine("resources/Day5/day5test.txt");
        List<Line> lines = new ArrayList<Line>();

        int maxNumberX = 0;
        int maxNumberY = 0;

        for(String line : input)
        {
            String[] splittedAtArrow = line.split("->");
            String firstPoint = splittedAtArrow[0].strip();
            String secondPoint = splittedAtArrow[1].strip();

            String[] firstPointSplitted = firstPoint.split(",");
            String[] secondPointSplitted = secondPoint.split(",");

            int x1 = Integer.parseInt(firstPointSplitted[0]);
            int y1 = Integer.parseInt(firstPointSplitted[1]);
            int x2 = Integer.parseInt(secondPointSplitted[0]);
            int y2 = Integer.parseInt(secondPointSplitted[1]);

            if(maxNumberX < x1 || maxNumberX < x2) {
                if (maxNumberX < x1) {
                    maxNumberX = x1;
                } else {
                    maxNumberX = x2;
                }
            }
            if(maxNumberY < y1 || maxNumberY < y2)
            {
                if (maxNumberY < y1)
                {
                    maxNumberY = y1;
                }
                else
                {
                    maxNumberY = y2;
                }
            }

            lines.add(new Line(x1, y1, x2, y2));
        }

        int[][] gameboard = new int[maxNumberX+1][maxNumberY+1];

        for(Line lineToDraw : lines)
        {
            List<Point> occupiedCoordinates = lineToDraw.getOccupiedCoordinates();

            for (Point occupiedPoint : occupiedCoordinates) {
                gameboard[occupiedPoint.getX()][occupiedPoint.getY()]++;
            }
        }

        int countOccupied = 0;

        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                if(gameboard[i][j] > 1)
                {
                    countOccupied++;
                }
            }
        }

        System.out.println(countOccupied);
    }
}
