package edu.ccsu.datamail.jobtracker.service;

import edu.ccsu.datamail.jobtracker.entity.job.Job;
import edu.ccsu.datamail.jobtracker.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService
{
    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository)
    {
        this.jobRepository = jobRepository;
    }

    /**
     * Attempts to find a job given the passed jobId
     *
     * @param jobId the id of the requested job
     * @return the job, if it was found in the database
     */
    public Job getJob(int jobId)
    {
        Optional<Job> jobContainer = jobRepository.findById(jobId);
        Job job = null;
        if (jobContainer.isPresent()) { // may want to throw an exception if a job isn't found
            job = jobContainer.get();
        }
        return job;
    }

}