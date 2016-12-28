package personal.chencs.learn.service;

import java.io.FileNotFoundException;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.util.Log4jConfigurer;

@SuppressWarnings("deprecation")
@ContextConfiguration(locations= {"classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})
public class BasicTest extends AbstractTransactionalJUnit4SpringContextTests {

	static {
		try {
			Log4jConfigurer.initLogging("classpath:properties/log4j.properties");
		} catch (FileNotFoundException ex) {
			System.err.println("Cannot Initialize log4j");
		}
	}
}
