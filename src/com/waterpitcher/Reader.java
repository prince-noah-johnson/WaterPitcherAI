package com.waterpitcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;


public class Reader {
    private Reader() {
    }

    public static Input getInput(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner reader = new Scanner(file);

        // Capacities of each pitcher in a List
        List<Integer> inputList = Arrays.stream(reader.nextLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // Target value
        int secondLineValue = Integer.parseInt(reader.nextLine());

        return new Input(inputList, secondLineValue);
    }
}