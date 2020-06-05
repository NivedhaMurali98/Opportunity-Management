package com.jackrutorial.dao;

import com.jackrutorial.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//class containing the user dao methods implementation
@Transactional
@Repository
public class UserDaoImpl implements UserDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUserByEmail (String email)
    {
        String query = "SELECT * FROM user WHERE email = ?";
        RowMapper<User> rowMapper = new userRowMapper();
        User user = jdbcTemplate.queryForObject(query, rowMapper,email);
        return user;
    }

}
