package ptbs;

public class UserData {

    public enum USER_TYPE { Buyer, Seller }
    public String userName;
    public USER_TYPE userType;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public USER_TYPE getUserType() {
        return userType;
    }

    public void setUserType(USER_TYPE userType) {
        this.userType = userType;
    }
}