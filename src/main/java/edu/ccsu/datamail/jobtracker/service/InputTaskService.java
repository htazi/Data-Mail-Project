package edu.ccsu.datamail.jobtracker.service;

import edu.ccsu.datamail.jobtracker.entity.task.InputTask;
import edu.ccsu.datamail.jobtracker.entity.task.InputTaskPK;
import edu.ccsu.datamail.jobtracker.entity.task.TaskNotFoundException;
import edu.ccsu.datamail.jobtracker.entity.workflow.Workflow;
import edu.ccsu.datamail.jobtracker.repository.InputTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Provides services related to manipulating InputTasks and accessing InputTasks in the database
 */
@Service
public class InputTaskService
{
    /**
     * CRUD repository for accessing InputTasks stored in the database
     */
    private final InputTaskRepository inputTaskRepository;

    /**
     * Autowired Constructor for initializing CRUD repository references
     *
     * @param taskInputRepository CRUD repository for accessing InputTasks
     */
    @Autowired
    public InputTaskService(InputTaskRepository taskInputRepository)
    {
        this.inputTaskRepository = taskInputRepository;
    }

    /**
     * Finds all InputTasks that are part of a given workflow
     *
     * @param workflow the workflow that the tasks belong to
     * @return A list containing all InputTasks associated with the Workflow
     */
    public List<InputTask> getAllInWorkflow(Workflow workflow)
    {
        return inputTaskRepository.findAllByWorkflow(workflow);
    }

    /**
     * Retrieves an InputTask from the database with the specified jobId, workflowId, and taskNum
     *
     * @param jobId      the Id of the job the InputTask belongs to
     * @param workflowId the Id of the workflow the InputTask belongs to
     * @param taskNum    the number of the task requested
     * @return An InputTask object containing the information of the requested task
     * @throws TaskNotFoundException if no task was found with these identifiers
     */
    public InputTask getInputTask(int jobId, int workflowId, int taskNum) throws TaskNotFoundException
    {
        Optional<InputTask> taskContainer = inputTaskRepository.findInputTask(jobId, workflowId, taskNum);
        return taskContainer.orElseThrow(() -> new TaskNotFoundException("InputTask with jobId " + jobId
                + " workflowId " + workflowId + " taskNum: " + taskNum + " not Found"));
    }

    public void addInputTask(InputTask inputTask)
    {
        inputTaskRepository.save(inputTask);
    }

    public void updateInputTask(InputTask inputTask)
    {
        inputTaskRepository.save(inputTask);
    }

    public void deleteInputTask(InputTaskPK inputTaskPK)
    {
        inputTaskRepository.deleteById(inputTaskPK);
    }
}
