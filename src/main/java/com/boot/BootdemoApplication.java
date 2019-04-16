package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@MapperScan(basePackages="com.boot.dao")等价于@Mapperer
@EnableTransactionManagement//开启事务支持
@ServletComponentScan(basePackages={"com.boot.intercept.servlet","com.boot.intercept.filter"})
public class BootdemoApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(BootdemoApplication.class, args);
	}
}
