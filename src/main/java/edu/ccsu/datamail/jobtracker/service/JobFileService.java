package edu.ccsu.datamail.jobtracker.service;

import edu.ccsu.datamail.jobtracker.entity.file.JobFile;
import edu.ccsu.datamail.jobtracker.entity.file.JobFileNotFoundException;
import edu.ccsu.datamail.jobtracker.entity.file.JobFilePK;
import edu.ccsu.datamail.jobtracker.repository.JobFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Provides Services related to the JobFile join table in the database
 */
@Service
public class JobFileService
{
    /**
     * CRUDRepository used to access jobfile entries in the database
     */
    private final JobFileRepository jobFileRepository;

    /**
     * Autowired constructor
     *
     * @param jobFileRepository the crudrepository used for finding jobFile entries in the database
     */
    @Autowired
    public JobFileService(JobFileRepository jobFileRepository)
    {
        this.jobFileRepository = jobFileRepository;
    }

    /**
     * Attempts to retrieve a job file from the database based on the provided primary key
     *
     * @param jobId  the id of the job the file belongs to
     * @param fileId the id of the file that is associated with the job
     * @throws JobFileNotFoundException if no entry is found in the database
     */
    public JobFile getJobFile(int jobId, int fileId) throws JobFileNotFoundException
    {
        return getJobFile(new JobFilePK(jobId, fileId));
    }

    /**
     * Attempts to retrieve a job file from the database based on the provided primary key
     *
     * @param jobFilePK the primary key of the requested entry
     * @throws JobFileNotFoundException if no entry is found in the database
     */
    public JobFile getJobFile(JobFilePK jobFilePK) throws JobFileNotFoundException
    {
        Optional<JobFile> jobFileContainer = jobFileRepository.findById(jobFilePK);
        return jobFileContainer.orElseThrow(() -> new JobFileNotFoundException("JobFile entry with jobId: "
                + jobFilePK.getJobId() + " and fileId: " + jobFilePK.getFileId() + " not found"));
    }

    /**
     * Saves a new jobFile to the database
     *
     * @param jobFile the new entry in the database
     * @return the fully formed jobFile jpa pulled from the database
     */
    public JobFile saveJobFile(JobFile jobFile)
    {
        return jobFileRepository.save(jobFile);
    }
}
