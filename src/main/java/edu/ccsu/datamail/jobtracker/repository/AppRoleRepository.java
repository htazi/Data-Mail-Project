package edu.ccsu.datamail.jobtracker.repository;

import edu.ccsu.datamail.jobtracker.entity.user.AppRole;
import edu.ccsu.datamail.jobtracker.entity.user.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppRoleRepository extends CrudRepository<AppUser, Integer>
{
    @Query("FROM AppRole e where e.roleName = :roleName")
    AppRole findByRoleName(@Param("roleName") String roleName);
}
