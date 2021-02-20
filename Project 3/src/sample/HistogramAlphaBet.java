package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
*   Calculates the n most frequent alphabet
*   characters in the text and prints out a
*   frequency table
 */

public class HistogramAlphaBet {
    HashMap<Character, Integer> hashMap = new HashMap<>();
    int total;

    public HistogramAlphaBet(String pathname) {
        File file = new File(pathname);
        Scanner scanner = null;
        total = 0;

        // Upload file
        try {
            scanner = new Scanner(file,"utf-8");
        } catch (FileNotFoundException e) { e.printStackTrace(); }

        // Loop every character
        while (scanner.hasNext()) {
            char[] chars = scanner.nextLine().toLowerCase().toCharArray();
            for (Character c : chars) {
                if(!Character.isLetter(c)){ // Skip non characters
                    continue;
                }
                else if (hashMap.containsKey(c)) {
                    hashMap.put(c, hashMap.get(c) + 1); // Increment
                } else {
                    hashMap.put(c, 1); // Unique
                }
                total++;
            }
        }

    }

    public void createFrequency(){
        System.out.println("----------------------------");
        System.out.printf("%5s %10s" , "Character", "Frequency");
        System.out.println();
        System.out.println("----------------------------");
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            System.out.format("%5s %10s", entry.getKey(), entry.getValue());
            System.out.println();
        }
        System.out.println("Total: " + total);
        System.out.println("----------------------------");

    }


}
