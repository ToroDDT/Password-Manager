package dev.david.OnePassword.passwordGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PassPhraseGenTool {
    private String passPhrase;
    private ArrayList<String> randomWords;
    public String getPassPhrase() {
        return passPhrase;
    }
    public void setPassPhrase(Integer length) {
        this.passPhrase = Arrays.toString(generatePassPhrase(length));
    }
    public void setPassPhrase(Integer length, String divider) {
        this.passPhrase = Arrays.toString(generatePassPhrase(length, divider));
    }
    public void readFileOfWords() {
        try {
            File file = new File("words.txt");
            Scanner myFile = new Scanner(file);
            while (myFile.hasNextLine()) {
                String word = myFile.nextLine();
                this.randomWords.add(word);
            }
            myFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
   private String[] generatePassPhrase(Integer length) {
        Random random = new Random();
        readFileOfWords();
        String[] newPassPhrase = new String[length];
        for (int i = 0; i < length; i++){
            int randomIndex = random.nextInt(206);
            newPassPhrase[i] = this.randomWords.get(randomIndex);
        }
        return newPassPhrase;
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
