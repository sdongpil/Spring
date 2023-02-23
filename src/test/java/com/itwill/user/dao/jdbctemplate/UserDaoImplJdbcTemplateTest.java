package com.itwill.user.dao.jdbctemplate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootApplication
@SpringBootTest
class UserDaoImplJdbcTemplateTest {

	@Autowired
	UserDao userDao;

	@Test
	void testCreate() {
		User insertUser = new User("sond", "1234", "dp", "email");
		try {
			int rowCount = userDao.create(insertUser);
			assertEquals(rowCount, 1);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Disabled
	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	void testRemove() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	void testFindUser() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	void testFindUserList() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	void testExistedUser() {
		fail("Not yet implemented");
	}

}
