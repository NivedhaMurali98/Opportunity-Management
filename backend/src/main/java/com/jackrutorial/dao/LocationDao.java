

package com.jackrutorial.dao;
import com.jackrutorial.models.*;
import java.util.List;

//dao interface for accesing the location enity data from db
public interface LocationDao
{
    public List<Location> getAllLocations();
    public Location findLocationById(int id);

}

