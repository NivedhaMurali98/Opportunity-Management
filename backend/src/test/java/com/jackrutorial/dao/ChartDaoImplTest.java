package com.jackrutorial.dao;
import com.jackrutorial.models.Skillset;
import com.jackrutorial.models.chart;
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
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)

public class ChartDaoImplTest {

    @InjectMocks
    private ChartDaoImpl chartDao;

    @Mock
    private JdbcTemplate jdbc;

    private void regMock()
    {
        doAnswer(invocation -> {
            Object arg0 = invocation.getArgument(0);
            chart skill1 = new chart();
            skill1.setCount(2);
            skill1.setTitle("python");
            chart hiringManager1 = new chart();
            skill1.setCount(2);
            skill1.setTitle("Ajay");
            chart location1 = new chart();
            location1.setCount(2);
            location1.setTitle("chennai");
            List<chart> skills=new ArrayList<chart>();
            List<chart> locations=new ArrayList<chart>();
            List<chart> hiringManager=new ArrayList<chart>();
            hiringManager.add(hiringManager1);
            skills.add(skill1);
            locations.add(location1);
            String arg=(String)arg0;
            if(arg.equals("SELECT skills ,count(*) as count from project1.job_skillsets group by skills"))
            {
                return skills;
            }
            if(arg.equals("SELECT location ,count(*) as count from project1.job_locations group by location"))
            {
                return locations;
            }
            if(arg.equals("SELECT user.name as location ,count(*) as count FROM job INNER JOIN user ON job.creator_id=user.id group by job.creator_id"))
            {
                return hiringManager;
            }
            return null;
        }).when(jdbc).query(ArgumentMatchers.anyString(), ArgumentMatchers.any(RowMapper.class));
    }

    @Test
    public void getSkCountTest()
    {
        regMock();

        List<chart>  list = chartDao.getSkCount();
        assertEquals(1,list.size());

    }

    @Test
    public void getLocCountTest()
    {
        regMock();

        List<chart>  list = chartDao.getLocCount();
        assertEquals(1,list.size());
    }

    @Test
    public void getHmCountTest()
    {
        regMock();

        List<chart>  list = chartDao.getHmCount();
        assertEquals(1,list.size());
    }

}
