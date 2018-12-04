package edu.ccsu.datamail.jobtracker.repository;

import edu.ccsu.datamail.jobtracker.entity.file.JobFile;
import edu.ccsu.datamail.jobtracker.entity.file.JobFilePK;
import org.springframework.data.repository.CrudRepository;

/**
 * Provides functionality to retrieve entries from the jobfile joint table using various search conditions
 */
public interface JobFileRepository extends CrudRepository<JobFile, JobFilePK>
{
}
