package com.jackrutorial.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//rowmapper for getting and setting the fields of job to location mapping
public class joblocrowmaper implements RowMapper<Job_Location>
{
    @Override
    public Job_Location mapRow(ResultSet rs, int rowNum) throws SQLException {
        Job_Location jl = new Job_Location();
        jl.setJobid(rs.getInt("job_id"));
        jl.setLoc(rs.getString("location"));
        return jl;
    }
}