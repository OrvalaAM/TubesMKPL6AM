package Model;

public abstract class Akun {
    private String username;
    private String password;

    public Akun(){}
    public Akun(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    
    public abstract void login(java.awt.Frame parent);
}
