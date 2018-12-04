package edu.ccsu.datamail.jobtracker.entity.task;

import edu.ccsu.datamail.jobtracker.entity.user.AppUser;
import edu.ccsu.datamail.jobtracker.entity.workflow.Workflow;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * JPA class for the input_task table in the database
 * <p>
 * Contains information associated with a specific task entered as part of a job
 */
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
     * The integer id of the workflow this task is a part of
     */
    @Id
    @Column(name = "wf_id", nullable = false)
    private Integer workflowId;

    /**
     * The integer id of the job this task is a part of
     */
    @Id
    @Column(name = "job_id", nullable = false)
    private Integer jobId;

    /**
     * The workflow JPA (and by extension job) this task is associated with
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "wf_id", referencedColumnName = "wf_id", insertable = false, updatable = false),
            @JoinColumn(name = "job_id", referencedColumnName = "job_id", insertable = false, updatable = false)
    })
    private Workflow workflow;

    /**
     * The id of the task recorded
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taskId", nullable = false)
    private AvailableTask taskId;

    /**
     * The id of the user who recorded this task
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser userId;

    /**
     * The description of the task
     */
    @Column(name = "task_desc", length = 60)
    private String description;

    /**
     * Flag that marks the task as part of a pcr if true
     */
    @Column(name = "is_pcr", nullable = false)
    private Boolean isPCR;

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
    private Timestamp timeRecorded;

    /**
     * Default Constructor
     */
    public InputTask()
    {
    }

    /**
     * Alternate Constructor:
     * Creates a new InputTask object with all fields initialized
     *
     * @param taskNum        the number of the task in the job and workflow
     * @param workflowId     the integer id of the workflow this task is a part of
     * @param jobId          the integer id of the job this task is a part of
     * @param workflow       the workflow (and by extension job) the task is associated with
     * @param taskId         the identifier of the task type
     * @param userId         the user who input the task
     * @param description    the optional description of the task
     * @param isPCR          flag that determines if the task is a PCR
     * @param recordsIn      the amount of records in before the task was completed
     * @param recordsOut     the amount of records out after the task was completed
     * @param recordsDropped the amount of records dropped as a result of the task
     * @param timeTaken      the setup time for the task
     * @param timeRecorded   the time the record of the task was entered by the user
     */
    public InputTask(Integer taskNum, Integer workflowId, Integer jobId, Workflow workflow, AvailableTask taskId, AppUser userId, String description,
                     Boolean isPCR, Integer recordsIn, Integer recordsOut, Integer recordsDropped, Integer timeTaken, Timestamp timeRecorded)
    {
        this.taskNum = taskNum;
        this.workflowId = workflowId;
        this.jobId = jobId;
        this.workflow = workflow;
        this.taskId = taskId;
        this.userId = userId;
        this.description = description;
        this.isPCR = isPCR;
        this.recordsIn = recordsIn;
        this.recordsOut = recordsOut;
        this.recordsDropped = recordsDropped;
        this.timeTaken = timeTaken;
        this.timeRecorded = timeRecorded;
    }

    public Integer getTaskNum()
    {
        return taskNum;
    }

    public void setTaskNum(Integer taskNum)
    {
        this.taskNum = taskNum;
    }

    public Integer getWorkflowId()
    {
        return workflowId;
    }

    public void setWorkflowId(Integer workflowId)
    {
        this.workflowId = workflowId;
    }

    public Integer getJobId()
    {
        return jobId;
    }

    public void setJobId(Integer jobId)
    {
        this.jobId = jobId;
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
        return taskId;
    }

    public void setTask_id(AvailableTask taskId)
    {
        this.taskId = taskId;
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

    public Boolean getPCR()
    {
        return isPCR;
    }

    public void setPCR(Boolean PCR)
    {
        isPCR = PCR;
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

    public Timestamp getTimeRecorded()
    {
        return timeRecorded;
    }

    public void setTimeRecorded(Timestamp timeRecorded)
    {
        this.timeRecorded = timeRecorded;
    }

    /**
     * Determines if this object is equal to another object
     *
     * @param o the object this object is being compared to
     * @return true if the two objects are equal, false otherwise
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
        if (workflowId != null ? !workflowId.equals(inputTask.workflowId) : inputTask.workflowId != null) {
            return false;
        }
        if (jobId != null ? !jobId.equals(inputTask.jobId) : inputTask.jobId != null) {
            return false;
        }
        if (workflow != null ? !workflow.equals(inputTask.workflow) : inputTask.workflow != null) {
            return false;
        }
        if (taskId != null ? !taskId.equals(inputTask.taskId) : inputTask.taskId != null) {
            return false;
        }
        if (userId != null ? !userId.equals(inputTask.userId) : inputTask.userId != null) {
            return false;
        }
        if (description != null ? !description.equals(inputTask.description) : inputTask.description != null) {
            return false;
        }
        if (isPCR != null ? !isPCR.equals(inputTask.isPCR) : inputTask.isPCR != null) {
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
        result = 31 * result + (workflowId != null ? workflowId.hashCode() : 0);
        result = 31 * result + (jobId != null ? jobId.hashCode() : 0);
        result = 31 * result + (workflow != null ? workflow.hashCode() : 0);
        result = 31 * result + (taskId != null ? taskId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (isPCR != null ? isPCR.hashCode() : 0);
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
