package com.jackrutorial.services;
import com.jackrutorial.dao.ChartDao;
import com.jackrutorial.dao.ChartDaoImpl;
import com.jackrutorial.dao.JobLocDaoImpl;
import com.jackrutorial.models.Job_Location;
import com.jackrutorial.models.chart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

//chart service method implementations
@Service
@RequestMapping("/chart")
public class ChartServiceImpl  implements  ChartService
{

    private static final Logger logger = LoggerFactory.getLogger(ChartServiceImpl.class);
    @Autowired
    private ChartDao ch;

    //method to get list of skills and count
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/lists")
    @ResponseBody
    @Override
    public List<chart> getSkCount()
    {
        return ch.getSkCount();

    }

    //method to get location and their count
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/listsloc")
    @ResponseBody
    @Override
    public List<chart> getLocCount()
    {
        return ch.getLocCount();
    }

    //method to get manager and their job rate
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/listshm")
    @ResponseBody
    @Override
    public List<chart> getHmCount()
    {
        return ch.getHmCount();
    }

}
