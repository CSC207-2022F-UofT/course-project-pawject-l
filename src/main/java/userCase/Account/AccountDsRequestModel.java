package userCase.Account;

public class AccountDsRequestModel {

    private String userID;
    private String username;
    private String password;


    public AccountDsRequestModel(String username, String password) {
        this.userID = idGenerator();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String rgetPassword() { return password; }

    public String getUserID() {
        return userID;
    }

    void setUsername(String username) {
        this.username = username;
    }

    void setPassword(String password) {
        this.password = password;
    }

    void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Generates a unique userID composed of 8 alphanumeric characters.
     *
     * @return a randomly generated string userID.
     */
    public static String idGenerator() {
        String alphaNumString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz" + "123456789";
        StringBuilder sb = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {
            int index = (int) (alphaNumString.length() * Math.random());
            sb.append(alphaNumString.charAt(index));
        }
        return sb.toString();
    }
}
