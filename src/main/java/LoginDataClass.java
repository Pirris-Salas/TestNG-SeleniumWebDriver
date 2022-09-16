public final class LoginDataClass {
    private final String validUser;
    private final String validPassword;
    private final String wrongUser;
    private final String wrongPassword;

    public LoginDataClass(String validUser, String validPassword, String wrongUser, String wrongPassword) {
        this.validUser = validUser;
        this.validPassword = validPassword;
        this.wrongUser = wrongUser;
        this.wrongPassword = wrongPassword;
    }

    public String getValidUser() {
        return validUser;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public String getWrongUser() {
        return wrongUser;
    }

    public String getWrongPassword() {
        return wrongPassword;
    }
}
