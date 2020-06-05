package com.jackrutorial.models;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

//rowmapper for setting the fields of the job entities
public class jobrowmapper implements RowMapper<Job>
{
    @Override
    public Job mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Job job = new Job();
        job.setJobid(rs.getInt("job_id"));
        job.setDescription(rs.getString("description"));
        job.setEmptype(rs.getString("emptype"));
        job.setIsactive(rs.getString("isactive"));
        job.setOpenings(rs.getInt("openings"));
        job.setCreaterid(rs.getInt("creator_id"));
        job.setUpdatorid(rs.getInt("updater_no"));
        job.setDatemod(rs.getString("datemod"));
        return job;
    }

}