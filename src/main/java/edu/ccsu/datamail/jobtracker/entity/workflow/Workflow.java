package edu.ccsu.datamail.jobtracker.entity.workflow;

import edu.ccsu.datamail.jobtracker.entity.job.Job;

import javax.persistence.*;

/**
 * JPA class for the workflow table in the database
 * <p>
 * Contains information associated with a workflow within a job
 */
@Entity
@IdClass(WorkflowPK.class)
@Table(name = "workflow", uniqueConstraints = {
        @UniqueConstraint(name = "workflow_pk", columnNames = {"job_id", "wf_id"})
})
public class Workflow
{
    /**
     * The id for this Workflow, unique for each job
     */
    @Id
    @Column(name = "wf_id", nullable = false)
    private Integer workflowId;

    /**
     * The job this Workflow is associated with
     */
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    /**
     * The Description for this workflow
     */
    @Column(name = "wf_desc", length = 60)
    private String wfDesc;

    /**
     * Default Constructor
     */
    public Workflow()
    {
    }

    /**
     * Alternate Constructor:
     * Creates a new Workflow ojbect with all fields initialized
     *
     * @param workflowId the id of the workflow within a job
     * @param job        the job this workflow is associated with
     * @param wfDesc     the description of the workflow
     */
    public Workflow(Integer workflowId, Job job, String wfDesc)
    {
        this.workflowId = workflowId;
        this.job = job;
        this.wfDesc = wfDesc;
    }

    public int getWorkflowId()
    {
        return workflowId;
    }

    public void setWorkflowId(int workflowId)
    {
        this.workflowId = workflowId;
    }

    public Job getJob()
    {
        return job;
    }

    public void setJob(Job job)
    {
        this.job = job;
    }

    public String getWfDesc()
    {
        return wfDesc;
    }

    public void setWfDesc(String wfDesc)
    {
        this.wfDesc = wfDesc;
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
        if (!(o instanceof Workflow)) {
            return false;
        }

        Workflow workflow = (Workflow) o;

        if (workflowId != null ? !workflowId.equals(workflow.workflowId) : workflow.workflowId != null) {
            return false;
        }
        if (job != null ? !job.equals(workflow.job) : workflow.job != null) {
            return false;
        }
        return wfDesc != null ? wfDesc.equals(workflow.wfDesc) : workflow.wfDesc == null;
    }

    /**
     * Returns a hashCode value for this object
     *
     * @return an integer hash code for this object
     */
    @Override
    public int hashCode()
    {
        int result = workflowId != null ? workflowId.hashCode() : 0;
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + (wfDesc != null ? wfDesc.hashCode() : 0);
        return result;
    }

    /**
     * Returns a String representation of this Workflow
     *
     * @return a string containing information on this Workflow
     */
    @Override
    public String toString()
    {
        return "job: " + job.getJobId() + " workflow: " + workflowId.toString() + " description: " + wfDesc;
    }
}

