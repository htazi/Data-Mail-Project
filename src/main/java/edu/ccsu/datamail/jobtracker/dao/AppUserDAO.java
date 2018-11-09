package edu.ccsu.datamail.jobtracker.dao;

import edu.ccsu.datamail.jobtracker.entity.user.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Provides functionality to perform transactions on the database involving user accounts
 */
@Repository
@Transactional
@Deprecated
public class AppUserDAO
{

    @Autowired
    private EntityManager entityManager;

    /**
     * Retrieve's a user's information from the database using the specified username
     *
     * @param userName the username of the user
     * @return an AppUser if a record was found, null otherwise
     */
    public AppUser findUserAccount(String userName)
    {
        try {
            String sql = "Select e from " + AppUser.class.getName() + " e "
                    + " Where e.userName = :userName ";

            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("userName", userName);

            return (AppUser) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public AppUser findUserByID(int userId)
    {
        try {
            String sql = "Select e from " + AppUser.class.getName() + " e " //
                    + " Where e.userId = :userId ";

            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("userId", userId);

            return (AppUser) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
