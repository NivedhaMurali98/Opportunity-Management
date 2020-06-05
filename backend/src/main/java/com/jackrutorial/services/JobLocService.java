package com.jackrutorial.services;
import com.jackrutorial.models.Job;
import com.jackrutorial.models.Job_Location;
import java.util.List;

//job location mapping service interface
public interface JobLocService
{
    public List<Job_Location> getJobLoc(int id);
    public void addJobLoc(Job_Location job);
    public void updateJobLoc(Job_Location job);
    public void deleteJobLoc(int id);
}
