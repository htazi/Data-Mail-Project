package edu.ccsu.datamail.jobtracker.entity;

import org.postgresql.util.PGmoney;

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
    @GeneratedValue
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
    private PGmoney price;

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

    public PGmoney getPrice()
    {
        return price;
    }

    public void setPrice(PGmoney price)
    {
        this.price = price;
    }
}
