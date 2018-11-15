package edu.ccsu.datamail.jobtracker.entity.workflow;


import java.io.Serializable;

/**
 * Id class for Workflow JPA
 * <p>
 * Contains attributes related to the primary key of the workflow table in the database
 */
public class WorkflowPK implements Serializable
{
    /**
     * The Workflow Id, unique for each job
     */
    private Integer workflowId;

    /**
     * The id of the jobId this Workflow is associated with
     */
    private Integer jobId;

    /**
     * Default Constructor
     */
    public WorkflowPK()
    {
    }

    public WorkflowPK(Integer workflowId, Integer jobId)
    {
        this.workflowId = workflowId;
        this.jobId = jobId;
    }

    public Integer getWorkflowId()
    {
        return workflowId;
    }

    public void setWorkflowId(Integer workflowId)
    {
        this.workflowId = workflowId;
    }

    public Integer getJob()
    {
        return jobId;
    }

    public void setJob(Integer jobId)
    {
        this.jobId = jobId;
    }

    /**
     * Determines if this object is equal to another object
     *
     * @param obj the object this object is being compared to
     * @return true if the two objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof WorkflowPK) {
            WorkflowPK other = (WorkflowPK) obj;
            return this.workflowId.equals(other.workflowId) && this.jobId.equals(other.jobId);
        }
        else {
            return false;
        }
    }

    /**
     * Returns a hashCode value for this object
     *
     * @return an integer hash code for this object
     */
    @Override
    public int hashCode()
    {
        int hash = 37;
        if (workflowId != null) {
            hash += workflowId.hashCode();
        }
        if (jobId != null) {
            hash += jobId.hashCode();
        }
        return hash;
    }

}
