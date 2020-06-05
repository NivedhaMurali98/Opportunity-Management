package com.jackrutorial.dao;
import com.jackrutorial.models.Job;
import com.jackrutorial.models.Job_Location;
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
public class JobLocDaoImplTest {

    @InjectMocks
    private JobLocDaoImpl jobLocDao;
    @Mock
    private JdbcTemplate jdbc;


    @Test
    public void getJobLocTest()
    {
        Job_Location job_location=new Job_Location();
        job_location.setLoc("chennai");
        job_location.setJobid(1);
        List<Job_Location> jobLocationList=new ArrayList<Job_Location>() ;
        jobLocationList.add(job_location);

        Mockito.when(jdbc.query(ArgumentMatchers.anyString(), ArgumentMatchers.any(RowMapper.class),ArgumentMatchers.anyInt())).thenReturn(jobLocationList);
        List<Job_Location> jobLocList1 = jobLocDao.getJobLoc(1);
        assertEquals(1,jobLocList1.size());
    }

    @Test
    public void addJobLocTest()
    {
        Job_Location job_location=new Job_Location();
        job_location.setLoc("chennai");
        job_location.setJobid(1);

        Mockito.when(jdbc.update(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString())).thenReturn(1);

        jobLocDao.addJobLoc(job_location);
        verify(jdbc,times(1)).update
                (ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString());

    }

    @Test
    public void updateJobLocTest()
    {
        Job_Location job_location=new Job_Location();
        job_location.setLoc("chennai");
        job_location.setJobid(1);

        Mockito.when(jdbc.update(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString(),ArgumentMatchers.anyInt())).thenReturn(1);

        jobLocDao.updateJobLoc(job_location);
        verify(jdbc,times(1)).update
                (ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString(),ArgumentMatchers.anyInt());

    }

    @Test
    public void deleteJobLocTest()
    {
        Mockito.when(jdbc.update(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt())).thenReturn(1);

        jobLocDao.deleteJobLoc(1);
        verify(jdbc,times(1)).update
                (ArgumentMatchers.anyString(), ArgumentMatchers.anyInt());

    }

}
