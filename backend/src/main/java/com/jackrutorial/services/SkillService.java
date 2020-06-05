package com.jackrutorial.services;
import com.jackrutorial.models.*;
import java.util.List;

//skills service interface
public interface SkillService
{
    public List<Skillset> getAllSkills();
    public Skillset findSkillById(int id);

}

