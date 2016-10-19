package com.gieey.boot.quartz.job;

import com.gieey.boot.quartz.service.ServiceSample;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author china_
 */
public class MyJob implements Job {

    @Autowired
    ServiceSample serviceSample;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        serviceSample.hello();
    }
}
