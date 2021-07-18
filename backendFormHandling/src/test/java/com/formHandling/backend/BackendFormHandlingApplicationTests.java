package com.formHandling.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.formHandling.backend.entity.User;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class BackendFormHandlingApplicationTests {
	@Mock
	User user;
	@Test
	void contextLoads() {
		String s = "abc";
		assertEquals("abc", s);
		assertNotNull(user);
	}

}
