package com.startboot.dev;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration
public class DemoApplication{

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(DemoApplication.class);
		long start,end;
		start = System.currentTimeMillis();
		SpringApplication.run(DemoApplication.class, args);
		end = System.currentTimeMillis();
		logger.info(" - - - - Run Time："+(end - start)+"(ms)"+"- - - - ");
	}

}
