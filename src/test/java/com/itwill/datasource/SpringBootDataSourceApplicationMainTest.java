package com.itwill.datasource;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringBootDataSourceApplicationMainTest {
	
	@Autowired
	DataSource dataSource ;
	
	@Test
	void testMain() {
		
	}

	@Test
	void 데이터소스테스트() throws Exception	{
		System.out.println(dataSource);
		System.out.println(dataSource.getConnection());
	}
}
