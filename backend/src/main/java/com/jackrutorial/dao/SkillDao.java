

package com.jackrutorial.dao;
import com.jackrutorial.models.*;
import java.util.List;

//dao interface for accesing the skills enity data from db
public interface SkillDao
{
    public List<Skillset> getAllSkills();
    public Skillset findSkillById(int id);
}

