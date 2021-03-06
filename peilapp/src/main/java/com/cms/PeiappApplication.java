package com.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import com.cms.core.BasePathExposer;


@MapperScan("com.cms.mapper")
@SpringBootApplication
@ImportResource(locations={"classpath:mykaptcha.xml"})//第二种配置的方式,可以加入xml的配置方式  
public class PeiappApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeiappApplication.class, args);
	}
	
	@Bean(initMethod=("init"))
	public BasePathExposer getBasePathExposer() {
		return new BasePathExposer();
	}
}










