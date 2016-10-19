package com.gieey.boot.quartz.job;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

/**
 * @author gieey
 */
@Service
public class MyScheduler {

    @Autowired
    public SchedulerFactoryBean schedulerFactoryBean;

    public void scheduleJob() throws SchedulerException {

        Scheduler scheduler = schedulerFactoryBean.getScheduler();

        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("job", "group").build();

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                .cronSchedule("*/5 * * * * ?");

        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger", "group")
                .withSchedule(scheduleBuilder).build();

        scheduler.scheduleJob(jobDetail, trigger);
    }
}
