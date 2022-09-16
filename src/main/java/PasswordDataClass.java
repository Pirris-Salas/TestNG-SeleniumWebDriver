public final class PasswordDataClass {

    private final String genericName;
    private final String genericUserName;
    private final String shortPassword;
    private final String validPassword;
    private final String upercaseNumbersPassword;
    private final String lowercaseNumbersPassword;
    private final String lettersOnlyPassword;
    private final String numbersOnlyPassword;


    PasswordDataClass(String genericName, String genericUserName, String shortPassword, String validPassword,
                      String upercaseNumbersPassword, String lowercaseNumbersPassword, String lettersOnlyPassword,
                      String numbersOnlyPassword){
        this.genericName = genericName;
        this.genericUserName = genericUserName;
        this.shortPassword = shortPassword;
        this.validPassword = validPassword;
        this.upercaseNumbersPassword = upercaseNumbersPassword;
        this.lowercaseNumbersPassword = lowercaseNumbersPassword;
        this.lettersOnlyPassword = lettersOnlyPassword;
        this.numbersOnlyPassword = numbersOnlyPassword;
    }
    public String getGenericName() {
        return genericName;
    }

    public String getGenericUserName() {
        return genericUserName;
    }

    public String getShortPassword() {
        return shortPassword;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public String getUpercaseNumbersPassword() {
        return upercaseNumbersPassword;
    }

    public String getLowercaseNumbersPassword() {
        return lowercaseNumbersPassword;
    }

    public String getLettersOnlyPassword() {
        return lettersOnlyPassword;
    }

    public String getNumbersOnlyPassword() {
        return numbersOnlyPassword;
    }

}
