import java.util.ArrayList;
import java.util.Scanner;
public class Strings {
    private String Word;
    public static void Func (Strings[] args){
        ArrayList<String> listOfWords = new ArrayList<>();

        String word = "";
        while(!word.equals("end")){
            System.out.println("Write a phrase");
            Scanner scanner = new Scanner(System.in);
            word = scanner.nextLine();
            listOfWords.add(word);
        }
        System.out.println(listOfWords.size() - 1);
    }
}
