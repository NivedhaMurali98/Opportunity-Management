package com.jackrutorial.services;
import com.jackrutorial.dao.SkillDao;
import com.jackrutorial.models.Skillset;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class SkillServiceImplTest
{
    @InjectMocks
    private SkillServiceImpl skillService;

    @Mock
    private SkillDao skillDao;

    @Test
    public void getAllSkillsTest()
    {
        Skillset skills1= new Skillset();
        skills1.setSkid(1);
        skills1.setTitle("chennai");
        List<Skillset> skillList=new ArrayList<Skillset>();
        skillList.add(skills1);
        Mockito.when(skillDao.getAllSkills()).thenReturn(skillList);
        List<Skillset> skList = skillService.getAllSkills();
        assertEquals(1,skList.size());
    }

    @Test
    public void findSkillByIdTest()
    {
        Skillset skill1= new Skillset();
        skill1.setSkid(1);
        skill1.setTitle("chennai");

        Mockito.when(skillDao.findSkillById(ArgumentMatchers.anyInt())).thenReturn(skill1);
        Skillset locList = skillService.findSkillById(1);
        assertEquals("chennai", locList.title);
    }

}
