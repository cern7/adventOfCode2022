import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.LinkPermission;

public class Day4 {
    private static final String inputPath = "inputDay4.txt";
    private static int assgPair;

    private static void sol1() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        String line;

        while (reader.ready()) {
            line = reader.readLine();

            int firstElfStart = Integer.parseInt(line.split(",")[0].split("-")[0]);
            int firstElfEnd = Integer.parseInt(line.split(",")[0].split("-")[1]);
            int secondElfStart = Integer.parseInt(line.split(",")[1].split("-")[0]);
            int secondElfEnd = Integer.parseInt(line.split(",")[1].split("-")[1]);
//            if (firstElfStart <= secondElfStart && firstElfEnd >= secondElfEnd) {
//                assgPair++;
//            } else if (secondElfStart <= firstElfStart && secondElfEnd >= firstElfEnd) {
//                assgPair++;
//            }
            if (firstElfEnd < secondElfStart || firstElfStart > secondElfEnd) {
            } else {
                assgPair++;
            }
//            break;
        }
        System.out.println(assgPair);
    }

    public static void main(String[] args) throws IOException {
        sol1();
    }

}
