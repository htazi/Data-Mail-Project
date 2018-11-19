package edu.ccsu.datamail.jobtracker.entity.user;

import java.io.Serializable;

/**
 * Id class for UserRole JPA
 * <p>
 * Contains atttributes related to the primary key of the user_role table
 */
public class UserRolePK implements Serializable
{
    /**
     * The the id of the user of the job tracker
     */
    private Integer userId;

    /**
     * The id of the role the user has
     */
    private Integer roleId;

    public UserRolePK()
    {
    }

    /**
     * Creates a new UserRolePK with the associated AppUser and UserRole
     *
     * @param userId the id of the AppUser who has the specified role
     * @param roleId the id of the UserRole of the specified AppUser
     */
    public UserRolePK(Integer userId, Integer roleId)
    {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Integer roleId)
    {
        this.roleId = roleId;
    }

    /**
     * Returns a hashCode value for this object
     *
     * @return an integer hash code for this object
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserRolePK)) {
            return false;
        }

        UserRolePK that = (UserRolePK) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) {
            return false;
        }
        return roleId != null ? roleId.equals(that.roleId) : that.roleId == null;
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
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        return result;
    }
}
