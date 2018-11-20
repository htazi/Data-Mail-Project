
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
     * @param inputTaskRepository CRUD repository for accessing InputTasks
     */
    @Autowired
    public InputTaskService(InputTaskRepository inputTaskRepository)
    {
        this.inputTaskRepository = inputTaskRepository;
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
     * Finds all InpuTasks that are part of a given job
     *
     * @param jobId the id of the job that the tasks belong to
     * @return A list containing all InputTasks associated with the job
     */
    public List<InputTask> getAllInJob(Integer jobId)
    {
        return inputTaskRepository.findAllByJobId(jobId);
    }

    /**
     * Retrieves an InputTask from the database using the provided InputTaskPK object
     *
     * @param inputTaskPK the primary key of the InputTask requested
     * @return An InputTask Object containing information on the requested task
     * @throws TaskNotFoundException if no task was found with the supplied primary key
     */
    public InputTask getInputTask(InputTaskPK inputTaskPK) throws TaskNotFoundException
    {
        Optional<InputTask> taskContainer = inputTaskRepository.findById(inputTaskPK);
        return taskContainer.orElseThrow(() -> new TaskNotFoundException("InputTask with PrimaryKey: "
                + inputTaskPK.toString() + " not Found"));
    }

    /**
     * Retrieves an InputTask from the database with the specified jobId, workflowId, and taskNum
     *
     * @param jobId      the Id of the job the InputTask belongs to
     * @param workflowId the Id of the workflow the InputTask belongs to
     * @param taskNum    the number of the task requested
     * @return An InputTask object containing information on the requested task
     * @throws TaskNotFoundException if no task was found with these identifiers
     */
    public InputTask getInputTask(int jobId, int workflowId, int taskNum) throws TaskNotFoundException
    {
        Optional<InputTask> taskContainer = inputTaskRepository.findInputTask(jobId, workflowId, taskNum);
        return taskContainer.orElseThrow(() -> new TaskNotFoundException("InputTask with jobId " + jobId
                + " workflowId " + workflowId + " taskNum: " + taskNum + " not Found"));
    }

    /**
     * Gets the current task count for the given jobId and workflowId combination
     *
     * @param jobId
     * @param workFlowId
     * @return
     */
    public int getTaskNum(int jobId, int workFlowId)
    {
        return inputTaskRepository.countTaskNum(jobId, workFlowId);
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
