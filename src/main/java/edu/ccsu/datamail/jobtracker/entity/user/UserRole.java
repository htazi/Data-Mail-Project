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
        if (obj instanceof UserRole) {
            UserRole other = (UserRole) obj;
            return this.appUser.equals(other.appUser) && this.appRole.equals(other.appRole);
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
        int hash = 37;
        if (appUser != null) {
            hash += appUser.hashCode();
        }
        if (appRole != null) {
            hash += appRole.hashCode();
        }
        return hash;
    }

}