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
    roundScore = shapeScore(1 for A&X,
                            2 for B&Y
                            and 3 for C&Z) + (0 for lose,
                                                3 for draw
                                                and 6 for win)
     */

    static final String inputPath = "inputDay2.txt";
    static final Map<Character, Integer> opponentMap = new HashMap<>(3);
    static final Map<Character, Integer> myMap = new HashMap<>(3);
    static int myScore1 = 0;
    static int myScore2 = 0;

    static {
        opponentMap.put('A', 0);
        opponentMap.put('B', 1);
        opponentMap.put('C', 2);
        myMap.put('X', 0);
        myMap.put('Y', 1);
        myMap.put('Z', 2);
    }

    private static void getScore() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        String currLine;
        int tempScore = 0;
        while ((currLine = reader.readLine()) != null) {
            int opponent = opponentMap.get(currLine.charAt(0));
            int me = myMap.get(currLine.charAt(2));
            myScore1 += me > 1 ? 3 : me < 1 ? 1 : 2;
            getFirstScore(opponent, me);
            getSecondScore(opponent, me);
        }

    }

    private static void getSecondScore(int opponent, int me) {
        /*
        X - Rock - 0 - to lose  'A', 1
        Y - Paper - 1 - draw    'B', 2
        Z - Scissors - 2 - win  'C', 3
         */
//        A&X defeats C&Z
//        C&Z defeats B&Y
//        B&Y defeats A&X

        if (me == 1) { // draw
            myScore2 += 3;
            myScore2 += opponent > 1 ? 3 : opponent < 1 ? 1 : 2;
        } else if (me == 2) { // win
            myScore2 += 6;
            myScore2 += opponent > 1 ? 1 : opponent < 1 ? 2 : 3;
        } else if (me == 0) { // lose
            myScore2 += opponent > 1 ? 2 : opponent < 1 ? 3 : 1;
        }

    }

    private static void getFirstScore(int opponent, int me) {
        if ((opponent + 1) % 3 == me) {
            // I win
            myScore1 += 6;
        } else if (opponent == me) {
            // draw
            myScore1 += 3;
        }  // I lose

    }

    public static void main(String[] args) throws IOException {
        getScore();
        System.out.println(myScore1);
        System.out.println(myScore2);

    }
}
