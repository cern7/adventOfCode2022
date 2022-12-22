import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day3 {
    private static final String inputPath = "inputDay3.txt";
    private static int prioritiesSum;

    private static void sol() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        String line;
        while ((line = reader.readLine()) != null) {
            int[] firstCompartment = new int[123];
            int[] secondCompartment = new int[123];
            int size = line.length();
            for (int i = 0; i < size / 2; i++) {
                firstCompartment[122 % line.charAt(i)]++;
            }
            for (int i = size / 2; i < size; i++) {
                secondCompartment[122 % line.charAt(i)]++;
            }
            for (int i = 0; i < firstCompartment.length; i++) {
                if (firstCompartment[i] > 0 && secondCompartment[i] != 0) {
                    int ch = 122 - i;
                    prioritiesSum += ch > 96 ? ch - 96 : ch - 38;
                }
            }
        }
        System.out.println(prioritiesSum);
    }

    private static void sol2() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        String[] group = new String[3];
        while (reader.ready()) {
            group[0] = reader.readLine();
            group[1] = reader.readLine();
            group[2] = reader.readLine();
            for (int i = 0; i < group[0].length(); i++) {
                char ch = group[0].charAt(i);
                if (group[1].contains(ch + "") && group[2].contains(ch + "")) {
                    prioritiesSum += ch > 96 ? ch - 96 : ch - 38;
                    break;
                }
            }
        }
        System.out.println(prioritiesSum);

    }

    public static void main(String[] args) throws IOException {
        //sol();
        sol2();
    }
}
