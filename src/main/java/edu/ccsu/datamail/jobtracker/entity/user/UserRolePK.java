package edu.ccsu.datamail.jobtracker.entity.user;

import java.io.Serializable;

/**
 * Id class for UserRole JPA
 * <p>
 * Contains atttributes related to the primary key of the user_role table
 */
class UserRolePK implements Serializable
{
    /**
     * The user of the job tracker
     */
    private AppUser appUser;

    /**
     * The role the user has
     */
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
        if (obj instanceof UserRolePK) {
            UserRolePK other = (UserRolePK) obj;
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
