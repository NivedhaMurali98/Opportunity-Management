package com.jackrutorial.services;
import com.jackrutorial.models.*;
import java.util.List;

//location service interface
public interface LocationService
{
    public List<Location> getAllLocations();
    public Location findLocationById(int id);
}

