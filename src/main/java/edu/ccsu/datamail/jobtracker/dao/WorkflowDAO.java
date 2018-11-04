package edu.ccsu.datamail.jobtracker.dao;

import edu.ccsu.datamail.jobtracker.entity.job.User;
import edu.ccsu.datamail.jobtracker.entity.job.Workflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
@Transactional
public class WorkflowDAO
{
    @Autowired
    private EntityManager entityManager;

    public Workflow findWorkflow(int workflowID,int jobID)
    {
        try { // currently finds a specific workflow instead of any workflow
            String sql = "Select w from " + Workflow.class.getName() + " w "+ "Where w.workflowId =" + workflowID + "AND w.job.jobId = " + jobID;
            Query query = entityManager.createQuery(sql, Workflow.class);
            return (Workflow) query.getSingleResult();
           } catch (NoResultException e) {
            return null;
        }
    }

    public User findUserID(int userID)
    {
        try { // currently finds a specific workflow instead of any workflow
            String sql = "Select * from public.app_user Where user_id =" + userID;
            Query query = entityManager.createQuery(sql, User.class);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }



}
