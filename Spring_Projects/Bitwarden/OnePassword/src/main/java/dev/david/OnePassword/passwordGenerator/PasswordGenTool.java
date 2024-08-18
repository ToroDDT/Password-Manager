package dev.david.OnePassword.passwordGenerator;

import ch.qos.logback.core.joran.sanity.Pair;
import dev.david.OnePassword.form_data.PasswordFormData;

import java.util.*;
import java.util.stream.Collectors;
import java.util.List;


public class PasswordGenTool {
    private String password;
    private ArrayList<Object> randomCharactersObject;
    public Object passwordArray () {
        return new ArrayList<Object>();
    }
    private GeneratedNumbersArrPair generateNumbers (int minAmount, int maxAmount ) {
        Random rand = new Random();

        int randomNumberBetweenMaxAndMin = minAmount + (int)(Math.random() * (maxAmount - minAmount));
        //An array that contains random numbers
        ArrayList<Integer> randomNumberArr = new ArrayList<>();
        ArrayList<Integer> randomNumberArrMax = new ArrayList<>();
        //Given a certain amount generate random number and add to array
        for (int i = 0; i < randomNumberBetweenMaxAndMin; i++){
            int randomNumber = rand.nextInt(10);
            randomNumberArr.add(randomNumber);
        }
        for (int i = 0; i < maxAmount; i++){
            int randomNumber = rand.nextInt(10);
            randomNumberArrMax.add(randomNumber);
        }

        ArrayList<String> randomNumbersArrContainingMinLimitToString = new ArrayList<>(randomNumberArr.size());
        randomNumberArr.forEach(number -> randomNumbersArrContainingMinLimitToString.add(String.valueOf(number)));

        ArrayList<String> randomNumbersArrMaxToString= new ArrayList<>(randomNumberArrMax.size());
        randomNumberArrMax.forEach(number -> randomNumbersArrMaxToString.add(String.valueOf(number)));

        GeneratedNumbersArrPair generatedNumbersArrPair = new GeneratedNumbersArrPair();
        generatedNumbersArrPair.setRandomNumbersArr(randomNumbersArrContainingMinLimitToString);
        generatedNumbersArrPair.setRandomNumbersArrMax(randomNumbersArrMaxToString);
        return generatedNumbersArrPair;
    }
    private ArrayList<String> generateLowerCaseLetters (int maxAmount) {
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
    private ArrayList<String> generateUpperCaseLetters (int maxAmount) {
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

    private ArrayList<String> generateSpecialLetters () {
        return new ArrayList<>(Arrays.asList("@","%","!","$"));
    }
    public String generateRandomPassword (int max, int min, PasswordFormData passwordFormData) {
        String[] characterArr = new String[passwordFormData.getLength()];
        ArrayList<ArrayList<String>> multiDimList = new ArrayList<>();

        var lengthOfCharacterArr = characterArr.length;
        var randomPasswordArrResults = generateNumbers(min, max);
        var randomNumbersArrMax = randomPasswordArrResults.getRandomNumbersArrMax();
        var randomNumbersArrMin = randomPasswordArrResults.getRandomNumbersArr();

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
            multiDimList.add(generateNumbers(passwordFormData.getMin_number(), passwordFormData.getLength()));
        }
        ArrayList<Object> singleDimList = new ArrayList<>();

        for (ArrayList<Object> subList : randomGeneratedCharacters) {
            singleDimList.addAll(subList);
        }
        for()

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
