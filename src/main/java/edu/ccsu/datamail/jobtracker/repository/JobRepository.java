package edu.ccsu.datamail.jobtracker.repository;

import edu.ccsu.datamail.jobtracker.entity.job.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Provides functionality to retrieve jobs from the database using various search conditions
 */
@Repository
public interface JobRepository extends CrudRepository<Job, Integer>
{
}
