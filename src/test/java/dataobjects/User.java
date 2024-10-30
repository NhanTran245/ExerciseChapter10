package dataobjects;

public class User {
    private  String username;
    private  String password;
    private String pid;

    public User (String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User (String username, String password, String pid) {
        this.username = username;
        this.password = password;
        this.pid = pid;
    }

    public String getEmail() {
        return username;
    }

    public void setEmail(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}

