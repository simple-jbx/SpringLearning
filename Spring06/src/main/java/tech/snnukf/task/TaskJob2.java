package tech.snnukf.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务
 *
 * @className: TaskJob
 * @author: simple.jbx
 * @date: 2022/9/18
 **/
@Component
public class TaskJob2 {
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Scheduled(cron = "0/2 * * * * ?")
    public void job1() {
        System.out.println("TaskJob2 task1:" + df.format(new Date()));
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void job2() {
        System.out.println("TaskJob2 task2:" + df.format(new Date()));
    }
}
