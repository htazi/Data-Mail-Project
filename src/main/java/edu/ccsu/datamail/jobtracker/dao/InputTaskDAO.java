package edu.ccsu.datamail.jobtracker.dao;

import edu.ccsu.datamail.jobtracker.entity.job.InputTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Provides functionality to perform transactions on the database involving the input_task table
 */
@Repository
@Transactional
@Deprecated
public class InputTaskDAO
{

    @Autowired
    private EntityManager entityManager;

    /**
     * Retrieves an input_task from the database with the specified job number, workflow number, and task number.
     *
     * @param jobNum      the number of the job the task is associated with
     * @param workflowNum the number of the workflow the task is associated with
     * @param taskNum     the number for the task in the specified job and workflow
     * @return an InputTask if a record was found, null otherwise
     */
    public InputTask findInputTask(int jobNum, int workflowNum, int taskNum)
    {
        try {
            String sql = "Select t from " + InputTask.class.getName() + " t "
                    + "Where t.workflow.job.jobId = :jobNum AND t.workflow.workflowId = :workflowNum AND t.taskNum = :taskNum";
            Query query = entityManager.createQuery(sql, InputTask.class);

            query.setParameter("jobNum", jobNum); // replace the placeholders with the passed integers
            query.setParameter("workflowNum", workflowNum);
            query.setParameter("taskNum", taskNum);

            return (InputTask) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
