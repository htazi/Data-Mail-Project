package edu.ccsu.datamail.jobtracker.entity.file;

import edu.ccsu.datamail.jobtracker.entity.job.Job;

import javax.persistence.*;

/**
 * JPA for the job_file table in the database
 * <p>
 * Enables jobs to be linked with specific files for use by the Text Department
 */
@Entity
@IdClass(JobFilePK.class)
@Table(name = "job_file", uniqueConstraints = {
        @UniqueConstraint(name = "job_file_pk", columnNames = {"file_id", "job_id"})
})
public class JobFile
{
    /**
     * The Id of the file in the database
     */
    @Id
    @Column(name = "file_id", nullable = false)
    private Integer fileId;

    /**
     * The Id of the job in the database
     */
    @Id
    @Column(name = "job_id", nullable = false)
    private Integer jobId;

    /**
     * Join Column for the ProductionFile this record references
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id", insertable = false, updatable = false)
    private ProductionFile file;

    /**
     * Join Column for the Job this record references
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", insertable = false, updatable = false)
    private Job job;

    /**
     * Default Constructor
     */
    private JobFile()
    {

    }

    /**
     * Alternate Constructor
     * Creates a new JobFile with the associated attributes
     *
     * @param fileId the id of the file in the database
     * @param jobId  the id of the job in the database
     */
    public JobFile(Integer fileId, Integer jobId)
    {
        this.fileId = fileId;
        this.jobId = jobId;
    }

    public Integer getFileId()
    {
        return fileId;
    }

    public void setFileId(Integer fileId)
    {
        this.fileId = fileId;
    }

    public Integer getJobId()
    {
        return jobId;
    }

    public void setJobId(Integer jobId)
    {
        this.jobId = jobId;
    }

    public ProductionFile getFile()
    {
        return file;
    }

    public void setFile(ProductionFile file)
    {
        this.file = file;
    }

    public Job getJob()
    {
        return job;
    }

    public void setJob(Job job)
    {
        this.job = job;
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
        if (!(o instanceof JobFile)) {
            return false;
        }

        JobFile jobFile = (JobFile) o;

        if (fileId != null ? !fileId.equals(jobFile.fileId) : jobFile.fileId != null) {
            return false;
        }
        if (jobId != null ? !jobId.equals(jobFile.jobId) : jobFile.jobId != null) {
            return false;
        }
        if (file != null ? !file.equals(jobFile.file) : jobFile.file != null) {
            return false;
        }
        return job != null ? job.equals(jobFile.job) : jobFile.job == null;
    }

    /**
     * Returns a hashCode value for this object
     *
     * @return an integer hash code for this object
     */
    @Override
    public int hashCode()
    {
        int result = fileId != null ? fileId.hashCode() : 0;
        result = 31 * result + (jobId != null ? jobId.hashCode() : 0);
        result = 31 * result + (file != null ? file.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        return result;
    }
}
