package com.jackrutorial.dao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.jackrutorial.models.*;

//class containing the location dao methods implementation
@Transactional
@Repository
public class LocationDaoImpl implements LocationDao
{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //method for getting all locations
    @Override
    public List<Location> getAllLocations()
    {
        String query = "SELECT * from locations";
        RowMapper<Location> rowMapper = new locationrowmapper();
        List<Location>  list = jdbcTemplate.query(query, rowMapper);
        return list;
    }

    //method for finding location by id
    @Override
    public Location findLocationById(int id)
    {
        String query = "SELECT * FROM locations WHERE location_id = ?";
        RowMapper<Location> rowMapper = new BeanPropertyRowMapper<Location>(Location.class);
        Location job = jdbcTemplate.queryForObject(query, rowMapper, id);
        return job;

    }
}
