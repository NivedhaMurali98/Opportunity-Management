package com.jackrutorial.services;


import com.jackrutorial.dao.JobDao;
import com.jackrutorial.models.Job;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
public class JobServiceImplTest
{



    @InjectMocks
    private JobServiceImpl jobService;

    @Mock
    private JobDao jd;

    @Test
    public void getalljobstest()
    {
        Job job1= new Job();
        job1.setJobid(2);
        job1.setDatemod("12/03/20");
        job1.setCreaterid(1);
        job1.setOpenings(2);
        job1.setIsactive("true");
        job1.setDescription("minimum two years of experience");
        job1.setEmptype("internship");
        job1.setUpdatorid(2);
        List<Job> jobList=new ArrayList<Job>();
        jobList.add(job1);
        Mockito.when(jd.getAllJobs()).thenReturn(jobList);
        List<Job> j = jobService.getAllJobs();
        assertEquals(1,j.size());
    }

    @Test
    public void findJobByIdTest()
    {
        Job job1= new Job();
        job1.setJobid(2);
        job1.setDatemod("12/03/20");
        job1.setCreaterid(1);
        job1.setOpenings(2);
        job1.setIsactive("true");
        job1.setDescription("minimum two years of experience");
        job1.setEmptype("internship");
        job1.setUpdatorid(2);
        Mockito.when(jd.findJobById(ArgumentMatchers.anyInt())).thenReturn(job1);
        Job job2 = jobService.findJobById(1);
        assertEquals("12/03/20",job2.datemod);
    }
    @Test
    public void addJobTest()
    {
        Job job1= new Job();
        job1.setJobid(2);
        job1.setDatemod("12/03/20");
        job1.setCreaterid(1);
        job1.setOpenings(2);
        job1.setIsactive("true");
        job1.setDescription("minimum two years of experience");
        job1.setEmptype("internship");
        job1.setUpdatorid(2);
        Mockito.doNothing().when(jd).addJob(ArgumentMatchers.any(Job.class));
        jobService.addJob(job1);
        verify(jd,times(1)).addJob(ArgumentMatchers.any(Job.class));

    }
    @Test
    public void updateJobTest()
    {
        Job job1= new Job();
        job1.setJobid(2);
        job1.setDatemod("12/03/20");
        job1.setCreaterid(1);
        job1.setOpenings(2);
        job1.setIsactive("true");
        job1.setDescription("minimum two years of experience");
        job1.setEmptype("internship");
        job1.setUpdatorid(2);
        Mockito.doNothing().when(jd).updateJob(ArgumentMatchers.any(Job.class));
        jobService.updateJob(job1);
        verify(jd,times(1)).updateJob(ArgumentMatchers.any(Job.class));
    }

    @Test
    public void deleteJobTest()
    {

        Mockito.doNothing().when(jd).deleteJob(ArgumentMatchers.anyInt());
        jobService.deleteJob(1);
        verify(jd,times(1)).deleteJob(ArgumentMatchers.anyInt());

    }



}

