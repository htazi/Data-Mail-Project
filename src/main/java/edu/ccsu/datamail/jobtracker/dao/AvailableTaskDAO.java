package edu.ccsu.datamail.jobtracker.dao;

import edu.ccsu.datamail.jobtracker.entity.job.AvailableTask;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Deprecated
public class AvailableTaskDAO {
    @Autowired
    private EntityManager entityManager;

    public AvailableTask findAvailableTask(int taskID)
    {
        try { // currently finds a specific workflow instead of any workflow
            String sql = "Select w from " + AvailableTask.class.getName() + " w "+ "Where w.task_id =" + taskID;
            Query query = entityManager.createQuery(sql, AvailableTask.class);
            return (AvailableTask) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
