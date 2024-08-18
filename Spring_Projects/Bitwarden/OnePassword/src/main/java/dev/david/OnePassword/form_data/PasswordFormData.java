package dev.david.OnePassword.form_data;

public class PasswordFormData {
    private Integer length;
    private Integer min_number;
    private boolean capital_A_Z;
    private boolean a_z;
    private boolean zeroToNine;
    private boolean specialCharacters;
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getMin_number() {
        return min_number;
    }

    public void setMin_number(Integer min_number) {
        this.min_number = min_number;
    }

    public boolean getCapital_A_Z() {
        return capital_A_Z;
    }

    public void setCapital_A_Z(boolean capital_A_Z) {
        this.capital_A_Z = capital_A_Z;
    }

    public boolean getA_z() {
        return a_z;
    }

    public void setA_z(boolean a_z) {
        this.a_z = a_z;
    }

    public boolean getZeroToNine() {
        return zeroToNine;
    }

    public void setZeroToNine(boolean zeroToNine) {
        this.zeroToNine = zeroToNine;
    }

    public boolean getSpecialCharacters() {
        return specialCharacters;
    }

    public void setSpecialCharacters(boolean specialCharacters) {
        this.specialCharacters = specialCharacters;
    }

}
