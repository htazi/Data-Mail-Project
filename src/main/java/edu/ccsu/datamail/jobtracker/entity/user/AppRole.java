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
        if (obj instanceof AppRole) {
            AppRole other = (AppRole) obj;
            return this.roleId.equals(other.roleId) && this.roleName.equals(other.roleName);
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
        int hash = 53;
        if (roleId != null) {
            hash += roleId.hashCode();
        }
        if (roleName != null) {
            hash += roleName.hashCode();
        }
        return hash;
    }
}
