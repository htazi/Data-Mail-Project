package edu.ccsu.datamail.jobtracker.entity;

import javax.persistence.*;

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
    @GeneratedValue
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

