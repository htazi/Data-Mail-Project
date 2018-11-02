package edu.ccsu.datamail.jobtracker.entity.job;

import javax.persistence.*;

@Entity
@Table(name = "job", uniqueConstraints = {
        @UniqueConstraint(name = "job_pk", columnNames = "job_id")
})
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

    public int getJobId()
    {
        return jobId;
    }

    public void setJobId(int jobId)
    {
        this.jobId = jobId;
    }

    public String getJobDesc()
    {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc)
    {
        this.jobDesc = jobDesc;
    }

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Job)) {
            return false;
        }

        Job job = (Job) o;

        if (jobId != job.jobId) {
            return false;
        }
        if (jobDesc != null ? !jobDesc.equals(job.jobDesc) : job.jobDesc != null) {
            return false;
        }
        return client != null ? client.equals(job.client) : job.client == null;
    }

    @Override
    public int hashCode()
    {
        int result = jobId;
        result = 31 * result + (jobDesc != null ? jobDesc.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        return result;
    }
}

