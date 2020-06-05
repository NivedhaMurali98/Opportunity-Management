
package com.jackrutorial.dao;
import com.jackrutorial.models.Job;
import com.jackrutorial.models.Job_Location;
import com.jackrutorial.models.Job_Skill;
import java.util.List;

//dao interface for accesing the job skills mapping enity data from db
public interface JobSkDao
{
    public List<Job_Skill> getJobSk(int id);
    public void addJobSk(Job_Skill job);
    public void updateJobSk(Job_Skill job);
    public void deleteJobSk(int id);
}
