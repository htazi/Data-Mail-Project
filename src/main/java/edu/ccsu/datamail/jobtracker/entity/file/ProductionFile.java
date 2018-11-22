package edu.ccsu.datamail.jobtracker.entity.file;

import javax.persistence.*;

@Entity
@Table(name = "file", uniqueConstraints = {
        @UniqueConstraint(name = "file_pk", columnNames = "file_id")
})
public class ProductionFile
{
    /**
     * The Id of the file in the database
     */
    @Id
    @Column(name = "file_id", nullable = false)
    private Integer fileId;

    /**
     * The Name of the file
     */
    @Column(name = "file_name", length = 60)
    private String fileName;

    /**
     * Default Constructor
     */
    public ProductionFile()
    {
    }

    /**
     * Alternate Constructor
     * <p>
     * Creates a new ProductionFile with the specified fileId and name
     *
     * @param fileId   the id of the new file
     * @param fileName the name of the new file
     */
    public ProductionFile(Integer fileId, String fileName)
    {
        this.fileId = fileId;
        this.fileName = fileName;
    }

    public Integer getFileId()
    {
        return fileId;
    }

    public void setFileId(Integer fileId)
    {
        this.fileId = fileId;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductionFile)) {
            return false;
        }
        ProductionFile productionFile = (ProductionFile) o;
        if (fileId != null ? !fileId.equals(productionFile.fileId) : productionFile.fileId != null) {
            return false;
        }
        return fileName != null ? fileName.equals(productionFile.fileName) : productionFile.fileName == null;
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
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        return result;
    }
}
