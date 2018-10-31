package edu.ccsu.datamail.jobtracker.entity;

import java.io.Serializable;

public class WorkflowPK implements Serializable
{

    private Integer workflowId;

    private Job job;

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
            return this.workflowId.equals(other.workflowId) && this.job.equals(other.job);
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode()
    {
        int hash = 37;
        if (workflowId != null) {
            hash += workflowId.hashCode();
        }
        if (job != null) {
            hash += job.hashCode();
        }
        return hash;
    }

}
