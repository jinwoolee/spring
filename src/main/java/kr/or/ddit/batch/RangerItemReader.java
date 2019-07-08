package kr.or.ddit.batch;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class RangerItemReader implements ItemReader<String>{
	
	private static final Logger logger = LoggerFactory.getLogger(RangerItemReader.class);

	private List<String> rangers;
	private int index = 0;
	
	public RangerItemReader() {
		rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		rangers.add("james");
		rangers.add("moon");
	}
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// null을 리턴하게 되면 더이상 읽을 데이터가 없다고 판단
		if(index <= rangers.size()-1) {
			String ranger = rangers.get(index++);
			logger.debug("reader : {}", ranger);
			return ranger;
		}
		else {
			index = 0;
			return null;
		}
	
	}

}






