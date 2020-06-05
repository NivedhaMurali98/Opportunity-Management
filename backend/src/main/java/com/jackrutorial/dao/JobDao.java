package com.jackrutorial.dao;

import com.jackrutorial.models.*;

import java.util.List;

//dao interface for accesing the job enity data from db
public interface JobDao
{

    public List<Job> getAllJobs();
    public Job findJobById(int id);
    public void addJob(Job job);
    public void updateJob(Job job);
    public void deleteJob(int id);
}