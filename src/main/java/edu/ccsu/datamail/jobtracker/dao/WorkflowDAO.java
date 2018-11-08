package edu.ccsu.datamail.jobtracker.dao;

import edu.ccsu.datamail.jobtracker.entity.job.Workflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Provides functionality to perform transactions on the database involving the workflow table
 */
@Repository
@Transactional
public class WorkflowDAO
{
    @Autowired
    private EntityManager entityManager;

    /**
     * Queries the database to find a workflow with a given workflow number and job number
     *
     * @param jobNum      the number of the job the workflow belongs to
     * @param workflowNum the workflow number for the job
     * @return a workflow object if the query was successful, null otherwise
     */
    public Workflow findWorkflow(int jobNum, int workflowNum)
    {
        try {
            String sql = "Select w from " + Workflow.class.getName() + " w "
                    + " Where w.job.jobId = :jobNum AND w.workflowId = :workflowNum";

            Query query = entityManager.createQuery(sql, Workflow.class); // create the query

            query.setParameter("jobNum", jobNum); // replace the placeholders with the passed integers
            query.setParameter("workflowNum", workflowNum);
            return (Workflow) query.getSingleResult();
        } catch (NoResultException e) { // return null if no record was found
            return null;
        }
    }



}
