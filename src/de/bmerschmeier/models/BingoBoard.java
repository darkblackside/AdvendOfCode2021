package de.bmerschmeier.models;

public class BingoBoard {
    private int[][] numbers;
    private boolean[][] marked;
    private int lastMarkedNumber;
    private boolean alreadyWon;

    public BingoBoard(int[][] numberInput)
    {
        numbers = numberInput;
        marked = new boolean[numberInput.length][numberInput[0].length];

        if(marked.length != marked[0].length)
        {
            throw new RuntimeException("Length is not the same in x and y");
        }
    }

    public void MarkNumber(int number)
    {
        for(int i = 0; i < numbers.length; i++)
        {
            for(int j = 0; j < numbers.length; j++)
            {
                if(numbers[i][j] == number)
                {
                    marked[i][j] = true;
                    lastMarkedNumber = number;
                }
            }
        }
    }

    public boolean HasWon()
    {
        boolean hasWon = false;

        for(int i = 0; i < marked.length; i++)
        {
            int countMarkedFieldsHorizontal = 0;
            int countMarkedFieldsVertical = 0;

            for(int j = 0; j < marked[i].length; j++)
            {
                if(marked[i][j])
                {
                    countMarkedFieldsHorizontal++;
                }

                if(marked[j][i])
                {
                    countMarkedFieldsVertical++;
                }
            }

            if(countMarkedFieldsHorizontal == marked[i].length || countMarkedFieldsVertical == marked.length)
            {
                hasWon = true;
                alreadyWon = true;
                break;
            }
        }

        return hasWon;
    }

    public int GetFinalScore()
    {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if(!marked[i][j])
                {
                    sum += numbers[i][j];
                }
            }
        }

        return sum * lastMarkedNumber;
    }

    public boolean AlreadyWon() {
        return alreadyWon;
    }
}
