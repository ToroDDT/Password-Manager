package dev.david.OnePassword.passwordGenerator;

import dev.david.OnePassword.form_data.PasswordFormData;

import java.util.*;


public class PasswordGenTool {
    private String password;
    private ArrayList<Object> randomCharactersObject;
    public Object passwordArray () {
        return new ArrayList<Object>();
    }
    private static ArrayList<String> generateNumbers ( int maxAmount ) {
       // Create an instance of Random Class
        Random random = new Random();
       // Create a list to store RandomNumbers that are generated
       ArrayList<Integer> randomNumbersList = new ArrayList<Integer>();
       for(int i = 0; i < maxAmount; i++){
           // Generate Random Number between 0 - 11
           int randomNumber = random.nextInt(10);
           randomNumbersList.add(randomNumber);
       }
       // Create an array list of type string to store converted integers to strings
        ArrayList<String> randomNumbersListStringVersion = new ArrayList<>();
       // convert randomNumbersList type to string
        for (Integer num : randomNumbersList){
            randomNumbersListStringVersion.add(num.toString());
        }
        return randomNumbersListStringVersion;
    }
    private static ArrayList<String> generateLowerCaseLetters (int maxAmount) {
        Random rand = new Random();
        char[] alphabetLowerCase = new char[26];
        ArrayList<String> randomLowerCaseLettersArr = new ArrayList<>();
        for (int i = 0; i < alphabetLowerCase.length; i++) {
            alphabetLowerCase[i] = (char) ('a' + i);
        }
        for (int i = 0; i < maxAmount; i++) {
            int randomNumber = rand.nextInt(26);
            randomLowerCaseLettersArr.add(String.valueOf(alphabetLowerCase[randomNumber]));
        }
        return randomLowerCaseLettersArr;
    }
    private static ArrayList<String> generateUpperCaseLetters (int maxAmount) {
        Random rand = new Random();
        char[] alphabetUpperCase = new char[26];
        ArrayList<String> randomUpperCaseLettersArr = new ArrayList<>();
        for (int i = 0; i < alphabetUpperCase.length; i++) {
            alphabetUpperCase[i] = (char) ('A' + i);
        }
        for (int i = 0; i < maxAmount; i++) {
            int randomNumber = rand.nextInt(26);
            randomUpperCaseLettersArr.add(String.valueOf(alphabetUpperCase[randomNumber]));
        }
        return randomUpperCaseLettersArr;
    }

    private static ArrayList<String> generateSpecialLetters () {
        return new ArrayList<>(Arrays.asList("@","%","!","$"));
    }
    public void generateRandomPassword (PasswordFormData passwordFormData) {
        String[] characterArr = new String[passwordFormData.getLength()];
        ArrayList<ArrayList<String>> multiDimList = new ArrayList<>();

        var lengthOfCharacterArr = characterArr.length;

        if (passwordFormData.getA_z()) {
            multiDimList.add(generateLowerCaseLetters(passwordFormData.getLength()));
        }
        if (passwordFormData.getCapital_A_Z()){
            multiDimList.add(generateUpperCaseLetters(passwordFormData.getLength()));
        }
        if(passwordFormData.getSpecialCharacters()) {
            multiDimList.add((generateSpecialLetters()));
        }
        if(passwordFormData.getZeroToNine()) {
            multiDimList.add(generateNumbers(passwordFormData.getLength()));
        }
        ArrayList<String> flattenList = flatten(multiDimList);
        ArrayList<String> randomizedChars = randomizedCharacters(flattenList, passwordFormData.getLength());
        String newPassword = concatenateArrayList(randomizedChars);
        setPassword(newPassword);
    }

    public static String concatenateArrayList (ArrayList<String> array) {
        StringBuilder arrayListToString = new StringBuilder();
        for (String element : array) {
            arrayListToString.append(element);
        }
        return arrayListToString.toString();
    }

    public static ArrayList<String> randomizedCharacters(ArrayList<String> flattenList, int length) {
        Random rand = new Random();
        ArrayList<String> randomizedChars = new ArrayList<>();

        int lengthOfList = flattenList.size();
        for (int i = 0; i < length; i++){
            int randomIndex = rand.nextInt(lengthOfList - 1);
            randomizedChars.add(flattenList.get(randomIndex));
        }
        return randomizedChars;
    }
    public static ArrayList<String> flatten(ArrayList<ArrayList<String>> twoDimList) {
        ArrayList<String> flatList = new ArrayList<>();
        for (List<String> subList : twoDimList) {
            flatList.addAll(subList);
        }
        return flatList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Object getRandomCharactersObject() {
        return randomCharactersObject;
    }
    public void setRandomCharactersObject(ArrayList<Object> randomCharactersObject) {
        this.randomCharactersObject = randomCharactersObject;
    }

}
