package com.jackrutorial.dao;

import com.jackrutorial.dao.SkillDaoImpl;
import com.jackrutorial.models.Location;
import com.jackrutorial.models.Skillset;
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

@RunWith(SpringJUnit4ClassRunner.class)
public class LocationDaoImplTest
{

    @InjectMocks
    private LocationDaoImpl locDao;

    @Mock
    private JdbcTemplate jdbc;

    @Test
    public void getAllLocationTest()
    {
        Location s1 = new Location();
        s1.setLocid(2);
        s1.setTitle("chennai");
        Location s2 = new Location();
        s2.setLocid(3);
        s2.setTitle("banglore");
        List<Location> sk= new ArrayList<Location>();
        sk.add(s1);
        sk.add(s2);
        Mockito.when(jdbc.query(ArgumentMatchers.anyString(), ArgumentMatchers.any(RowMapper.class))).thenReturn(sk);
        List<Location>  list = locDao.getAllLocations();
        assertEquals(2,list.size());
    }
    @Test
    public void findLocationByIdTest()
    {
        Location s = new Location();
        s.setLocid(2);
        s.setTitle("chennai");
        Mockito.when(jdbc.queryForObject(ArgumentMatchers.anyString(), ArgumentMatchers.any(RowMapper.class), ArgumentMatchers.anyInt())).thenReturn(s);
        Location list = locDao.findLocationById(2);
        assertEquals("chennai",list.title);
    }


}
