package edu.ccsu.datamail.jobtracker.entity.job;

import edu.ccsu.datamail.jobtracker.entity.user.AppUser;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@IdClass(InputTaskPK.class)
@Table(name = "input_task", uniqueConstraints = {
        @UniqueConstraint(name = "input_task_pk", columnNames = {"job_id", "wf_id", "task_num"})
})
public class InputTask
{

    /**
     * The identifier for the task in the workflow
     */
    @Id
    @Column(name = "task_num", nullable = false)
    private Integer taskNum;

    /**
     * The workflow (and by extension job) this task is associated with
     */
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "wf_id", referencedColumnName = "wf_id", nullable = false),
            @JoinColumn(name = "job_id", referencedColumnName = "job_id", nullable = false)
    })
    private Workflow workflow;

    /**
     * The id of the task recorded
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private AvailableTask task_id;

    /**
     * The id of the user who recorded this task
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser userId;

    @Column(name = "task_desc", length = 60)
    private String description;

    /**
     * The number of records in to the task
     */
    @Column(name = "records_in")
    private Integer recordsIn;

    /**
     * The number of records out after performing the task
     */
    @Column(name = "records_out")
    private Integer recordsOut;

    /**
     * The number of records dropped as a result of the
     */
    @Column(name = "records_dropped")
    private Integer recordsDropped;

    /**
     * The time in minutes it took the user to setup the task
     */
    @Column(name = "time_taken")
    private Integer timeTaken;

    /**
     * The time this task was recorded into the system by the user
     */
    @Column(name = "time_recorded")
    private LocalDate timeRecorded;

    public Integer getTaskNum()
    {
        return taskNum;
    }

    public void setTaskNum(Integer taskNum)
    {
        this.taskNum = taskNum;
    }

    public Workflow getWorkflow()
    {
        return workflow;
    }

    public void setWorkflow(Workflow workflow)
    {
        this.workflow = workflow;
    }

    public AvailableTask getTask_id()
    {
        return task_id;
    }

    public void setTask_id(AvailableTask task_id)
    {
        this.task_id = task_id;
    }

    public AppUser getUserId()
    {
        return userId;
    }

    public void setUserId(AppUser userId)
    {
        this.userId = userId;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Integer getRecordsIn()
    {
        return recordsIn;
    }

    public void setRecordsIn(Integer recordsIn)
    {
        this.recordsIn = recordsIn;
    }

    public Integer getRecordsOut()
    {
        return recordsOut;
    }

    public void setRecordsOut(Integer recordsOut)
    {
        this.recordsOut = recordsOut;
    }

    public Integer getRecordsDropped()
    {
        return recordsDropped;
    }

    public void setRecordsDropped(Integer recordsDropped)
    {
        this.recordsDropped = recordsDropped;
    }

    public Integer getTimeTaken()
    {
        return timeTaken;
    }

    public void setTimeTaken(Integer timeTaken)
    {
        this.timeTaken = timeTaken;
    }

    public LocalDate getTimeRecorded()
    {
        return timeRecorded;
    }

    public void setTimeRecorded(LocalDate timeRecorded)
    {
        this.timeRecorded = timeRecorded;
    }

    /**
     * Returns a hashCode value for this object
     *
     * @return an integer hash code for this object
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InputTask)) {
            return false;
        }

        InputTask inputTask = (InputTask) o;

        if (taskNum != null ? !taskNum.equals(inputTask.taskNum) : inputTask.taskNum != null) {
            return false;
        }
        if (workflow != null ? !workflow.equals(inputTask.workflow) : inputTask.workflow != null) {
            return false;
        }
        if (task_id != null ? !task_id.equals(inputTask.task_id) : inputTask.task_id != null) {
            return false;
        }
        if (userId != null ? !userId.equals(inputTask.userId) : inputTask.userId != null) {
            return false;
        }
        if (description != null ? !description.equals(inputTask.description) : inputTask.description != null) {
            return false;
        }
        if (recordsIn != null ? !recordsIn.equals(inputTask.recordsIn) : inputTask.recordsIn != null) {
            return false;
        }
        if (recordsOut != null ? !recordsOut.equals(inputTask.recordsOut) : inputTask.recordsOut != null) {
            return false;
        }
        if (recordsDropped != null ? !recordsDropped.equals(inputTask.recordsDropped) : inputTask.recordsDropped != null) {
            return false;
        }
        if (timeTaken != null ? !timeTaken.equals(inputTask.timeTaken) : inputTask.timeTaken != null) {
            return false;
        }
        return timeRecorded != null ? timeRecorded.equals(inputTask.timeRecorded) : inputTask.timeRecorded == null;
    }

    /**
     * Returns a hashCode value for this object
     *
     * @return an integer hash code for this object
     */
    @Override
    public int hashCode()
    {
        int result = taskNum != null ? taskNum.hashCode() : 0;
        result = 31 * result + (workflow != null ? workflow.hashCode() : 0);
        result = 31 * result + (task_id != null ? task_id.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (recordsIn != null ? recordsIn.hashCode() : 0);
        result = 31 * result + (recordsOut != null ? recordsOut.hashCode() : 0);
        result = 31 * result + (recordsDropped != null ? recordsDropped.hashCode() : 0);
        result = 31 * result + (timeTaken != null ? timeTaken.hashCode() : 0);
        result = 31 * result + (timeRecorded != null ? timeRecorded.hashCode() : 0);
        return result;
    }

    /**
     * Returns a String representation of this object
     *
     * @return a string containing information on this object
     */
    @Override
    public String toString()
    {
        return "task number: " + taskNum.toString() + " " + workflow.toString();
    }

}
