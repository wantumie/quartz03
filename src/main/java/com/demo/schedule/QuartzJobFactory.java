package com.demo.schedule;

import com.demo.common.utils.RandomUtil;
import com.demo.common.utils.TaskUtils;
import com.demo.domain.ScheduleJob;

import java.util.Map;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 *
 * @author Administrator
 * @date 2017-11-21 下午 16:04
 */
//public class QuartzJobFactory implements Job {
//    public Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Override
//    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println("定时任务运行中...");
//        ScheduleJob scheduleJob = (ScheduleJob) jobExecutionContext.getMergedJobDataMap().get("scheduleJob");
//        TaskUtils.invokeMethod(scheduleJob);
//    }
//}

public class QuartzJobFactory extends QuartzJobBean{
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        for (Map.Entry entry : jobDataMap.entrySet()){
            System.out.println("key---: " + entry.getKey() + "value---: " + entry.getValue());
            ScheduleJob scheduleJob = (ScheduleJob) entry.getValue();
            System.out.println("传递的参数为："+scheduleJob.getParams());
            int minNum = scheduleJob.getMinnum();
            int maxNum = scheduleJob.getMaxnum();
            System.out.println(minNum);
            System.out.println(maxNum);
            int randomNum = RandomUtil.randomNumber(scheduleJob.getMinnum(), scheduleJob.getMaxnum());
            
            System.out.println("产生的随机数为："+randomNum);
        }
    }
}