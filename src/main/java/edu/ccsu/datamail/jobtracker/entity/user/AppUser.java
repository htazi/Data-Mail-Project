package edu.ccsu.datamail.jobtracker.entity.user;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "app_user", uniqueConstraints = {
        @UniqueConstraint(name = "app_user_uk", columnNames = "user_name")
})
public class AppUser
{
    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "user_name", length = 36, nullable = false)
    private String userName;

    @Column(name = "encrypted_password", length = 128, nullable = false)
    private String encryptedPassword;

    @Column(name = "f_name", length = 30)
    private String firstName;

    @Column(name = "l_name", length = 30)
    private String lastName;

    @Column(name = "last_login", length = 32)
    private Timestamp lastLogin;

    @Column(name = "last_logout", length = 32)
    private Timestamp lastLogout;

    @Column(name = "is_active", length = 1, nullable = false)
    private boolean isActive;

    @Column(name = "email", length = 60, nullable = false)
   // @Email(message = "Please provide a valid e-mail")
   // @NotEmpty(message = "Please provide an e-mail")
    private String email;

    @Column(name = "confirmation_token", length = 60)
    private String confirmationToken;

    /**
     * Default Constructor
     */
    public AppUser()
    {
    }

    /**
     * Alterate Constructor
     * Creates a new AppUser with all fields initialized
     *
     * @param userName          the username the user will use to login
     * @param encryptedPassword the user's encrypted password
     * @param firstName         the user's first name
     * @param lastName          the user's last name
     * @param lastLogin         the last time the user logged in
     * @param lastLogout        the last time the user logged out
     * @param isActive          flag that allows the user to login and access the system
     */
    public AppUser(String userName, String encryptedPassword, String firstName, String lastName, Timestamp lastLogin,
                   Timestamp lastLogout, boolean isActive)
    {
        this.userName = userName;
        this.encryptedPassword = encryptedPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastLogin = lastLogin;
        this.lastLogout = lastLogout;
        this.isActive = isActive;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getEncryptedPassword()
    {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword)
    {
        this.encryptedPassword = encryptedPassword;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Timestamp getLastLogin()
    {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin)
    {
        this.lastLogin = lastLogin;
    }

    public Timestamp getLastLogout()
    {
        return lastLogout;
    }

    public void setLastLogout(Timestamp lastLogout)
    {
        this.lastLogout = lastLogout;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public void setActive(boolean active)
    {
        isActive = active;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser)) return false;
        AppUser appUser = (AppUser) o;
        return isActive == appUser.isActive &&
                Objects.equals(userId, appUser.userId) &&
                Objects.equals(userName, appUser.userName) &&
                Objects.equals(encryptedPassword, appUser.encryptedPassword) &&
                Objects.equals(firstName, appUser.firstName) &&
                Objects.equals(lastName, appUser.lastName) &&
                Objects.equals(lastLogin, appUser.lastLogin) &&
                Objects.equals(lastLogout, appUser.lastLogout) &&
                Objects.equals(email, appUser.email) &&
                Objects.equals(confirmationToken, appUser.confirmationToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, encryptedPassword, firstName, lastName, lastLogin, lastLogout, isActive, email, confirmationToken);
    }

    public String getConfirmationToken() { return confirmationToken; }

    public void setConfirmationToken(String confirmationToken) { this.confirmationToken = confirmationToken; }

}
