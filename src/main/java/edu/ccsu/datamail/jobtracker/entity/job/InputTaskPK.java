package edu.ccsu.datamail.jobtracker.entity.job;

import java.io.Serializable;

/**
 * ID class for the InputTask JPA
 * <p>
 * Contains attributes related to the primary key of the input_task table in the database
 * Workflow represents the foreign key for attributes job_id and wf_id that are part of the primary key of input_task
 */
class InputTaskPK implements Serializable
{

    /**
     * The number for the task in the workflow
     */
    private Integer taskNum;

    /**
     * The workflow (and by extension job) this task is associated with
     */
    private Workflow workflow;

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
        return workflow != null ? workflow.equals(that.workflow) : that.workflow == null;
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
        return result;
    }
}
