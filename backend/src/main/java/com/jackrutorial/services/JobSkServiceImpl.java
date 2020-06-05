package com.jackrutorial.services;
import com.jackrutorial.dao.*;
import com.jackrutorial.models.Job_Location;
import com.jackrutorial.models.Job_Skill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

//job skill mapping service method implementations
@Service
@RequestMapping("/jobsk")
public class JobSkServiceImpl implements JobSkService
{

    private static final Logger logger = LoggerFactory.getLogger(JobSkServiceImpl.class);
    @Autowired
    private JobSkDao jobskDao;

    //method for getting all skills for a job
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/lists/{id}")
    @ResponseBody
    @Override
    public List<Job_Skill> getJobSk(@PathVariable int id)
    {
        return jobskDao.getJobSk(id);
    }

   //method for adding skill for job
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping ("/add")
    @Override
    public void addJobSk(@Valid @RequestBody Job_Skill job)
    {
        jobskDao.addJobSk(job);

    }

   //method for deleting skill for job
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update")
    @Override
    public void updateJobSk(@Valid @RequestBody Job_Skill job)
    {
        jobskDao.updateJobSk(job);
    }

    //method for deleting skill for job
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteJobSk(@PathVariable int id)
    {
        jobskDao.deleteJobSk(id);
    }

}
