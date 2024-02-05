import java.util.Random;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        // generate a random number 
        // 
            Random rand = new Random();
            int randomInteger = rand.nextInt(100);
            int user_Choice = userInput();
            compareValues(user_Choice, randomInteger);

    }
    // the value that will be returned would be an integer 
    public static Integer userInput() {
        // print string to console 
            System.out.println("Guess a Number");
        // read value that was entered and store in a varaible 
            Scanner input = new Scanner(System.in);
        // read the value as an interger 
            int answer = input.nextInt();
        // store input integer in a variable called int answer
        // return value 
            return answer;
            
    }

    public static Boolean compareValues(int number, int randomInteger) {

        return true;
    }
}

// Number Guessing Game 
// need user input 
// calcualte a random number 
// ask for user input 
// how to read input and assign it to a variable
// store user input in a variable 
// compare input value to random number value 
// print if the answer is high, low, or correct 
// what are the possible condtions 