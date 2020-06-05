package com.jackrutorial.dao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.jackrutorial.models.*;

//class containing the skills dao methods implementation
@Transactional
@Repository
public class SkillDaoImpl implements SkillDao
{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //method for getting all skills
    @Override
    public List<Skillset> getAllSkills()
    {
        String query = "SELECT * from skillsets";
        RowMapper<Skillset> rowMapper = new skillsetrowmapper();
        List<Skillset>  list = jdbcTemplate.query(query, rowMapper);
        return list;
    }

    //method for getting skill by id
    @Override
    public Skillset findSkillById(int id)
    {
        String query = "SELECT * FROM skillsets WHERE id = ?";
        RowMapper<Skillset> rowMapper = new BeanPropertyRowMapper<Skillset>(Skillset.class);
        Skillset skills = jdbcTemplate.queryForObject(query, rowMapper, id);
        return skills;

    }

}
