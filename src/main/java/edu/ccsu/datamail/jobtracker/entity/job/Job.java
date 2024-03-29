package edu.ccsu.datamail.jobtracker.entity.job;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "job", uniqueConstraints = {
        @UniqueConstraint(name = "job_pk", columnNames = "job_id")
})
public class Job implements Serializable
{
    @Id
    @Column(name = "job_id", nullable = false)
    private Integer jobId;

    @Column(name = "job_desc", length = 60)
    private String jobDesc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "data_mill_num")
    private Integer dataMillNumber;

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
     * @param jobId          the integer id of the job
     * @param jobDesc        the description of the job
     * @param client         the client associated with the job
     * @param dataMillNumber the data-mill job number associated with the job
     */
    public Job(Integer jobId, String jobDesc, Client client, Integer dataMillNumber)
    {
        this.jobId = jobId;
        this.jobDesc = jobDesc;
        this.client = client;
        this.dataMillNumber = dataMillNumber;
    }

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

    public Integer getDataMillNumber()
    {
        return dataMillNumber;
    }

    public void setDataMillNumber(Integer dataMillNumber)
    {
        this.dataMillNumber = dataMillNumber;
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

        if (jobId != null ? !jobId.equals(job.jobId) : job.jobId != null) {
            return false;
        }
        if (jobDesc != null ? !jobDesc.equals(job.jobDesc) : job.jobDesc != null) {
            return false;
        }
        if (client != null ? !client.equals(job.client) : job.client != null) {
            return false;
        }
        return dataMillNumber != null ? dataMillNumber.equals(job.dataMillNumber) : job.dataMillNumber == null;
    }

    /**
     * Returns a hashCode value for this object
     *
     * @return an integer hash code for this object
     */
    @Override
    public int hashCode()
    {
        int result = jobId != null ? jobId.hashCode() : 0;
        result = 31 * result + (jobDesc != null ? jobDesc.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (dataMillNumber != null ? dataMillNumber.hashCode() : 0);
        return result;
    }
}

