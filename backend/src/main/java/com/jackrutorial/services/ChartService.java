package com.jackrutorial.services;
import com.jackrutorial.models.Job;
import com.jackrutorial.models.chart;
import java.util.List;

//chart service interface
public interface ChartService
{
    public List<chart> getSkCount();
    public List<chart> getLocCount();
    public List<chart> getHmCount();
}
