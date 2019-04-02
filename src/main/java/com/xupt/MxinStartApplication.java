package com.xupt;

import com.xupt.untils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.xupt.mapper"})
public class MxinStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(MxinStartApplication.class, args);
	}
	@Bean
	public IdWorker idWorker() {
		return new IdWorker();
	}
}

