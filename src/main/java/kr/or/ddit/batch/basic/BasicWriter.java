package kr.or.ddit.batch.basic;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

public class BasicWriter implements ItemWriter<String>{
	
	private static final Logger logger = LoggerFactory.getLogger(BasicWriter.class);
	
	@Override
	public void write(List<? extends String> items) throws Exception {
		logger.debug("======writre=====");
		logger.debug("items : {}", items);
		logger.debug("======writre=====");
	}

}
