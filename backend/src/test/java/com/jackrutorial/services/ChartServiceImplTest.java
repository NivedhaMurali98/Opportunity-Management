package com.jackrutorial.services;

import com.jackrutorial.dao.ChartDao;
import com.jackrutorial.dao.JobDao;
import com.jackrutorial.models.Job;
import com.jackrutorial.models.chart;
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

@RunWith(SpringJUnit4ClassRunner.class)
public class ChartServiceImplTest {

    @InjectMocks
    private ChartServiceImpl  chartService;

    @Mock
    private ChartDao chartDao;


    @Test
    public void getLocCountTest()
    {
        chart location =new chart();
        location.setCount(2);
        location.setTitle("chennai");
        List<chart> locationList =new ArrayList<chart>();
        locationList.add(location);
        Mockito.when(chartService.getLocCount()).thenReturn(locationList);
        List<chart> locList = chartService.getLocCount();
        assertEquals(1,locList.size());

    }

    @Test
    public void getSkCountTest()
    {
        chart skill =new chart();
        skill.setCount(2);
        skill.setTitle("java");
        List<chart> skillList =new ArrayList<chart>();
        skillList.add(skill);
        Mockito.when(chartService.getSkCount()).thenReturn(skillList);
        List<chart> skList = chartService.getSkCount();
        assertEquals(1,skList.size());

    }
    @Test
    public void getHmCountTest()
    {
        chart hiringManager =new chart();
        hiringManager.setCount(2);
        hiringManager.setTitle("ajay");
        List<chart> managerList =new ArrayList<chart>();
        managerList.add(hiringManager);
        Mockito.when(chartService.getHmCount()).thenReturn(managerList);
        List<chart> hmList = chartService.getHmCount();
        assertEquals(1,hmList.size());

    }
}
