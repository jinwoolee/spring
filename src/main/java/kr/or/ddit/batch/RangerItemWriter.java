package kr.or.ddit.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

public class RangerItemWriter implements ItemWriter<String>{

	private static final Logger logger = LoggerFactory.getLogger(RangerItemWriter.class);
	
	@Override
	public void write(List<? extends String> items) throws Exception {
		logger.debug("writer : {}", items);
	}

}
