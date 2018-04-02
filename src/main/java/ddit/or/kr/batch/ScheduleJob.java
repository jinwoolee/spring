package ddit.or.kr.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class ScheduleJob {
	private Logger logger = LoggerFactory.getLogger(ScheduleJob.class);
	
	//cron 표기 : * * * * * *
	//초 분 시 일 월 년
	@Scheduled(cron="*/5 * * * * *")
	public void scheduleJob(){
		logger.debug("{}", "scheduleJob()");
	}
}
