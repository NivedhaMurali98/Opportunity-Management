package com.jackrutorial.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jackrutorial.models.*;


//class containing the job skill mapping dao methods implementation
@Transactional
@Repository
public class JobSkDaoImpl implements JobSkDao
{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //method for getting all skills for given job id
    @Override
    public List<Job_Skill> getJobSk(int id)
    {
        String query = "SELECT * from job_skillsets where job_id=?";
        RowMapper<Job_Skill> rowMapper = new jobskillrowmapper();
        List<Job_Skill> list = jdbcTemplate.query(query, rowMapper,id);
        return list;
    }

    //method for adding skills for a job
    @Override
    public void addJobSk(Job_Skill job)
    {
        String query = "INSERT INTO job_skillsets ( job_id,skills ) VALUES (?, ?)";
        jdbcTemplate.update(query, job.getJobid(),job.getSkill());

    }

    //method for updating skills for a job
    @Override
    public void updateJobSk(Job_Skill job)
    {
        String query = "UPDATE job_skillsets  SET job_id=?,skills=?  WHERE job_id=?";
        jdbcTemplate.update(query, job.getJobid(),job.getSkill(),job.getJobid());
    }

    //method for deleting skills for a job
    @Override
    public void deleteJobSk(int id)
    {
        String query = "DELETE FROM job_skillsets WHERE job_id=?";
        jdbcTemplate.update(query, id);

    }
}
