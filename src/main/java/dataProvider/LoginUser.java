package dataProvider;

public class LoginUser {

        private String email;
        private String password;


        public LoginUser(String email, String password) {
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

        public static LoginUser fromCreateUserData(CreateUser createUser){

            return new LoginUser(createUser.getEmail(), createUser.getPassword());
        }
}
