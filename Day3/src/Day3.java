import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
                    if (ch > 64 && ch < 91) {// is lowercase char
                        prioritiesSum += (ch - 38);
                    } else if (ch > 96) {
                        prioritiesSum += (ch - 96);
                    }
                }
            }
        }
        System.out.println(prioritiesSum);
    }

    public static void main(String[] args) throws IOException {
        sol();
    }
}
