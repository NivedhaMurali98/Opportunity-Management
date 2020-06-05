package com.jackrutorial.dao;
import com.jackrutorial.models.Job;
import com.jackrutorial.models.Job_Location;
import com.jackrutorial.models.Job_Skill;
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
public class JobSkDaoImplTest
{

    @InjectMocks
    private JobSkDaoImpl jobSkDao;
    @Mock
    private JdbcTemplate jdbc;


    @Test
    public void getJobSkTest()
    {
        Job_Skill job_skill=new Job_Skill();
        job_skill.setSkill("python");
        job_skill.setJobid(1);
        List<Job_Skill> jobSkillList=new ArrayList<Job_Skill>() ;
        jobSkillList.add(job_skill);

        Mockito.when(jdbc.query(ArgumentMatchers.anyString(), ArgumentMatchers.any(RowMapper.class),ArgumentMatchers.anyInt())).thenReturn(jobSkillList);
        List<Job_Skill> jobSkList1 = jobSkDao.getJobSk(1);
        assertEquals(1,jobSkList1.size());
    }
    @Test
    public void addJobSkTest()
    {
        Job_Skill job_skill=new Job_Skill();
        job_skill.setSkill("python");
        job_skill.setJobid(1);
        Mockito.when(jdbc.update(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString())).thenReturn(1);

        jobSkDao.addJobSk(job_skill);
        verify(jdbc,times(1)).update
                (ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString());


    }
    @Test
    public void updateJobSkTest()
    {
        Job_Skill job_skill=new Job_Skill();
        job_skill.setSkill("python");
        job_skill.setJobid(1);
        Mockito.when(jdbc.update(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString(),ArgumentMatchers.anyInt())).thenReturn(1);
        jobSkDao.updateJobSk(job_skill);
        verify(jdbc,times(1)).update
                (ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString(),ArgumentMatchers.anyInt());


    }
    @Test
    public void deleteJobSkTest()
    {
        Mockito.when(jdbc.update(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt())).thenReturn(1);
        jobSkDao.deleteJobSk(1);
        verify(jdbc,times(1)).update
                (ArgumentMatchers.anyString(), ArgumentMatchers.anyInt());


    }




}
