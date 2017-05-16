package personal.chencs.learn.service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * @author chencs
 * 通过@EnableScheduling注解开启对计划任务的支持
 */
@Component
@EnableScheduling 
public class TimerTaskService {
	// 定时器的任务方法不能有返回值
	@Scheduled(cron = "0/5 * * * * ? ")//隔5秒执行一次
	public void taskA() {
		System.out.println(new Date() + ":taskA");
	}

	@Scheduled(cron = "0/10 * * * * ? ")//隔10秒执行一次
	public void taskB() {
		try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(new Date() + ":taskB");
	}

}
