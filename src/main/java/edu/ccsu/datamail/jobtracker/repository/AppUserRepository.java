package edu.ccsu.datamail.jobtracker.repository;

import edu.ccsu.datamail.jobtracker.entity.user.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer>
{
    @Query("FROM AppUser e where e.userName = :userName")
    Optional<AppUser> findByUserName(@Param("userName") String userName);

   @Query("FROM AppUser e where e.email = :email")
    Optional<AppUser> findByEmail(@Param("email")String email);

    @Query("FROM AppUser e where e.confirmationToken = :confirmationToken")
    Optional <AppUser> findByConfirmationToken(@Param("confirmationToken")String confirmationToken);
}
