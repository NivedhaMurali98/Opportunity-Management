package com.jackrutorial.services;

import com.jackrutorial.dao.JobDao;
import com.jackrutorial.dao.LocationDao;
import com.jackrutorial.models.Job;
import com.jackrutorial.models.Location;
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
public class LocationServiceImplTest
{
    @InjectMocks
    private LocationServiceImpl locationService;

    @Mock
    private LocationDao locationDao;

    @Test
    public void getAllLocationsTest()
    {
        Location locatiion1= new Location();
        locatiion1.setLocid(1);
        locatiion1.setTitle("chennai");
        List<Location> locationList=new ArrayList<Location>();
        locationList.add(locatiion1);
        Mockito.when(locationDao.getAllLocations()).thenReturn(locationList);
        List<Location> locList = locationService.getAllLocations();
        assertEquals(1,locList.size());
    }

    @Test
    public void findLocationByIdTest()
    {
        Location locatiion1= new Location();
        locatiion1.setLocid(1);
        locatiion1.setTitle("chennai");

        Mockito.when(locationDao.findLocationById(ArgumentMatchers.anyInt())).thenReturn(locatiion1);
        Location locList = locationService.findLocationById(1);
        assertEquals("chennai", locList.title);
    }

}
