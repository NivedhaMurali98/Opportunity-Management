package com.jackrutorial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//main application
@SpringBootApplication
public class BackendApplication
{
	private static Logger logger = LoggerFactory.getLogger(BackendApplication.class);
	public static void main(String[] args)
	{
		SpringApplication.run(BackendApplication.class, args);
	}
}
