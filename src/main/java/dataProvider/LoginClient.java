package dataProvider;

public class LoginClient {
    private String email;
    private String password;

    public LoginClient(String email, String password) {
        this.email = email;
        this.password = password;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public static LoginClient fromCreateClientData (CreateClient createClient){

        return new LoginClient(createClient.getEmail(), createClient.getPassword());
    }
}
