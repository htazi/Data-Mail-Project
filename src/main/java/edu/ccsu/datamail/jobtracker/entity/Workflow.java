package edu.ccsu.datamail.jobtracker.entity;

import javax.persistence.*;

@IdClass(WorkflowPK.class)
@Entity
@Table(name = "workflow", uniqueConstraints = {
        @UniqueConstraint(name = "workflow_pk", columnNames = {"job_id", "wf_id"})
})
public class Workflow
{

    @Id
    @GeneratedValue
    @Column(name = "wf_id", nullable = false)
    private int workflowId;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @Column(name = "wf_desc", length = 60)
    private String wfDesc;


    public int getWfId(){return workflowId;}

    public String getWfDesc()
    {
        return wfDesc;
    }

    public void setWfDesc(String wfDesc)
    {
        this.wfDesc = wfDesc;
    }

    public Job getJob()
    {
        return job;
    }

    public void setJob(Job job)
    {
        this.job = job;
    }

}

