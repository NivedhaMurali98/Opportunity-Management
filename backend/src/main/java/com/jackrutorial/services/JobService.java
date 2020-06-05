package com.jackrutorial.services;
import com.jackrutorial.models.Job;
import java.util.List;

//job  service interface
public interface JobService
{
    public List<Job> getAllJobs();
    public Job findJobById(int id);
    public void addJob(Job job);
    public void updateJob(Job job);
    public void deleteJob(int id);
}