package com.jackrutorial.services;

import com.jackrutorial.dao.JobDao;
import com.jackrutorial.dao.UserDao;
import com.jackrutorial.models.Job;
import com.jackrutorial.models.User;
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
public class UserServiceImplTest {



    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserDao user1;


    @Test
    public void getUserByEmail()
    {
        User user=new User();
        user.setRole("admin");
        user.setName("nivedha");
        user.setEmail("niv@gmail.com");
        user.setId(23);


        Mockito.when(user1.getUserByEmail(ArgumentMatchers.anyString())).thenReturn(user);
        User user2 = userService.getUserByEmail("niv@gmail.com");
        assertEquals("nivedha",user2.name);
    }
}
