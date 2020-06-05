package com.jackrutorial.models;

//POJO  representing a job enity
public class Job
{

    private Integer jobid;
    private String description;
    private String emptype;
    private String isactive;
    public String datemod;
    private Integer openings;
    private Integer createrid;
    private Integer updatorid;
    public Integer getJobid()
    {
        return jobid;
    }
    public void setJobid(Integer jobid)
    {
        this.jobid = jobid;
    }
    public String getDescription()
    {
        return this.description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public String getEmptype()
    {
        return this.emptype;
    }
    public void setEmptype(String emptype)
    {
        this.emptype = emptype;
    }
    public String getIsactive()
    {
        return isactive;
    }
    public void setIsactive(String isactive)
    {
        this.isactive = isactive;
    }
    public Integer getOpenings()
    {
        return openings;
    }
    public void setOpenings(Integer openings)
    {
        this.openings = openings;
    }
    public Integer getCreaterid()
    {
        return createrid;
    }

    public void setCreaterid(Integer createrid)
    {
        this.createrid = createrid;
    }
    public Integer getUpdatorid()
    {
        return updatorid;
    }
    public void setUpdatorid(Integer updatorid)
    {
        this.updatorid = updatorid;
    }
    public String getDatemod()
    {
        return datemod;
    }
    public void setDatemod(String datemod)
    {
        this.datemod = datemod;
    }


    @Override
    public String toString()
    {
        return  "Job{" +
                "jobid=" + jobid +
                ", description='" + description + '\'' +
                ", emptype='" + emptype + '\'' +
                ", isactive='" + isactive + '\'' +
                ", datemod='" + datemod + '\'' +
                ", openings=" + openings +
                ", createrid=" + createrid +
                ", updatorid=" + updatorid +
                '}';
    }



}

