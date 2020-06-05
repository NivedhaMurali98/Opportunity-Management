package com.jackrutorial.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jackrutorial.models.*;
import org.springframework.web.bind.annotation.PathVariable;

//class containing the job location  dao methods implementation
@Transactional
@Repository
public class JobLocDaoImpl implements JobLocDao
{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //method for getting all location of particular job
    @Override
    public List<Job_Location> getJobLoc(int id)
    {
        String query = "SELECT * from job_locations where job_id=?";
        RowMapper<Job_Location> rowMapper = new joblocrowmaper();
        List<Job_Location> list = jdbcTemplate.query(query, rowMapper,id);
        return list;
    }

    //method for adding location for a job
    @Override
    public void addJobLoc(Job_Location job)
    {
        String query = "INSERT INTO job_locations ( job_id,location ) VALUES (?, ?)";
        jdbcTemplate.update(query, job.getJobid(),job.getLoc());

    }

    //method for updating location for job
    @Override
    public void updateJobLoc(Job_Location job)
    {
        String query = "UPDATE job_locations  SET job_id=?,location=?  WHERE job_id=?";
        jdbcTemplate.update(query, job.getJobid(),job.getLoc(),job.getJobid());

    }

    //method for deleting al locations of job
    @Override
    public void deleteJobLoc(int id)
    {
        String query = "DELETE FROM job_locations WHERE job_id=?";
        jdbcTemplate.update(query, id);

    }
}
