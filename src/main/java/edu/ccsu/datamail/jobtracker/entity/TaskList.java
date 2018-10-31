package edu.ccsu.datamail.jobtracker.entity;

import javax.persistence.*;

@Entity
@Table(name = "task_list", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "WORK_FLOWS_UK", columnNames = "acronym")}) //
public class TaskList
{

    @Id
    @GeneratedValue
    @Column(name = "task_id", nullable = false)
    private int taskId;

    @Column(name = "acronym", length = 6)
    private String acronym;

    @Column(name = "t_desc", length = 60)
    private String taskDesc;

    @Column(name = "is_billable", length = 1, nullable = false)
    private boolean isBillable;

    @Column(name = "price")
    private double price ;

    public int getTaskId(){return taskId;}

    public void setTaskId(int taskId){this.taskId = taskId;}

    public String getAcronym(){return acronym;}

    public void setAcronym(String acronym){this. acronym = acronym;}

    public String getTaskDesc() {return taskDesc;}

    public void setTaskDesc(String taskDesc){this.taskDesc = taskDesc;}

    public boolean getBillabel() {return isBillable;}

    public void setBillabel(boolean isBillable){this.isBillable= isBillable;}

    public double getPrice() {return price;}

    public void setPrice(double price) {this.price = price; }


}


