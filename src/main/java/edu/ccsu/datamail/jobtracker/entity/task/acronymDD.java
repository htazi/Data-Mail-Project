package edu.ccsu.datamail.jobtracker.entity.task;

public class acronymDD {
    int taskId;
    String acronym;

    public acronymDD(int taskId, String acronym) {
        this.taskId = taskId;
        this.acronym = acronym;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
}
