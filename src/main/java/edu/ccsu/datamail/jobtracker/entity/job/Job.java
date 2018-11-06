package edu.ccsu.datamail.jobtracker.entity.job;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "job", uniqueConstraints = {
        @UniqueConstraint(name = "job_pk", columnNames = "job_id")
})
public class Job implements Serializable
{
    /**
     * Default Constructor:
     */
    public Job()
    {
    }

    /**
     * Alternate Constructor:
     * Creates a new Job with the associated description and client
     *
     * @param jobDesc the description of the job
     * @param client  the client associated with the job
     */
    public Job(String jobDesc, Client client)
    {
        this.jobDesc = jobDesc; // Id not included here as its generated, may have to change later
        this.client = client;
    }

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

    /**
     * Returns a hashCode value for this object
     *
     * @return an integer hash code for this object
     */
    @Override
    public int hashCode()
    {
        int result = jobId;
        result = 31 * result + (jobDesc != null ? jobDesc.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        return result;
    }
}

