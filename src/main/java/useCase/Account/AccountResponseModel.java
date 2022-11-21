package useCase.Account;

public class AccountResponseModel {
    String login;

    public AccountResponseModel(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
