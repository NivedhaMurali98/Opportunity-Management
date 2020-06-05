package com.jackrutorial.dao;

import com.jackrutorial.models.User;
import com.jackrutorial.models.chart;

import java.util.List;

//dao interface for accesing the users  data from db
public interface UserDao {

        public User getUserByEmail(String email);



}
