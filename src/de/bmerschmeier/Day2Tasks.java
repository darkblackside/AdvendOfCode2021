package de.bmerschmeier;

import de.bmerschmeier.models.Submarine;

import java.util.List;

public class Day2Tasks {

    public void Task1And2() {
        Submarine submarine = new Submarine(0, 0);
        List<String> inputs = Helper.ReadFileLineByLine("resources/Day2/inputDay2Task1.txt");

        for(String command : inputs) {
            String[] commandSplitted = command.split("\\s+");

            String direction = commandSplitted[0];
            int fields = Integer.parseInt(commandSplitted[1]);

            switch(direction)
            {
                case "forward": submarine.forwards(fields); break;
                case "backward": submarine.backwards(fields); break;
                case "down": submarine.down(fields); break;
                case "up": submarine.up(fields); break;
            }
        }

        System.out.println(submarine.getDepth() * submarine.getHorizontalPosition());
    }
}
