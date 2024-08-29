package dev.david.OnePassword.passwordGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        return null;
    }
    public ArrayList getPassPhrase() {
        return passPhrase;
    }

    public void setPassPhrase(ArrayList passPhrase) {
        this.passPhrase = passPhrase;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
    // Generate a word

    // add generated word to arraylist

    // add special divider after each word
}
