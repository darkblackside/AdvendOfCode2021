package de.bmerschmeier;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        //Day 1
        /*Day1Tasks day1Tasks = new Day1Tasks();
        day1Tasks.Task1();
        day1Tasks.Task2();*/

        //Day 2
        Day2Tasks day2Tasks = new Day2Tasks();
        //For task two: Changed to use aim instead of depth for up and down
        day2Tasks.Task1And2();
    }
}
