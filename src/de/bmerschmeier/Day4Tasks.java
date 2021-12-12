package de.bmerschmeier;

import de.bmerschmeier.models.BingoBoard;

import java.util.ArrayList;
import java.util.List;

public class Day4Tasks {
    public void Task1() {
        List<String> inputLines = Helper.ReadFileLineByLine("resources/Day4/task1input.txt");

        ArrayList<Integer> calledNumbers = ExtractCalledNumbers(inputLines.get(0));
        ArrayList<BingoBoard> bingoBoards = new ArrayList<>();

        for (int i = 1; i + 6 < inputLines.size(); i += 6) {
            BingoBoard board = ReadBingoboard(inputLines, i, i + 5);
            bingoBoards.add(board);
        }

        boolean someoneWon = false;
        int currentDrawingIndex = 0;
        int winningNumber = 0;

        while(!someoneWon && currentDrawingIndex < calledNumbers.size())
        {
            int drawnNumber = calledNumbers.get(currentDrawingIndex);

            for (int i = 0; i < bingoBoards.size(); i++) {
                if(!bingoBoards.get(i).AlreadyWon())
                {
                    bingoBoards.get(i).MarkNumber(drawnNumber);
                    if(bingoBoards.get(i).HasWon())
                    {
                        //Task 1
                        //someoneWon = true;
                        winningNumber = bingoBoards.get(i).GetFinalScore();
                    }
                }
            }

            currentDrawingIndex++;
        }

        System.out.println(winningNumber);
    }

    private BingoBoard ReadBingoboard(List<String> inputLines, int start, int end) {
        String[] tempnumbersasstring = inputLines.get(start + 1).split("\\s+");
        int numberCounter = 0;
        for (int i = 0; i < tempnumbersasstring.length; i++) {
            if(tempnumbersasstring[i].matches("[0-9]+"))
            {
                numberCounter++;
            }
        }
        int[][] numbers = new int[end - start][numberCounter];

        for (int i = start + 1; i <= end; i++) {
            String[] numbersAsString = inputLines.get(i).split("\\s+");

            int k = 0;
            for (int j = 0; j < numbersAsString.length; j++) {
                if(numbersAsString[j].matches("[0-9]+"))
                {
                    numbers[i - start - 1][k++] = Integer.parseInt(numbersAsString[j]);
                }
            }
        }

        return new BingoBoard(numbers);
    }

    private ArrayList<Integer> ExtractCalledNumbers(String inputLine) {
        ArrayList<Integer> calledNumbers = new ArrayList<>();
        String[] firstLineSplitted = inputLine.split(",");
        for(String oneNumber : firstLineSplitted)
        {
            calledNumbers.add(Integer.parseInt(oneNumber));
        }

        return calledNumbers;
    }
}
