package kr.or.ddit.batch;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import kr.or.ddit.batch.service.IBatchService;

public class YogultTask {
	
	private static final Logger logger = LoggerFactory.getLogger(YogultTask.class);
	
	@Resource(name="batchService")
	private IBatchService batchService;
	
	//매월 1일 새벽1시 실행
	public void yogultTask(){
		logger.debug("=================yogultTask=================");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		batchService.createDaily(sdf.format(new Date()));
	}
}









