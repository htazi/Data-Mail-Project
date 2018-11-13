package edu.ccsu.datamail.jobtracker.entity.job;

public class JobNotFoundException extends Exception
{
    public JobNotFoundException(String msg)
    {
        super(msg);
    }
}
