package edu.ccsu.datamail.jobtracker.entity.job;

import javax.persistence.*;

/**
 * Represents a task that a User can record as part of a workflow for a job.
 */
@Entity
@Table(name = "task_list", uniqueConstraints = {
        @UniqueConstraint(name = "task_list_pk", columnNames = "task_id")
})
public class AvailableTask
{

    /**
     * The Id of the task
     */
    @Id
    @Column(name = "task_id", nullable = false)
    private int taskId;

    /**
     * The Acronym of the task
     */
    @Column(name = "acronym", length = 6)
    private String acronym;

    /**
     * The description of the task
     */
    @Column(name = "t_desc", length = 60)
    private String taskDesc;

    /**
     * flag that determines if the task is billable
     */
    @Column(name = "is_billable", length = 1, nullable = false)
    private boolean isBillable;

    /**
     * The price of the task if billable
     */
    @Column(name = "price")
    private Double price;

    public AvailableTask( ) {

    }

    public AvailableTask(String acronym, String taskDesc, boolean isBillable, PGmoney price) {
        super();

        this.acronym = acronym;
        this.taskDesc = taskDesc;
        this.isBillable = isBillable;
        this.price = price;
    }

    public int getTaskId()
    {
        return taskId;
    }

    public void setTaskId(int taskId)
    {
        this.taskId = taskId;
    }

    public String getAcronym()
    {
        return acronym;
    }

    public void setAcronym(String acronym)
    {
        this.acronym = acronym;
    }

    public String getTaskDesc()
    {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc)
    {
        this.taskDesc = taskDesc;
    }

    public boolean isBillable()
    {
        return isBillable;
    }

    public void setBillable(boolean billable)
    {
        isBillable = billable;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AvailableTask)) {
            return false;
        }

        AvailableTask that = (AvailableTask) o;

        if (taskId != that.taskId) {
            return false;
        }
        if (isBillable != that.isBillable) {
            return false;
        }
        if (acronym != null ? !acronym.equals(that.acronym) : that.acronym != null) {
            return false;
        }
        if (taskDesc != null ? !taskDesc.equals(that.taskDesc) : that.taskDesc != null) {
            return false;
        }
        return price != null ? price.equals(that.price) : that.price == null;
    }

    @Override
    public int hashCode()
    {
        int result = taskId;
        result = 31 * result + (acronym != null ? acronym.hashCode() : 0);
        result = 31 * result + (taskDesc != null ? taskDesc.hashCode() : 0);
        result = 31 * result + (isBillable ? 1 : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
