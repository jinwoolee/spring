package kr.or.ddit.batch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;

import kr.or.ddit.yogult.model.CycleVo;
import kr.or.ddit.yogult.model.DailyVo;

public class YogultItemProcessor implements ItemProcessor<CycleVo, List<DailyVo>>{

	private static final Logger logger = LoggerFactory.getLogger(YogultItemProcessor.class);
	
	@Value("#{jobParameters[ym]}")
	private String ym;
	
	@Override
	public List<DailyVo> process(CycleVo cycleVo) throws Exception {
		//ym : 201907
		// input : cid: 1	pid: 100	 day:2	cnt:1
		// output : cid: 1	pid: 100	 day:20190701	cnt:1
		//				cid: 1	pid: 100	 day:20190708	cnt:1
		//				cid: 1	pid: 100	 day:20190715	cnt:1
		//				cid: 1	pid: 100	 day:20190722	cnt:1
		//				cid: 1	pid: 100	 day:20190729	cnt:1
		
		SimpleDateFormat ym_format = new SimpleDateFormat("yyyyMM");
		Calendar cal = Calendar.getInstance();
		
		//cal : 20190701
		cal.setTime(ym_format.parse(ym));
		
		//cal : 20190731
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date ed_dt = cal.getTime();
		
		//cal : 20190701
		cal.setTime(ym_format.parse(ym));
		
		SimpleDateFormat ymd = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat day =new SimpleDateFormat("");
		
		List<DailyVo> dailyVoList = new ArrayList<DailyVo>();
				
		//cal : 1-31순차적으로 증가, ed_dt클때까지
		while(ed_dt.getTime() >= cal.getTimeInMillis()) {
			//요일이 같을 때만 dailyVo로 생성
			//ex : cycleVo.getDay() : 2(월) --> 20190701, 20190708, 20190715, 20190722, 20190729
			if(cal.get(Calendar.DAY_OF_WEEK) == cycleVo.getDay()) {
				DailyVo vo = new DailyVo();
				vo.setCid(cycleVo.getCid());
				vo.setPid(cycleVo.getPid());
				vo.setDt(ymd.format(cal.getTime()));
				vo.setCnt(cycleVo.getCnt());
				dailyVoList.add(vo);
			}
			
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		logger.debug("dailyVoList : {}", dailyVoList );
		
		return dailyVoList;
	}

}







