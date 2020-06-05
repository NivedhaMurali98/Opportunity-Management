package com.jackrutorial.services;
import com.jackrutorial.dao.JobLocDao;
import com.jackrutorial.dao.JobLocDaoImpl;
import com.jackrutorial.dao.LocationDaoImpl;
import com.jackrutorial.models.Job_Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

//job location mapping service method implementations
@Service
@RequestMapping("/joblocs")
public class JobLocServiceImpl implements JobLocService
{

    private static final Logger logger = LoggerFactory.getLogger(JobLocServiceImpl.class);
    @Autowired
    private JobLocDao joblocDao;

    //method for getting job and their location
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/lists/{id}")
    @ResponseBody
    @Override
    public List<Job_Location> getJobLoc(@PathVariable int id)
    {
        return joblocDao.getJobLoc(id);
    }

    //method for adding job and their location
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping ("/add")
    @Override
    public void addJobLoc(@Valid @RequestBody Job_Location job)
    {
        joblocDao.addJobLoc(job);
    }

    //method for updating job locations
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update")
    @Override
    public void updateJobLoc(@Valid @RequestBody Job_Location job)
    {
         joblocDao.updateJobLoc(job);
    }

    //method for deleting job and its location
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteJobLoc(@PathVariable int id)
    {
          joblocDao.deleteJobLoc(id);
    }

}
