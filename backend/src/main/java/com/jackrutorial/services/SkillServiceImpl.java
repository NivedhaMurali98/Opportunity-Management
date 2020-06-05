package com.jackrutorial.services;
import com.jackrutorial.dao.*;
import com.jackrutorial.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

//skills service method implementations
@Service
@RequestMapping("/skill")
public class SkillServiceImpl implements  SkillService
{

    private static final Logger logger = LoggerFactory.getLogger(SkillServiceImpl.class);
    @Autowired
    private SkillDao skdao;

    //method for getting all skills
    @Override
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/lists")
    @ResponseBody
    public List<Skillset> getAllSkills()
    {
        return skdao.getAllSkills();
    }

    //method for getting skills by id
    @Override
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list/{id}")
    @ResponseBody
    public Skillset findSkillById(@PathVariable int id)
    {
        return skdao.findSkillById(id);
    }

}

