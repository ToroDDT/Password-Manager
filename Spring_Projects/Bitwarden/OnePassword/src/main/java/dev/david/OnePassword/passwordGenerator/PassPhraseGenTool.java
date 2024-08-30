package dev.david.OnePassword.passwordGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PassPhraseGenTool {
    private ArrayList<String> passPhrase;
    private String word;
    public String readFileOfWords() {
        try {
            File file = new File("words.txt");
            Scanner myFile = new Scanner(file);
            while (myFile.hasNextLine()) {
                String word = myFile.nextLine();
                setWord(word);
            }
            myFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public ArrayList getPassPhrase() {
        return passPhrase;
    }

    public void setPassPhrase(ArrayList passPhrase) {
        this.passPhrase = passPhrase;
    }
    private String[] generatePassPhrase(Integer length, String divider) {
        Random random = new Random();
        readFileOfWords();
        String[] newPassPhrase = new String[(length * 2)];
        for (int i = 0; i < length; i++){
            if (i % 2 == 0) {
                int randomIndex = random.nextInt(206);
                newPassPhrase[i] = this.randomWords.get(randomIndex);
            } else {
                newPassPhrase[i] = divider;
            }
        }
        return newPassPhrase;
    }
}
