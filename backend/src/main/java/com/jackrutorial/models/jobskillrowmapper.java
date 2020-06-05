package com.jackrutorial.models;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

//rowmapper for getting and setting the fields of job to skill mapping
public class jobskillrowmapper implements RowMapper<Job_Skill>
{
    @Override
    public Job_Skill mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Job_Skill jl = new Job_Skill();
        jl.setJobid(rs.getInt("job_id"));
        jl.setSkill(rs.getString("skills"));
        return jl;
    }
}