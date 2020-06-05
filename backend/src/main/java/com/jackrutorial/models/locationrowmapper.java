package com.jackrutorial.models;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

//rowmapper for setting location entity
public class locationrowmapper implements RowMapper<Location>
{
    @Override
    public Location mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        Location location = new Location();
        location.setLocid(rs.getInt("location_id"));
        location.setTitle(rs.getString("title"));
        return location;
    }
}
