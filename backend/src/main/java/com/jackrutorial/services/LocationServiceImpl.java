package com.jackrutorial.services;
import com.jackrutorial.dao.*;
import com.jackrutorial.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

//location service method implementations
@Service
@RequestMapping("/location")
public class LocationServiceImpl implements  LocationService{

    private static final Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);
    @Autowired
    private LocationDao locDao;

    //method for getting all locations
    @Override
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/lists")
    @ResponseBody
    public List<Location> getAllLocations()
    {
        return locDao.getAllLocations();
    }

    //method for getting location by id
    @Override
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list/{id}")
    @ResponseBody
    public Location findLocationById(@PathVariable int id)
    {
        return locDao.findLocationById(id);
    }

}

