//Jens' kode

package Users;

public abstract class User {
    private String userName;
    private String password;
    private String email;

    public User(String userName, String password, String email){
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
