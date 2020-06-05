package com.jackrutorial.services;


import com.jackrutorial.dao.JobDao;
import com.jackrutorial.dao.JobLocDao;
import com.jackrutorial.dao.JobSkDao;
import com.jackrutorial.models.Job;
import com.jackrutorial.models.Job_Location;
import com.jackrutorial.models.Job_Skill;
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
public class JobSkServiceImplTest {


    @InjectMocks
    private JobSkServiceImpl jobSkService;

    @Mock
    private JobSkDao jobSkDao;


    @Test
    public void getJobSkTest()
    {
        Job_Skill jobSk1 = new Job_Skill();
        jobSk1.setJobid(1);
        jobSk1.setSkill("python");
        List<Job_Skill> jobSkList = new ArrayList<Job_Skill>();
        jobSkList.add(jobSk1);
        Mockito.when(jobSkDao.getJobSk(ArgumentMatchers.anyInt())).thenReturn(jobSkList);
        List<Job_Skill> jobSkList1 = jobSkService.getJobSk(1);
        assertEquals(1, jobSkList1.size());
    }

    @Test
    public void addJobSkTest()
    {
        Job_Skill jobSk1 = new Job_Skill();
        jobSk1.setJobid(1);
        jobSk1.setSkill("python");
        Mockito.doNothing().when(jobSkDao).addJobSk(ArgumentMatchers.any(Job_Skill.class));
        jobSkService.addJobSk(jobSk1);
        verify(jobSkDao,times(1)).addJobSk(ArgumentMatchers.any(Job_Skill.class));
    }

    @Test
    public void updateJobSkTest()
    {
        Job_Skill jobSk1 = new Job_Skill();
        jobSk1.setJobid(1);
        jobSk1.setSkill("python");
        Mockito.doNothing().when(jobSkDao).updateJobSk(ArgumentMatchers.any(Job_Skill.class));
        jobSkService.updateJobSk(jobSk1);
        verify(jobSkDao,times(1)).updateJobSk(ArgumentMatchers.any(Job_Skill.class));

    }

    @Test
    public void deleteJobSkTest()
    {

        Mockito.doNothing().when(jobSkDao).deleteJobSk(ArgumentMatchers.anyInt());
        jobSkService.deleteJobSk(1);
        verify(jobSkDao,times(1)).deleteJobSk(ArgumentMatchers.anyInt());

    }
}

