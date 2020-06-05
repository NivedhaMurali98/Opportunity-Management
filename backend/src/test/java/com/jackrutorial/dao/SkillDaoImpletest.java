package com.jackrutorial.dao;

import com.jackrutorial.dao.SkillDaoImpl;
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
public class SkillDaoImpletest
{

    @InjectMocks
    private SkillDaoImpl skillDao;

    @Mock
    private JdbcTemplate jdbc;

    @Test
    public void getallskillstest()
    {
        Skillset s1 = new Skillset();
        s1.setSkid(2);
        s1.setTitle("python");
        Skillset s2 = new Skillset();
        s2.setSkid(3);
        s2.setTitle("java");
        List<Skillset> sk= new ArrayList<Skillset>();
        sk.add(s1);
        sk.add(s2);
        Mockito.when(jdbc.query(ArgumentMatchers.anyString(), ArgumentMatchers.any(RowMapper.class))).thenReturn(sk);
        List<Skillset>  list = skillDao.getAllSkills();
        assertEquals(2,list.size());
    }
    @Test
    public void findskillbyidtest()
    {
        Skillset s = new Skillset();
        s.setSkid(2);
        s.setTitle("python");
        Mockito.when(jdbc.queryForObject(ArgumentMatchers.anyString(), ArgumentMatchers.any(RowMapper.class), ArgumentMatchers.anyInt())).thenReturn(s);
        Skillset list = skillDao.findSkillById(2);
        assertEquals("python",list.title);
    }


}
