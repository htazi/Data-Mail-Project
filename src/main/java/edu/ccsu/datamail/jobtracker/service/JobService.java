package edu.ccsu.datamail.jobtracker.service;

import edu.ccsu.datamail.jobtracker.entity.job.Job;
import edu.ccsu.datamail.jobtracker.entity.job.JobNotFoundException;
import edu.ccsu.datamail.jobtracker.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Provides services related to manipulating jobs and accessing jobs in the database
 */
@Service
public class JobService
{
    /**
     * A Crud repository for accessing jobs stored in the database
     */
    private final JobRepository jobRepository;

    /**
     * Autowired Constructor
     *
     * @param jobRepository the job CRUD repository for accessing the database
     */
    @Autowired
    public JobService(JobRepository jobRepository)
    {
        this.jobRepository = jobRepository;
    }

    /**
     * Attempts to find a job given the passed jobId
     *
     * @param jobId the id of the requested job
     * @return A job object containing information on the requested job
     * @throws JobNotFoundException if no job with this id is found in the database
     */
    public Job getJob(int jobId) throws JobNotFoundException
    {
        Optional<Job> jobContainer = jobRepository.findById(jobId);
        return jobContainer.orElseThrow(() -> new JobNotFoundException("Job with Id: " + jobId + " not found"));
    }

    public int findWFNumber(int jobId)
    {
        /*
        List<Workflow> wf;
        wf = jobDAO.findNextWorkflowId(jobId);
        int max = 0;

        for (Workflow w : wf) {
            int num1 = w.getWorkflowId();
            if (num1 > max) {
                max = num1;
            }
        }
        max = max + 1;

        return max;
        */
        return 0;
    }
}