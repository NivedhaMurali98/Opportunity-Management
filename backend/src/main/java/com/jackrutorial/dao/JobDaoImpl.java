package com.jackrutorial.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.jackrutorial.models.*;

//class containing the job dao methods implementation
@Transactional
@Repository
public class JobDaoImpl implements JobDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //method for getting all the jobs
    @Override
    public List<Job> getAllJobs()
    {
        String query = "SELECT * from job";
        RowMapper<Job> rowMapper = new jobrowmapper();
        List<Job> list = jdbcTemplate.query(query, rowMapper);
        return list;
    }

    //method for getting job by id
    @Override
    public Job findJobById(int id)
    {
        String query = "SELECT * FROM job WHERE job_id = ?";
        RowMapper<Job> rowMapper = new jobrowmapper();
        Job job = jdbcTemplate.queryForObject(query, rowMapper,id);
        return job;
    }

    //method for adding a job entity
    @Override
    public void addJob(Job job)
    {
        String query = "INSERT INTO job(job_id,description, emptype, isactive, openings, creator_id,updater_no,datemod) VALUES(?, ?,?,?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, job.getJobid(), job.getDescription(), job.getEmptype(), job.getIsactive(), job.getOpenings(), job.getCreaterid(),job.getUpdatorid(),job.getDatemod());
    }


    //method for updating a job entity
    @Override
    public void updateJob(Job job)
    {
        String query = "UPDATE job SET job_id=?, description=?, emptype=?, isactive=?, openings=?, creator_id=?,updater_no=?,datemod=? WHERE job_id=?";
        jdbcTemplate.update(query, job.getJobid(),job.getDescription(), job.getEmptype(), job.getIsactive(), job.getOpenings(), job.getCreaterid(),job.getUpdatorid(),job.getDatemod(),job.getJobid());

    }


    //method for deleting a job entity
    @Override
    public void deleteJob(int id)
    {
        String query = "DELETE FROM job WHERE job_id=?";
        jdbcTemplate.update(query, id);

    }
}
