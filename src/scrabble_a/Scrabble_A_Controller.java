package scrabble_a;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Scrabble_A_Controller {
    ArrayList<String> newWordList = new ArrayList<String>();
    String newWordDisplay = "";
    int getPoints = 0;
    int letterChk = 0;

    Boolean disableAlpahbet = true;

    Map<String, Integer> map = new HashMap<String, Integer>();
    Set<String> mapKeySet = map.keySet();

    public void putMap() {
        map.put("A", 9); map.put("B", 2); map.put("C", 2); map.put("D", 4); map.put("E", 12); map.put("F", 2);
        map.put("G", 3); map.put("H", 2); map.put("I", 8); map.put("J", 1); map.put("K", 1); map.put("L", 4);
        map.put("M", 2); map.put("N", 6); map.put("O", 8); map.put("P", 2); map.put("Q", 1); map.put("R", 6);
        map.put("S", 4); map.put("T", 6); map.put("U", 4); map.put("V", 2); map.put("W", 2); map.put("X", 1);
        map.put("Y", 2); map.put("Z", 1);
    }

    int[] letterBagArray = {9, 2, 2, 4, 12, 2, 3, 2, 8, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1};
    char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    @FXML
    TextField newWord;

    @FXML
    TextArea preWords;

    @FXML
    Label lblPoint, errDisplay;

    @FXML
    Button A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, submit;

    @FXML
    public void onSubmit (ActionEvent event) {
        String valueNewWord = newWord.getText().toUpperCase();
        Scrabble_A_Model scrabble_a_model = new Scrabble_A_Model(valueNewWord);

        if (newWordList.size() == 0)
        {
            putMap();
        }

        try {
            // validate user's word
            scrabble_a_model.validWord();

            // check if user's word has more word than available count
                // step 1
            scrabble_a_model.tempArray();
                // step 2
                // if (user's word count> available count) => error
            for (int i = 0; i < scrabble_a_model.letterBagArrayChk.length; i++) {
                if (scrabble_a_model.letterBagArrayChk[i] > letterBagArray[i]) {
                    disableAlpahbet = false;
                    newWord.setText("");
                    newWord.requestFocus();

                    throw new IllegalArgumentException(
                            String.format("Word contains letter that is no longer available “in bag”: %s\r\n%s - %d left"
                                            , valueNewWord, alphabet[i], letterBagArray[i])
                    );
                }
              }

            if (disableAlpahbet) {
                // check if user's word has already existed
                if (newWordList.contains(valueNewWord)) {
                    throw new IllegalArgumentException(
                            String.format("Word was already entered: %s", valueNewWord)
                    );
                }
                else {
                    // if the word is the first one
                    if (newWordList.size() == 0) {
                        newWordDisplay = newWord.getText().toUpperCase();
                    }
                    // if previous words list has at least one word,
                        // previous world + ", " + new word
                    else {
                        newWordDisplay = newWordDisplay + ", " + newWord.getText().toUpperCase();
                    }

                    newWordList.add(newWord.getText().toUpperCase());

                    // display all words
                    preWords.setText(newWordDisplay);
                    // initialize text field for typing a new word
                    newWord.setText("");
                    newWord.requestFocus();

                    // based on point system and user's word, calculate points and display
                    getPoints += scrabble_a_model.calWord();
                    lblPoint.setText(String.valueOf(getPoints));

                    // disappear err message
                    errDisplay.setText("");
                    
                    // if all letters in bag are used, the letter button is disabled
                    for (int i = 0; i < valueNewWord.length(); i++) {
                        for (int n = 0; n < 26; n++) {
                            if(valueNewWord.charAt(i) == alphabet[n])
                            {
                                letterBagArray[n] = letterBagArray[n] - 1;
                                System.out.println(valueNewWord.charAt(i) + ":" + letterBagArray[n] );

                                if (letterBagArray[n] == 0) {
                                    switch (valueNewWord.charAt(i)){
                                        case 'A':
                                            A.setDisable(true);
                                            break;
                                        case 'B':
                                            B.setDisable(true);
                                            break;
                                        case 'C':
                                            C.setDisable(true);
                                            break;
                                        case 'D':
                                            D.setDisable(true);
                                            break;
                                        case 'E':
                                            E.setDisable(true);
                                            break;
                                        case 'F':
                                            F.setDisable(true);
                                            break;
                                        case 'G':
                                            G.setDisable(true);
                                            break;
                                        case 'H':
                                            H.setDisable(true);
                                            break;
                                        case 'I':
                                            I.setDisable(true);
                                            break;
                                        case 'J':
                                            J.setDisable(true);
                                            break;
                                        case 'K':
                                            K.setDisable(true);
                                            break;
                                        case 'L':
                                            L.setDisable(true);
                                            break;
                                        case 'M':
                                            M.setDisable(true);
                                            break;
                                        case 'N':
                                            N.setDisable(true);
                                            break;
                                        case 'O':
                                            O.setDisable(true);
                                            break;
                                        case 'P':
                                            P.setDisable(true);
                                            break;
                                        case 'Q':
                                            Q.setDisable(true);
                                            break;
                                        case 'R':
                                            R.setDisable(true);
                                            break;
                                        case 'S':
                                            S.setDisable(true);
                                            break;
                                        case 'T':
                                            T.setDisable(true);
                                            break;
                                        case 'U':
                                            U.setDisable(true);
                                            break;
                                        case 'V':
                                            V.setDisable(true);
                                            break;
                                        case 'W':
                                            W.setDisable(true);
                                            break;
                                        case 'X':
                                            X.setDisable(true);
                                            break;
                                        case 'Y':
                                            Y.setDisable(true);
                                            break;
                                        case 'Z':
                                            Z.setDisable(true);
                                            break;
                                    }
                                }
                            }
                        }
                    }

                     
                }
            }

            // the game will be over
            // if (1) there is only one letter left
            //    (2) there is/are only consonant(s) left
            for (int i = 0; i < letterBagArray.length; i++) {
                letterChk += letterBagArray[i];

                if (letterBagArray[0] == 0 && letterBagArray[4] == 0
                    &&letterBagArray[8] == 0 && letterBagArray[14] == 0
                    && letterBagArray[20] == 0 && letterBagArray[24] == 0)
                {
                    letterChk = 1;
                }
            }
            if (letterChk == 1) {
                errDisplay.setText("Game Over");
                submit.setDisable(true);
                newWord.setDisable(true);
            }
        }
        catch(IllegalArgumentException e) {
            errDisplay.setText(e.getMessage());
            newWord.setText("");
            newWord.requestFocus();
        }

        disableAlpahbet = true;
        letterChk = 0;
    }
    @FXML
    public void btnA (ActionEvent event) {
        newWord.setText(newWord.getText() + "A");
    }
    @FXML
    public void btnB (ActionEvent event) {
        newWord.setText(newWord.getText() + "B");
    }
    @FXML
    public void btnC (ActionEvent event) {
        newWord.setText(newWord.getText() + "C");
    }
    @FXML
    public void btnD (ActionEvent event) {
        newWord.setText(newWord.getText() + "D");
    }
    @FXML
    public void btnE (ActionEvent event) {
        newWord.setText(newWord.getText() + "E");
    }
    @FXML
    public void btnF (ActionEvent event) {
        newWord.setText(newWord.getText() + "F");
    }
    @FXML
    public void btnG (ActionEvent event) {
        newWord.setText(newWord.getText() + "G");
    }
    @FXML
    public void btnH (ActionEvent event) {
        newWord.setText(newWord.getText() + "H");
    }
    @FXML
    public void btnI (ActionEvent event) {
        newWord.setText(newWord.getText() + "I");
    }
    @FXML
    public void btnJ (ActionEvent event) {
        newWord.setText(newWord.getText() + "J");
    }
    @FXML
    public void btnK (ActionEvent event) {
        newWord.setText(newWord.getText() + "K");
    }
    @FXML
    public void btnL (ActionEvent event) {
        newWord.setText(newWord.getText() + "L");
    }
    @FXML
    public void btnM (ActionEvent event) {
        newWord.setText(newWord.getText() + "M");
    }
    @FXML
    public void btnN (ActionEvent event) {
        newWord.setText(newWord.getText() + "N");
    }
    @FXML
    public void btnO (ActionEvent event) {
        newWord.setText(newWord.getText() + "O");
    }
    @FXML
    public void btnP (ActionEvent event) {
        newWord.setText(newWord.getText() + "P");
    }
    @FXML
    public void btnQ (ActionEvent event) {
        newWord.setText(newWord.getText() + "Q");
    }
    @FXML
    public void btnR (ActionEvent event) {
        newWord.setText(newWord.getText() + "R");
    }
    @FXML
    public void btnS (ActionEvent event) {
        newWord.setText(newWord.getText() + "S");
    }
    @FXML
    public void btnT (ActionEvent event) {
        newWord.setText(newWord.getText() + "T");
    }
    @FXML
    public void btnU (ActionEvent event) {
        newWord.setText(newWord.getText() + "U");
    }
    @FXML
    public void btnV (ActionEvent event) {
        newWord.setText(newWord.getText() + "V");
    }
    @FXML
    public void btnW (ActionEvent event) {
        newWord.setText(newWord.getText() + "W");
    }
    @FXML
    public void btnX (ActionEvent event) {
        newWord.setText(newWord.getText() + "X");
    }
    @FXML
    public void btnY (ActionEvent event) {
        newWord.setText(newWord.getText() + "Y");
    }
    @FXML
    public void btnZ (ActionEvent event) {
        newWord.setText(newWord.getText() + "Z");
    }
}
