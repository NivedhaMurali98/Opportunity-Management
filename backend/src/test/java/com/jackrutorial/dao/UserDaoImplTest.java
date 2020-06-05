package com.jackrutorial.dao;
import com.jackrutorial.models.Job;
import com.jackrutorial.models.Skillset;
import com.jackrutorial.models.User;
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
public class UserDaoImplTest {

    @InjectMocks
    private UserDaoImpl userDao;
    @Mock
    private JdbcTemplate jdbc;

    @Test
    public void getUserByEmailTest()
    {
        User user=new User();
        user.setRole("admin");
        user.setName("nivedha");
        user.setEmail("niv@gmail.com");
        user.setId(23);
        Mockito.when(jdbc.queryForObject(ArgumentMatchers.anyString(), ArgumentMatchers.any(RowMapper.class),ArgumentMatchers.anyString())).thenReturn(user);
        User list = userDao.getUserByEmail("niv@gmail.com");
        assertEquals("nivedha",list.name);
    }
}
