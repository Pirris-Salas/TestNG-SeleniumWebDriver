public final class UserDataClass {

    private final String genericName;
    private final String largestUserName;
    private final String valid29LengthUserName;
    private final String valid30LengthUserName;
    private final String emptyUserName;
    private final String genericPassword;

    UserDataClass(String genericName, String largestUserName, String valid29LengthUserName, String valid30LengthUserName,
                  String emptyUserName, String genericPassword) {
        this.genericName = genericName;
        this.largestUserName = largestUserName;
        this.valid29LengthUserName = valid29LengthUserName;
        this.valid30LengthUserName = valid30LengthUserName;
        this.emptyUserName = emptyUserName;
        this.genericPassword = genericPassword;
    }


    public String getValid30LengthUserName() {
        return valid30LengthUserName;
    }

    public String getEmptyUserName() {
        return emptyUserName;
    }

    public String getGenericName() {
        return genericName;
    }

    public String getValid29LengthUserName() {
        return valid29LengthUserName;
    }


    public String getLargestUserName() {
        return largestUserName;
    }


    public String getGenericPassword() {
        return genericPassword;
    }
}
