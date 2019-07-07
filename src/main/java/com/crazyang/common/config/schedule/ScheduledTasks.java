package com.crazyang.common.config.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

/**
 * @ClassName ScheduledTasks
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/7/6 上午11:05.
 */
@Component
public class ScheduledTasks {

    // 日志
    private Logger log = LoggerFactory.getLogger(this.getClass());

    private int fixedDelayCount = 1;

    /**
     *
     * @Title: testFixDelay
     * @Description:表示上一次任务执行完成后多久再次执行，参数类型为long，单位ms;
     */
    @Scheduled(fixedDelay = 5000)
    public void testFixDelay() {
        log.info(MessageFormat.format("fixedDelay()第{0}次执行", fixedDelayCount++));
    }

    public static void main(String[] args) {
        ScheduledTasks  ss = new ScheduledTasks();
        ss.testFixDelay();
    }

}
