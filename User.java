package onlineShopping;

public class User {
    // declaring variables
    private String userName;
    private String password;

    // creating user constructor to get username and password
    public User(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    // getters and setters
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
