package edu.ccsu.datamail.jobtracker.service;

import edu.ccsu.datamail.jobtracker.entity.job.InputTask;
import edu.ccsu.datamail.jobtracker.repository.InputTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InputTaskService
{
    private final InputTaskRepository taskInputRepository;

    @Autowired
    public InputTaskService(InputTaskRepository taskInputRepository)
    {
        this.taskInputRepository = taskInputRepository;
    }

    public List<InputTask> getAllTaskInputs()
    {
        List<InputTask> taskinputs = new ArrayList<>();
        taskInputRepository.findAll().forEach(taskinputs::add);
        return taskinputs;
    }

/*
    public InputTask getTaskInput(int id)
    {
        return null;
    }

    public void addTaskInput(InputTask taskinput)
    {
        taskInputRepository.save(taskinput);
    }

    public void updateTaskInput(int id, InputTask taskinput)
    {
        taskInputRepository.save(taskinput);
    }

    public void deleteTaskInput(int id)
    {
        taskInputRepository.deleteById(id);
    }
*/
}
