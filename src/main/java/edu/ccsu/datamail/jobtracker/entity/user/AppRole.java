package edu.ccsu.datamail.jobtracker.entity.user;

import javax.persistence.*;

@Entity
@Table(name = "app_role", uniqueConstraints = {
        @UniqueConstraint(name = "app_role_uk", columnNames = "role_name")
})
public class AppRole
{
    @Id
    @GeneratedValue
    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    @Column(name = "role_name", length = 30, nullable = false)
    private String roleName;

    /**
     * Default Constructor
     */
    public AppRole()
    {
    }

    /**
     * Alternate Constructor:
     * Creates a new role with the specified name
     *
     * @param roleName the name of the new role
     */
    public AppRole(String roleName)
    {
        this.roleName = roleName;
    }

    public Integer getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Integer roleId)
    {
        this.roleId = roleId;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
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
        if (!(o instanceof AppRole)) {
            return false;
        }

        AppRole appRole = (AppRole) o;

        if (roleId != null ? !roleId.equals(appRole.roleId) : appRole.roleId != null) {
            return false;
        }
        return roleName != null ? roleName.equals(appRole.roleName) : appRole.roleName == null;
    }

    /**
     * Returns a hashCode value for this object
     *
     * @return an integer hash code for this object
     */
    @Override
    public int hashCode()
    {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }
}
