package capstone.bcs.lifo.model;


import javax.persistence.*;

@Embeddable
public class Account {

    private String username;
    private Boolean active;

    @Transient
    private String password;

    private String encryptedPassword; // decrypt this to check for username pass
    private String userRole;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }


    public Boolean getActive() {
        return active;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

}