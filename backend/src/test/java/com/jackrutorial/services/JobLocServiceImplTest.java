package com.jackrutorial.services;


import com.jackrutorial.dao.JobDao;
import com.jackrutorial.dao.JobLocDao;
import com.jackrutorial.models.Job;
import com.jackrutorial.models.Job_Location;
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
public class JobLocServiceImplTest {


    @InjectMocks
    private JobLocServiceImpl jobLocService;

    @Mock
    private JobLocDao jobLocDao;


    @Test
    public void getJobLocTest()
    {
        Job_Location jobLoc1 = new Job_Location();
        jobLoc1.setJobid(1);
        jobLoc1.setLoc("chennai");
        List<Job_Location> jobLocList = new ArrayList<Job_Location>();
        jobLocList.add(jobLoc1);
        Mockito.when(jobLocDao.getJobLoc(ArgumentMatchers.anyInt())).thenReturn(jobLocList);
        List<Job_Location> jobLocList1 = jobLocService.getJobLoc(1);
        assertEquals(1, jobLocList1.size());
    }
    @Test
    public void addJobLocTest()
    {
        Job_Location jobLoc1 = new Job_Location();
        jobLoc1.setJobid(1);
        jobLoc1.setLoc("chennai");
        Mockito.doNothing().when(jobLocDao).addJobLoc(ArgumentMatchers.any(Job_Location.class));
        jobLocService.addJobLoc(jobLoc1);
        verify(jobLocDao,times(1)).addJobLoc(ArgumentMatchers.any(Job_Location.class));


    }
    @Test
    public void updateJobLocTest()
    {
        Job_Location jobLoc1 = new Job_Location();
        jobLoc1.setJobid(1);
        jobLoc1.setLoc("chennai");
        Mockito.doNothing().when(jobLocDao).updateJobLoc(ArgumentMatchers.any(Job_Location.class));
        jobLocService.updateJobLoc(jobLoc1);
        verify(jobLocDao,times(1)).updateJobLoc(ArgumentMatchers.any(Job_Location.class));

    }
    @Test
    public void deleteJobLocTest()
    {

        Mockito.doNothing().when(jobLocDao).deleteJobLoc(ArgumentMatchers.anyInt());
        jobLocService.deleteJobLoc(1);
        verify(jobLocDao,times(1)).deleteJobLoc(ArgumentMatchers.anyInt());

    }
}

