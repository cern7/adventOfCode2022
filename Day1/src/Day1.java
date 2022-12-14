import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day1 {

    static String inputPath = "inputDay1.txt";
    static int max = Integer.MIN_VALUE;
    static int first = Integer.MIN_VALUE;
    static int second = first;
    static int third = first;
    static int totalTopThreeElfCalories = 0;

    private static void readFile() throws IOException {
        String currLine;
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        int elf = 1;
        int calories = 0;

        while ((currLine = reader.readLine()) != null) {
            if (!currLine.trim().isEmpty()) {
                calories += Integer.parseInt(currLine);
            } else {
                elf++;
                if (calories > max) {
                    max = calories;
                }
                if (calories > first) {
                    third = second;
                    second = first;
                    first = calories;
                } else if (calories > second) {
                    third = second;
                    second = calories;
                } else if (calories > third) {
                    third = calories;
                }
                calories = 0;
            }
        }
        totalTopThreeElfCalories = first + second + third;
    }

    public static void main(String[] args) throws IOException {
        readFile();
    }
}
