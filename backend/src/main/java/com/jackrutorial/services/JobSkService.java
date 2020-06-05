
package com.jackrutorial.services;
import com.jackrutorial.models.Job_Skill;
import java.util.List;

//job sill mapping service interface
public interface JobSkService
{
    public List<Job_Skill> getJobSk(int id);
    public void addJobSk(Job_Skill job);
    public void updateJobSk(Job_Skill job);
    public void deleteJobSk(int id);
}
