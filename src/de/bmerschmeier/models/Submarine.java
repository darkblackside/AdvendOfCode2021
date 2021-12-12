package de.bmerschmeier.models;

import de.bmerschmeier.exceptions.NegativeDepthsException;

public class Submarine {
    private int HorizontalPosition;
    private int Depth;
    private int Aim;

    public Submarine(int startHorizontal, int startDepth)
    {
        HorizontalPosition = startHorizontal;
        Depth = startDepth;
    }

    public void down(int input) {
        Aim += input;
    }

    public void up(int input) {
        Aim -= input;
    }

    public void forwards(int input) {
        HorizontalPosition += input;
        Depth += Aim * input;
    }

    public void backwards(int input) {
        HorizontalPosition -= input;
        Depth -= Aim * input;
    }

    public int getHorizontalPosition() {
        return HorizontalPosition;
    }

    public int getDepth() {
        return Depth;
    }
}
