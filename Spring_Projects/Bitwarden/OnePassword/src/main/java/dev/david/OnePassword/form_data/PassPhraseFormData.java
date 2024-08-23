package dev.david.OnePassword.form_data;

public class PassPhraseFormData {
    private boolean capitalize;
    private boolean includeNumber;
    private Integer numberOfWords;
    private String wordSeparator;
    public boolean isCapitalize() {
        return capitalize;
    }

    public void setCapitalize(boolean capitalize) {
        this.capitalize = capitalize;
    }

    public boolean isIncludeNumber() {
        return includeNumber;
    }

    public void setIncludeNumber(boolean includeNumber) {
        this.includeNumber = includeNumber;
    }

    public Integer getNumberOfWords() {
        return numberOfWords;
    }

    public void setNumberOfWords(Integer numberOfWords) {
        this.numberOfWords = numberOfWords;
    }

    public String getWordSeparator() {
        return wordSeparator;
    }

    public void setWordSeparator(String wordSeparator) {
        this.wordSeparator = wordSeparator;
    }

}
