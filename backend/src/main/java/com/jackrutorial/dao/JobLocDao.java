package com.jackrutorial.dao;
import com.jackrutorial.models.Job;
import com.jackrutorial.models.Job_Location;
import java.util.List;


//dao interface for accesing the job location mapping  enity data from db
public interface JobLocDao
{
    public List<Job_Location> getJobLoc(int id);
    public void addJobLoc(Job_Location job);
    public void updateJobLoc(Job_Location job);
    public void deleteJobLoc(int id);
}
