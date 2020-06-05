package com.jackrutorial.models;

//POJO  representing job and its locations mapping
public class Job_Location
{
    private Integer jobid;
    private String  loc;
    public Integer getJobid()
    {
        return jobid;
    }
    public void setJobid(Integer jobid)
    {
        this.jobid = jobid;
    }
    public String getLoc()
    {
        return loc;
    }
    public void setLoc(String loc)
    {
        this.loc = loc;
    }
    @Override
    public String toString()
    {
        return "Job_Location{" +
                "jobid=" + jobid +
                ", loc='" + loc + '\'' +
                '}';
    }


}
