package edu.ccsu.datamail.jobtracker.dao;

import edu.ccsu.datamail.jobtracker.entity.job.InputTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Transactional
@Repository
public class InputTaskDAO
{
    @Autowired
    private EntityManager entityManager;

    public InputTask findInputTask()
    {
        try {
            String sql = "Select t from " + InputTask.class.getName() + " t " + "Where t.taskNum = 1 AND t.workflow.workflowId = 0 AND t.workflow.job.jobId = 1";
            Query query = entityManager.createQuery(sql, InputTask.class);
            return (InputTask) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
