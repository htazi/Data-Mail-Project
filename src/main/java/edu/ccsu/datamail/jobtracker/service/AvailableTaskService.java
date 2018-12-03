package edu.ccsu.datamail.jobtracker.service;

import edu.ccsu.datamail.jobtracker.entity.task.AvailableTask;
import edu.ccsu.datamail.jobtracker.entity.task.TaskNotFoundException;
import edu.ccsu.datamail.jobtracker.repository.AvailableTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Provides services related to manipulating AvailableTasks and accessing AvailableTasks in the database
 */
@Service
public class AvailableTaskService
{
    // TODO: Add HashMap to implement FlyWeight for Available Tasks

    /**
     * CRUD repository for accessing AvailableTasks stored in the database
     */
    private final AvailableTaskRepository availableTaskRepository;

    /**
     * Autowired Constructor
     *
     * @param availableTaskRepository CRUD repository for accessing AvailableTasks
     */
    @Autowired
    public AvailableTaskService(AvailableTaskRepository availableTaskRepository)
    {
        this.availableTaskRepository = availableTaskRepository;
    }

    /**
     * Retrieves an AvailableTask from the database with the specified taskId
     *
     * @param taskId the id of the AvailableTask
     * @return An AvailableTask object containing information on the AvailableTask
     * @throws TaskNotFoundException if no task is found in the database with the provided id
     */
    public AvailableTask getAvailableTask(int taskId) throws TaskNotFoundException
    {
        Optional<AvailableTask> taskContainer = availableTaskRepository.findById(taskId);
        return taskContainer.orElseThrow(() -> new TaskNotFoundException("AvailableTask with id " + taskId + " not found"));
    }

    public void addAvailableTask(AvailableTask availableTask)
    {
        availableTaskRepository.save(availableTask);
    }

    public List<AvailableTask> getAvailableTaskList(){
        return availableTaskRepository.findAll();
    }
}
