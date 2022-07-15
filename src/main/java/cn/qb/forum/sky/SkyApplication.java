package cn.qb.forum.sky;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.qb.forum.sky.mapper")
public class SkyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkyApplication.class, args);
	}

}
