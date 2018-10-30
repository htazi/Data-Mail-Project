package edu.ccsu.datamail.jobtracker.entity;

import javax.persistence.*;

@Entity
@Table(name = "workflows", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "WORK_FLOWS_UK", columnNames = "job_id")}) //
public class WorkFlows
{

    @Id
    @GeneratedValue
    @Column(name = "wf_id", nullable = false)
    private int wfId;

    @Column(name = "wf_desc", length = 60)
    private String wfDesc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    public int getWfId(){return wfId;}

    public void setWfId(int wfId){this.wfId = wfId;}

    public String getWfDesc() {return wfDesc;}

    public void setWfDesc(String wfDesc){this.wfDesc = wfDesc;}

    public Job getJob() {return job;}

    public void setJob(Job job) {this.job = job; }


}

