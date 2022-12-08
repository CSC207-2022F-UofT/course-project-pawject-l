package useCase.Account;

public class AccountRequestModel1 {
    private String username;
    private String password;
    public AccountRequestModel1(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
