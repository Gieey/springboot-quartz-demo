package com.gieey.boot.quartz.config;

import com.gieey.boot.quartz.factory.AutowiringSpringBeanJobFactory;
import com.gieey.boot.quartz.job.MyScheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;

/**
 * @author china_
 *
 * quartz config
 */
@Configuration
public class SchedulerConfig implements ApplicationListener<ContextRefreshedEvent> {


        @Autowired
        private MyScheduler myScheduler;

        private static final Logger logger = LoggerFactory.getLogger(SchedulerConfig.class);

        @Override
        public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
            try {
                logger.info("开始监听");
                myScheduler.scheduleJob();
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
}
