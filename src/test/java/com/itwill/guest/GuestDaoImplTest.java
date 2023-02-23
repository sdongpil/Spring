package com.itwill.guest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.guest.dao.jdbctemplate.Guest;
import com.itwill.guest.dao.jdbctemplate.GuestDao;
@SpringBootApplication
@SpringBootTest
class GuestDaoImplTest {

	@Autowired
	GuestDao guestDao;
	
	@Disabled
	@Test
	void testSelectAll() throws Exception {
		assertNotEquals(guestDao.selectAll(), null);
		assertNotEquals(guestDao.selectAll().size(), 0);
		System.out.println(guestDao.selectAll().size());
		System.out.println(guestDao.selectAll());
		
	}
	
	@Disabled
	@Test
	void testInsertGuest() throws Exception{
		Guest insertGuest=
				new Guest(0, "테스트", null,"test@gmail.com", "test.com", "타이틀", "컨텐트");
		assertEquals(guestDao.insertGuest(insertGuest), 1);
	}
	
	@Test
	void testUpdateGuest() throws Exception{
		Guest updateGuest=
				new Guest(263, "테스트수정", null,"testchange@gmail.com",
						"testchange.com", "타이틀수정", "컨텐트수정");
		int updateRowCount=guestDao.updateGuest(updateGuest);
		if(updateRowCount==1) {
			fail("update 실패");
		}
	}
	
	
	
	

}