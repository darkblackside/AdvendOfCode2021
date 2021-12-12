package de.bmerschmeier;

import java.io.IOException;
import java.util.List;

public class Day1Tasks {
    public void Task1() throws IOException {
        List<Integer> allNumbers = Helper.StringListToInt(Helper.ReadFileLineByLine("resources/Day1/inputDay1Task1.txt"));

        Integer lastNumber = null;
        int increasedNumberCounter = 0;

        for(int i = 0; i < allNumbers.size(); i++)
        {
            int currentNumber = allNumbers.get(i);

            if(lastNumber != null && lastNumber < currentNumber)
            {
                increasedNumberCounter++;
            }

            lastNumber = currentNumber;
        }
        System.out.println(increasedNumberCounter);
    }

    public void Task2() throws IOException {

        List<Integer> allNumbers = Helper.StringListToInt(Helper.ReadFileLineByLine("resources/Day1/inputDay1Task1.txt"));

        Integer lastSlidingWindowSum = null;
        int increasedNumberCounter = 0;

        for(int i = 0; i < allNumbers.size() - 2; i++)
        {
            int currentSlidingWindowSum = allNumbers.get(i) + allNumbers.get(i + 1) + allNumbers.get(i + 2);

            if(lastSlidingWindowSum != null && lastSlidingWindowSum < currentSlidingWindowSum)
            {
                increasedNumberCounter++;
            }

            lastSlidingWindowSum = currentSlidingWindowSum;
        }

        System.out.println(increasedNumberCounter);
    }
}
