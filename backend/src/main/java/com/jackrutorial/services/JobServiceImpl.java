package com.jackrutorial.services;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jackrutorial.dao.*;
import com.jackrutorial.models.*;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


//job service method implementations
@Service
@RequestMapping("/job")
public class JobServiceImpl  implements  JobService
{
    private static final Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);
    @Autowired
    private JobDao jobDao;

    //method for getting all jobs
    @Override
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/lists")
    @ResponseBody
    public List<Job> getAllJobs()
    {
        return jobDao.getAllJobs();
    }

    //method for geting jobs byid
    @Override
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path="/print/{id}")
    @ResponseBody
    public Job findJobById(@PathVariable int id)
    {
        return jobDao.findJobById(id);
    }

    //method for adding job
    @Override
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    public void addJob(@Valid @RequestBody Job job)
    {
        jobDao.addJob(job);

    }

    //method for updating job
    @Override
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping ("/updates")
    public void updateJob(@Valid @RequestBody Job job)
    {
        jobDao.updateJob(job);

    }

    //method for deleting job
    @Override
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    public void deleteJob(@PathVariable int id)
    {
        jobDao.deleteJob(id);

    }
}
