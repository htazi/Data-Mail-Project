package edu.ccsu.datamail.jobtracker.entity.user;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "app_user", uniqueConstraints = {
        @UniqueConstraint(name = "app_user_uk", columnNames = "user_name")
})
public class AppUser
{
    /**
     * Default Constructor
     */
    public AppUser()
    {
    }

    /**
     * Alterate Constructor
     * Creates a new AppUser with all fields initialized
     * @param userName the username the user will use to login
     * @param encryptedPassword the user's encrypted password
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param lastLogin the last time the user logged in
     * @param lastLogout the last time the user logged out
     * @param isActive flag that allows the user to login and access the system
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

    /**
     * Determines if this object is equal to another object
     *
     * @param o the object this object is being compared to
     * @return true if the two objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AppUser)) {
            return false;
        }

        AppUser appUser = (AppUser) o;

        if (isActive != appUser.isActive) {
            return false;
        }
        if (userId != null ? !userId.equals(appUser.userId) : appUser.userId != null) {
            return false;
        }
        if (userName != null ? !userName.equals(appUser.userName) : appUser.userName != null) {
            return false;
        }
        if (encryptedPassword != null ? !encryptedPassword.equals(appUser.encryptedPassword) : appUser.encryptedPassword != null) {
            return false;
        }
        if (firstName != null ? !firstName.equals(appUser.firstName) : appUser.firstName != null) {
            return false;
        }
        if (lastName != null ? !lastName.equals(appUser.lastName) : appUser.lastName != null) {
            return false;
        }
        if (lastLogin != null ? !lastLogin.equals(appUser.lastLogin) : appUser.lastLogin != null) {
            return false;
        }
        return lastLogout != null ? lastLogout.equals(appUser.lastLogout) : appUser.lastLogout == null;
    }

    /**
     * Returns a hashCode value for this object
     *
     * @return an integer hash code for this object
     */
    @Override
    public int hashCode()
    {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (encryptedPassword != null ? encryptedPassword.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
        result = 31 * result + (lastLogout != null ? lastLogout.hashCode() : 0);
        result = 31 * result + (isActive ? 1 : 0);
        return result;
    }
}
