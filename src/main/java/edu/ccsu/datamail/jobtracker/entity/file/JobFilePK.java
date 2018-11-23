package edu.ccsu.datamail.jobtracker.entity.file;

import java.io.Serializable;

/**
 * Identifier class for the job_file table in the database
 */
public class JobFilePK implements Serializable
{
    /**
     * The Id of the file tracked by the system
     */
    private Integer fileId;

    /**
     * The Id of the job the file is associated with
     */
    private Integer jobId;

    /**
     * Default Constructor
     */
    public JobFilePK()
    {
    }

    /**
     * Alternate Constructor
     * Creates a new JobFilePK object with the specified values
     *
     * @param fileId the id of hte file in the database
     * @param jobId  the id of the job in the database
     */
    public JobFilePK(Integer fileId, Integer jobId)
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
        if (!(o instanceof JobFilePK)) {
            return false;
        }

        JobFilePK jobFilePK = (JobFilePK) o;

        if (fileId != null ? !fileId.equals(jobFilePK.fileId) : jobFilePK.fileId != null) {
            return false;
        }
        return jobId != null ? jobId.equals(jobFilePK.jobId) : jobFilePK.jobId == null;
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
        return result;
    }
}
