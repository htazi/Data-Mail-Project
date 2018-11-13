package edu.ccsu.datamail.jobtracker.dao;

import edu.ccsu.datamail.jobtracker.entity.job.Job;
import edu.ccsu.datamail.jobtracker.entity.job.Workflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import java.util.List;

import static javax.swing.UIManager.getInt;

@Repository
@Transactional
@Deprecated
public class JobDAO {

    @Autowired
    private EntityManager entityManager;

    /**
     * Queries the database to find a workflow with a given workflow number and job number
     *
     * @param jobId      the number of the job the workflow belongs to
     * @return a job object if the query was successful, null otherwise
     */
    public Job findJob(int jobId)
    {
        try {
            String sql = "Select w from " + Job.class.getName() + " w "
                    + " Where w.jobId = :jobId";

            Query query = entityManager.createQuery(sql, Job.class); // create the query

            query.setParameter("jobId", jobId); // replace the placeholders with the passed integers
            return (Job) query.getSingleResult();
        } catch (NoResultException e) { // return null if no record was found
            return null;
        }
    }

    public List<Workflow> findNextWorkflowId(int jobNum)
    {
        try {
            String sql = "Select w from " + Workflow.class.getName() + " w "
                    + " Where w.job.jobId = :jobNum";

            Query query = entityManager.createQuery(sql, Workflow.class); // create the query
            query.setParameter("jobNum", jobNum); // replace the placeholders with the passed integers

             return (List)query.getResultList();

        } catch (NoResultException e) { // return null if no record was found
            return null;
        }
    }


}