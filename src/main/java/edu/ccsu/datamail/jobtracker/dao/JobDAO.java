package edu.ccsu.datamail.jobtracker.dao;

import edu.ccsu.datamail.jobtracker.entity.job.Job;
import edu.ccsu.datamail.jobtracker.entity.job.Workflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
@Transactional
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
}
