package kr.or.ddit.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class RangerItemProcessor implements ItemProcessor<String, String>{
	
	private static final Logger logger = LoggerFactory.getLogger(RangerItemProcessor.class);
	
	@Override
	public String process(String item) throws Exception {
		String itemProcessed = item + "_modified";
		
		logger.debug("input : {} / output : {}", item, itemProcessed );
		return itemProcessed;
	}

}
