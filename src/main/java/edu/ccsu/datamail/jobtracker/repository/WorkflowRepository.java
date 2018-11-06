package edu.ccsu.datamail.jobtracker.repository;

import edu.ccsu.datamail.jobtracker.entity.job.Workflow;
import org.springframework.data.repository.CrudRepository;

public interface WorkflowRepository extends CrudRepository<Workflow, Integer>
{

}
