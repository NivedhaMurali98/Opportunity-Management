package com.jackrutorial.dao;
import com.jackrutorial.models.Job;
import com.jackrutorial.models.Skillset;
import com.jackrutorial.services.JobServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
public class JobDaoImpltest {


    @InjectMocks
    private JobDaoImpl jobDao;
    @Mock
    private JdbcTemplate jdbc;

    @Test
    public void getalljobstest()
    {
        Job s1 = new Job();
        s1.setJobid(2);
        s1.setDatemod("12/03/20");
        s1.setCreaterid(1);
        s1.setOpenings(2);
        s1.setIsactive("true");
        s1.setDescription("minimum two years of experience");
        s1.setEmptype("internship");
        s1.setUpdatorid(2);
        List<Job> j=new ArrayList<Job>();
        j.add(s1);
        Mockito.when(jdbc.query(ArgumentMatchers.anyString(), ArgumentMatchers.any(RowMapper.class))).thenReturn(j);
        List<Job>  list = jobDao.getAllJobs();
        assertEquals(1,list.size());
    }
    @Test
    public void findjobbyidtest()
    {
        Job s1 = new Job();
        s1.setJobid(2);
        s1.setDatemod("12/03/20");
        s1.setCreaterid(1);
        s1.setOpenings(2);
        s1.setIsactive("true");
        s1.setDescription("minimum two years of experience");
        s1.setEmptype("internship");
        s1.setUpdatorid(2);

        Mockito.when(jdbc.queryForObject(ArgumentMatchers.anyString(), ArgumentMatchers.any(RowMapper.class),ArgumentMatchers.anyInt())).thenReturn(s1);
        Job  list = jobDao.findJobById(2);
        assertEquals("12/03/20",list.datemod);
    }
    @Test
    public void addJobTest()
    {
        Job s1 = new Job();
        s1.setJobid(2);
        s1.setDatemod("12/03/20");
        s1.setCreaterid(1);
        s1.setOpenings(2);
        s1.setIsactive("true");
        s1.setDescription("minimum two years of experience");
        s1.setEmptype("internship");
        s1.setUpdatorid(2);

       Mockito.when(jdbc.update(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
                       ArgumentMatchers.anyString(),ArgumentMatchers.anyInt(),ArgumentMatchers.anyInt(),ArgumentMatchers.anyInt(),
               ArgumentMatchers.anyString())).thenReturn(1);

        jobDao.addJob(s1);
        verify(jdbc,times(1)).update
                (ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
                        ArgumentMatchers.anyString(),ArgumentMatchers.anyInt(),ArgumentMatchers.anyInt(),ArgumentMatchers.anyInt(),
                        ArgumentMatchers.anyString());


    }
    @Test
    public void updateJobTest()
    {
        Job job1 = new Job();
        job1.setJobid(2);
        job1.setDatemod("12/03/20");
        job1.setCreaterid(1);
        job1.setOpenings(2);
        job1.setIsactive("true");
        job1.setDescription("minimum two years of experience");
        job1.setEmptype("internship");
        job1.setUpdatorid(2);

        Mockito.when(jdbc.update(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
                ArgumentMatchers.anyString(),ArgumentMatchers.anyInt(),ArgumentMatchers.anyInt(),ArgumentMatchers.anyInt(),
                ArgumentMatchers.anyString(),ArgumentMatchers.anyInt())).thenReturn(1);

        jobDao.updateJob(job1);
        verify(jdbc,times(1)).update
                (ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
                        ArgumentMatchers.anyString(),ArgumentMatchers.anyInt(),ArgumentMatchers.anyInt(),ArgumentMatchers.anyInt(),
                        ArgumentMatchers.anyString(),ArgumentMatchers.anyInt());


    }

    @Test
    public void deleteJobTest()
    {
        Mockito.when(jdbc.update(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt())).thenReturn(1);
        jobDao.deleteJob(1);
        verify(jdbc,times(1)).update(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt());
    }
}
