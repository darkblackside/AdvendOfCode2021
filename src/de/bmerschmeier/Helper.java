package de.bmerschmeier;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Helper {
    public static List<String> ReadFileLineByLine(String inputFile)
    {
        ArrayList<String> result = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<Integer> StringListToInt(List<String> input)
    {
        return input.stream()
                        .map(Integer::valueOf)
                        .collect(Collectors.toList());
    }
}
