package edu.ccsu.datamail.jobtracker.entity.user;

import javax.persistence.*;
import java.time.LocalDate;

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
    private LocalDate lastLogin;

    @Column(name = "last_logout", length = 32)
    private LocalDate lastLogout;

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

    public LocalDate getLastLogin()
    {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin)
    {
        this.lastLogin = lastLogin;
    }

    public LocalDate getLastLogout()
    {
        return lastLogout;
    }

    public void setLastLogout(LocalDate lastLogout)
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
     * Returns a hashCode value for this object
     *
     * @return an integer hash code for this object
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof AppUser) {
            AppUser other = (AppUser) obj;
            return this.userId.equals(other.userId) && this.userName.equals(other.userName) &&
                    this.encryptedPassword.equals(other.encryptedPassword) && this.firstName.equals(other.firstName) &&
                    this.lastName.equals(other.lastName) && this.lastLogin.equals(other.lastLogin) &&
                    this.lastLogout.equals(other.lastLogout) && this.isActive == other.isActive;
        }
        return false;
    }

    /**
     * Returns a hashCode value for this object
     *
     * @return an integer hash code for this object
     */
    @Override
    public int hashCode()
    {
        int hash = 17;
        if (userId != null) {
            hash += userId.hashCode();
        }
        if (userName != null) {
            hash += userName.hashCode();
        }
        if (encryptedPassword != null) {
            hash += encryptedPassword.hashCode();
        }
        if (firstName != null) {
            hash += firstName.hashCode();
        }
        if (lastName != null) {
            hash += lastName.hashCode();
        }
        if (lastLogin != null) {
            hash += lastLogin.hashCode();
        }
        if (lastLogout != null) {
            hash += lastLogout.hashCode();
        }
        return hash + Boolean.hashCode(isActive);
    }
}
