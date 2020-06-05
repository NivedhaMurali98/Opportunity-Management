package com.jackrutorial.dao;

import com.jackrutorial.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

//class containing the chart dao methods implementation
@Transactional
@Repository
public class ChartDaoImpl implements ChartDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //method to get the skills and their count
    @Override
    public List<chart> getSkCount()
    {
        String query = "SELECT skills ,count(*) as count from project1.job_skillsets group by skills";
        RowMapper<chart> rowMapper = new chartrowmapper();
        List<chart> list = jdbcTemplate.query(query, rowMapper);
        return list;
    }

    //method to get the locations and  their respective count
    @Override
    public List<chart> getLocCount()
    {
        String query = "SELECT location ,count(*) as count from project1.job_locations group by location";
        RowMapper<chart> rowMapper = new chartrowmapper1();
        List<chart> list = jdbcTemplate.query(query, rowMapper);
        return list;

    }

    //method for getting the names of hiring managers and their job posting rate
    @Override
    public List<chart> getHmCount()
    {
        String query = "SELECT user.name as location ,count(*) as count FROM job INNER JOIN user ON job.creator_id=user.id group by job.creator_id";
        RowMapper<chart> rowMapper = new chartrowmapper1();
        List<chart> list = jdbcTemplate.query(query, rowMapper);
        return list;

    }
}
