package edu.ccsu.datamail.jobtracker.service;

import edu.ccsu.datamail.jobtracker.dao.JobDAO;
import edu.ccsu.datamail.jobtracker.dao.WorkflowDAO;
import edu.ccsu.datamail.jobtracker.entity.job.Job;
import edu.ccsu.datamail.jobtracker.entity.job.Workflow;
import edu.ccsu.datamail.jobtracker.entity.user.AppUser;
import edu.ccsu.datamail.jobtracker.repository.JobRepository;
import edu.ccsu.datamail.jobtracker.repository.WorkflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobDAO jobDAO;

    /**
     * Finds and returns a workflow associated with a given job
     *
     * @param jobId      the id of the job the workflow belongs to
     * @param jobId the id of the workflow
     * @return the workflow if found, null otherwise
     */
    public Job getJob(int jobId) {

        return jobDAO.findJob(jobId);
    }

    public int findWFNumber(int jobId) {

        List<Workflow> wf  = new ArrayList();
        wf = jobDAO.findNextWorkflowId(jobId);
        int max=0;

        for(Workflow w:wf)
        {
            int num1 =  w.getWorkflowId();
            if( num1 > max)
            {
                max = num1;
            }
        }
        max = max +1;

        return max;
    }
}