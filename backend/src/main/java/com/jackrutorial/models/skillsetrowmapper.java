package com.jackrutorial.models;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

//rowmapper for setting the fields of skillset entity
public class skillsetrowmapper implements RowMapper<Skillset>
{
    @Override
    public Skillset mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Skillset skills = new Skillset();
        skills.setSkid(rs.getInt("id"));
        skills.setTitle(rs.getString("title"));
        return skills;
    }
}
