package edu.ccsu.datamail.jobtracker.entity.task;

import java.io.Serializable;

/**
 * ID class for the InputTask JPA
 * <p>
 * Contains attributes related to the primary key of the input_task table in the database
 * Workflow represents the foreign key for attributes job_id and wf_id that are part of the primary key of input_task
 */
public class InputTaskPK implements Serializable
{

    /**
     * The number for the task in the workflow
     */
    private Integer taskNum;

    /**
     * The id of the workflow this task is associated with
     */
    private Integer workflowId;

    /**
     * The id of the job this task is associated with
     */
    private Integer jobId;

    public InputTaskPK()
    {
    }

    public InputTaskPK(Integer taskNum, Integer workflowId, Integer jobId)
    {
        this.taskNum = taskNum;
        this.workflowId = workflowId;
        this.jobId = jobId;
    }

    public Integer getTaskNum()
    {
        return taskNum;
    }

    public void setTaskNum(Integer taskNum)
    {
        this.taskNum = taskNum;
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
        if (!(o instanceof InputTaskPK)) {
            return false;
        }

        InputTaskPK that = (InputTaskPK) o;

        if (taskNum != null ? !taskNum.equals(that.taskNum) : that.taskNum != null) {
            return false;
        }
        if (workflowId != null ? !workflowId.equals(that.workflowId) : that.workflowId != null) {
            return false;
        }
        return jobId != null ? jobId.equals(that.jobId) : that.jobId == null;
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
        return result;
    }
}
