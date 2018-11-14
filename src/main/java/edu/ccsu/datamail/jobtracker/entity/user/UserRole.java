package edu.ccsu.datamail.jobtracker.entity.user;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(UserRole.class)
@Table(name = "user_role", uniqueConstraints = {
        @UniqueConstraint(name = "user_role_pk", columnNames = {"user_id", "role_id"})
})
public class UserRole implements Serializable
{
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser appUser;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private AppRole appRole;

    /**
     * Default Constructor
     */
    public UserRole()
    {
    }

    /**
     * Alternate Construtor:
     * Creates a new UserRole with all fields initialized
     *
     * @param appUser the user that will be assigned a new role
     * @param appRole the role assigned to the user
     */
    public UserRole(AppUser appUser, AppRole appRole)
    {
        this.appUser = appUser;
        this.appRole = appRole;
    }

    public AppUser getAppUser()
    {
        return appUser;
    }

    public void setAppUser(AppUser appUser)
    {
        this.appUser = appUser;
    }

    public AppRole getAppRole()
    {
        return appRole;
    }

    public void setAppRole(AppRole appRole)
    {
        this.appRole = appRole;
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
        if (!(o instanceof UserRole)) {
            return false;
        }

        UserRole userRole = (UserRole) o;

        if (appUser != null ? !appUser.equals(userRole.appUser) : userRole.appUser != null) {
            return false;
        }
        return appRole != null ? appRole.equals(userRole.appRole) : userRole.appRole == null;
    }

    /**
     * Returns a hashCode value for this object
     *
     * @return an integer hash code for this object
     */
    @Override
    public int hashCode()
    {
        int result = appUser != null ? appUser.hashCode() : 0;
        result = 31 * result + (appRole != null ? appRole.hashCode() : 0);
        return result;
    }
}