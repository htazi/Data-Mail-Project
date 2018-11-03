package edu.ccsu.datamail.jobtracker.service;

import edu.ccsu.datamail.jobtracker.entity.job.InputTask;
import edu.ccsu.datamail.jobtracker.repository.InputTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InputTaskService {

    @Autowired
    private InputTaskRepository taskInputRepository;

    private   List<InputTask> taskinput =  new ArrayList<>(Arrays.asList(
//          new TaskInput(1,1,1 ),
//          new TaskInput(2,2,2 ),
//          new TaskInput(3,3,3 )
    ));

    public List<InputTask> getAllTaskInputs(){

        List<InputTask> taskinputs = new ArrayList<>();
        taskInputRepository.findAll().forEach(taskinputs::add);
        return taskinputs;
    }


    public InputTask getTaskInput(int id){


        InputTask t = taskInputRepository.findById(String.valueOf(id)).get();
        return t;
    }



    public void addTaskInput(InputTask taskinput){

        taskInputRepository.save(taskinput);
    }

    public void updateTaskInput(int id, InputTask taskinput){


        taskInputRepository.save(taskinput);
    }

    public void deleteTaskInput(int id){


        taskInputRepository.deleteById(String.valueOf(id));
    }

}
