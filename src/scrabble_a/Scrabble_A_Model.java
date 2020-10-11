package scrabble_a;
import java.util.*;

public class Scrabble_A_Model {
    int point = 0;
    String newWord;

    int[] letterBagArrayChk = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public Scrabble_A_Model (String newWord) {
        this.newWord = newWord.toUpperCase();
    }

    // word restrictions
    public boolean validWord() throws IllegalArgumentException {
        if (newWord.length() == 0) {
            throw new IllegalArgumentException(
                    String.format("Word is blank")
            );
        }
        else if (newWord.length() == 1) {
            throw new IllegalArgumentException(
                    String.format("Word is too short: %s", newWord)
            );
        }
        else if (newWord.length() > 8) {
            throw new IllegalArgumentException(
                    String.format("Word is too long (more than 8 characters): %s", newWord)
            );
        }
        else if (newWord.indexOf("A") == -1 && newWord.indexOf("E") == -1 && newWord.indexOf("I") == -1
                && newWord.indexOf("O") == -1 && newWord.indexOf("U") == -1 && newWord.indexOf("Y") == -1  ) {
            throw new IllegalArgumentException(
                    String.format("Word does not include vowel: %s", newWord)
            );
        }

        return true;
    }

    // function for calculating points
    public int calWord() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Set<String> keySet = map.keySet();

        map.put("A", 1); map.put("B", 3); map.put("C", 3); map.put("D", 2); map.put("E", 1); map.put("F", 4);
        map.put("G", 2); map.put("H", 4); map.put("I", 1); map.put("J", 8); map.put("K", 5); map.put("L", 1);
        map.put("M", 3); map.put("N", 1); map.put("O", 1); map.put("P", 3); map.put("Q", 10); map.put("R", 1);
        map.put("S", 1); map.put("T", 1); map.put("U", 1); map.put("V", 4); map.put("W", 4); map.put("X", 8);
        map.put("Y", 4); map.put("Z", 10);

        for(int i = 0; i < newWord.length(); i++) {
            for (String c : keySet) {
                if(String.valueOf(newWord.charAt(i)).equals(c)) {
                    point += map.get(c);
                }
            }
        }

        return point;
    }

    // function for checking if user's word has more word than available count
    public void tempArray() {
        for (int i = 0; i < newWord.length(); i++) {
            if (String.valueOf(newWord.charAt(i)).equals("A")) {letterBagArrayChk[0] = letterBagArrayChk[0] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("B")) {letterBagArrayChk[1] = letterBagArrayChk[1] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("C")) {letterBagArrayChk[2] = letterBagArrayChk[2] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("D")) {letterBagArrayChk[3] = letterBagArrayChk[3] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("E")) {letterBagArrayChk[4] = letterBagArrayChk[4] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("F")) {letterBagArrayChk[5] = letterBagArrayChk[5] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("G")) {letterBagArrayChk[6] = letterBagArrayChk[6] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("H")) {letterBagArrayChk[7] = letterBagArrayChk[7] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("I")) {letterBagArrayChk[8] = letterBagArrayChk[8] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("J")) {letterBagArrayChk[9] = letterBagArrayChk[9] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("K")) {letterBagArrayChk[10] = letterBagArrayChk[10] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("L")) {letterBagArrayChk[11] = letterBagArrayChk[11] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("M")) {letterBagArrayChk[12] = letterBagArrayChk[12] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("N")) {letterBagArrayChk[13] = letterBagArrayChk[13] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("O")) {letterBagArrayChk[14] = letterBagArrayChk[14] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("P")) {letterBagArrayChk[15] = letterBagArrayChk[15] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("Q")) {letterBagArrayChk[16] = letterBagArrayChk[16] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("R")) {letterBagArrayChk[17] = letterBagArrayChk[17] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("S")) {letterBagArrayChk[18] = letterBagArrayChk[18] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("T")) {letterBagArrayChk[19] = letterBagArrayChk[19] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("U")) {letterBagArrayChk[20] = letterBagArrayChk[20] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("V")) {letterBagArrayChk[21] = letterBagArrayChk[21] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("W")) {letterBagArrayChk[22] = letterBagArrayChk[22] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("X")) {letterBagArrayChk[23] = letterBagArrayChk[23] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("Y")) {letterBagArrayChk[24] = letterBagArrayChk[24] + 1; }
            if (String.valueOf(newWord.charAt(i)).equals("Z")) {letterBagArrayChk[25] = letterBagArrayChk[25] + 1; }
        }
    }
}
