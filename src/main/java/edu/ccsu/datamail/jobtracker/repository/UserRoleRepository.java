package edu.ccsu.datamail.jobtracker.repository;

import edu.ccsu.datamail.jobtracker.entity.user.UserRole;
import edu.ccsu.datamail.jobtracker.entity.user.UserRolePK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides functionality for retrieving information on user's roles from the database
 */
@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, UserRolePK>
{
    @Query("SELECT ur.appRole.roleName FROM UserRole ur WHERE ur.appUser.userId = :userId")
    List<String> getRoleNames(@Param("userId") Integer userId);
}
