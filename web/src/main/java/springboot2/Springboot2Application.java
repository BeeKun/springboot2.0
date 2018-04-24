package springboot2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot启动类,需要配置MapperScan否则会报错
 * @author likun
 * @date 2018-04-24
 */
@SpringBootApplication
@MapperScan("springboot2.repository")
public class Springboot2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2Application.class, args);
	}
}
