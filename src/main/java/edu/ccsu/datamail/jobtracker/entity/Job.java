package edu.ccsu.datamail.jobtracker.entity;

import javax.persistence.*;

@Entity
@Table(name = "jobs", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "JOBS_UK", columnNames = "client_id")}) //
public class Job
{

    @Id
    @GeneratedValue
    @Column(name = "job_id", nullable = false)
    private int jobId;

    @Column(name = "job_desc", length = 60)
    private String jobDesc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public int getJobId(){return jobId;}

    public void setJobId(int jobId){this.jobId = jobId;}

    public String getJobDesc() {return jobDesc;}

    public void setJobDesc(String jobDesc){this.jobDesc = jobDesc;}

    public Client getClient() {return client;}

    public void setClient(Client client) {this.client = client; }


}

