package configComponentScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/*@Configuration
@ComponentScan(
basePackages = {"configComponentScan.board.dao", "configComponentScan.board.service"}
,useDefaultFilters = false
,includeFilters= {@Filter(Repository.class)}
,excludeFilters= {@Filter(Service.class)})*/

@Configuration
@ComponentScan(
basePackages = {"configComponentScan.board.dao", "configComponentScan.board.service"} ,useDefaultFilters = true)
@PropertySource({"classpath:/placeHolder/db.properties"})
public class ApplicationConfig {
	@Autowired
	private Environment env;
	
}