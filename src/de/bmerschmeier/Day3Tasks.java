package de.bmerschmeier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3Tasks {
    public void Task1() {
        int[][] inputMatrix = GetInputAsMatrix();

        int bitCounter[] = new int[inputMatrix[0].length];

        for(int i = 0; i < inputMatrix.length; i++)
        {
            for(int j = 0; j < inputMatrix[i].length; j++)
            {
                bitCounter[j] += inputMatrix[i][j];
            }
        }

        String gammaRateBits[] = new String[bitCounter.length];
        String epsilonRateBits[] = new String[bitCounter.length];

        for(int i = 0; i < bitCounter.length; i++)
        {
            gammaRateBits[i] = bitCounter[i] > inputMatrix.length/2 ? "1" : "0";
            epsilonRateBits[i] = bitCounter[i] > inputMatrix.length/2 ? "0" : "1";
        }

        int gammaRate = Integer.parseInt(String.join("", gammaRateBits), 2);
        int epsilonRate = Integer.parseInt(String.join("", epsilonRateBits), 2);

        System.out.println(gammaRate * epsilonRate);
    }

    public void Task2()
    {
        int[][] inputMatrix = GetInputAsMatrix();

        for(int i = 0; i < inputMatrix[0].length && inputMatrix.length > 1; i++)
        {
            int sum = getSum(inputMatrix, i);

            int filterBitBy = 0;
            if(sum >= inputMatrix.length/2.0)
            {
                filterBitBy = 1;
            }

            inputMatrix = filterEntriesByGetOnlyBits(inputMatrix, i, filterBitBy);
        }
        int oxygenGeneratorRating = Integer.parseInt(String.join("", IntToString(inputMatrix[0])), 2);

        inputMatrix = GetInputAsMatrix();
        for(int i = 0; i < inputMatrix[0].length && inputMatrix.length > 1; i++)
        {
            int sum = getSum(inputMatrix, i);

            int filterBitBy = 1;
            if(sum >= inputMatrix.length/2.0)
            {
                filterBitBy = 0;
            }

            inputMatrix = filterEntriesByGetOnlyBits(inputMatrix, i, filterBitBy);
        }
        int co2scrubberRating = Integer.parseInt(String.join("", IntToString(inputMatrix[0])), 2);

        System.out.println(oxygenGeneratorRating * co2scrubberRating);
    }

    private int getSum(int[][] inputMatrix, int i) {
        int sum = 0;

        for(int j = 0; j < inputMatrix.length; j++)
        {
            sum += inputMatrix[j][i];
        }
        return sum;
    }

    private int[][] filterEntriesByGetOnlyBits(int[][] inputMatrix, int i, int getOnlyBitsWhere) {
        ArrayList<int[]> tempList = new ArrayList<int[]>();
        for(int j = 0; j < inputMatrix.length; j++)
        {
            if(inputMatrix[j][i] == getOnlyBitsWhere)
            {
                tempList.add(inputMatrix[j]);
            }
        }

        inputMatrix = tempList.toArray(inputMatrix);

        inputMatrix = new int[tempList.size()][inputMatrix[0].length];

        for(int j = 0; j < tempList.size(); j++)
        {
            inputMatrix[j] = tempList.get(j);
        }
        return inputMatrix;
    }

    private String[] IntToString(int[] nums){
        String[] a = Arrays.toString(nums).split("[\\[\\]]")[1].split(", ");
        return a;
    }

    private int[][] GetInputAsMatrix() {
        List<String> inputLines = Helper.ReadFileLineByLine("resources/Day3/task1input.txt");
        int[][] inputMatrix = new int[inputLines.size()][inputLines.get(0).length()];

        for(int i = 0; i < inputLines.size(); i++) {
            for(int j = 0; j < inputLines.get(i).length(); j++)
            {
                String oneChar = inputLines.get(i).substring(j, j+1);
                inputMatrix[i][j] = Integer.parseInt(oneChar);
            }
        }

        return inputMatrix;
    }
}
