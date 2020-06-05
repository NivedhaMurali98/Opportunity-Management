package com.jackrutorial.dao;

import com.jackrutorial.models.Job;
import com.jackrutorial.models.chart;
import java.util.List;

//dao interface for accesing the chart enity data from db
public interface ChartDao
{
    public List<chart> getSkCount();
    public List<chart> getLocCount();
    public List<chart> getHmCount();
}
