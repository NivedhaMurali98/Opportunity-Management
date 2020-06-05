package com.jackrutorial.services;


import com.jackrutorial.dao.JobLocDao;
import com.jackrutorial.dao.UserDao;
import com.jackrutorial.dao.UserService;
import com.jackrutorial.models.Job;
import com.jackrutorial.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RequestMapping("/user")
public class UserServiceImpl  implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path="/get/{email}")
    @ResponseBody
    public User getUserByEmail(@PathVariable String email)
    {
        return userDao.getUserByEmail(email);
    }

}
