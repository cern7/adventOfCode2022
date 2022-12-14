import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day2 {
    /*
    A - Rock <==> X - Rock
    B - Paper <==> Y - Paper
    C - Scissors <==> Z - Scissors
    A&X defeats C&Z
    C&Z defeats B&Y
    B&Y defeats A&X
    totalScore = scoreRound1 + scoreRound2 + ... + scoreRoundN
    roundScore = shapeScore(1 for A&X, 2 for B&Y and 3 for C&Z) + (0 for lose, 3 for draw and 6 for win)
     */

    static final String inputPath = "inputDay2.txt";
    static final Map<Character, Integer> opponentMap = new HashMap<>(3);
    static final Map<Character, Integer> myMap = new HashMap<>(3);
    static int myScore = 0;

    static {
        opponentMap.put('A', 0);
        opponentMap.put('B', 1);
        opponentMap.put('C', 2);
        myMap.put('X', 0);
        myMap.put('Y', 1);
        myMap.put('Z', 2);
    }

    private static int getScore() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        String currLine;
        while ((currLine = reader.readLine()) != null) {
            int opponent = opponentMap.get(currLine.charAt(0));
            int me = myMap.get(currLine.charAt(2));
            myScore += me > 1 ? 3 : me < 1 ? 1 : 2;
            if ((opponent + 1) % 3 == me) {
                // I win
                myScore += 6;
            } else if (opponent == me) {
                // draw
                myScore += 3;
            } else {
                // I lose
            }
        }
        return myScore;
    }

    public static void main(String[] args) throws IOException {

        System.out.println(getScore());
    }
}
