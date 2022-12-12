package tech.snnukf.task;

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
public class TaskJob {
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public void job1() {
        System.out.println("task1:" + df.format(new Date()));
    }

    public void job2() {
        System.out.println("task2:" + df.format(new Date()));
    }
}
