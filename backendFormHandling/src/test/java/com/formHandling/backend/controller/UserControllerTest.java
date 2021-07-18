package com.formHandling.backend.controller;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.formHandling.backend.entity.User;
import com.formHandling.backend.repository.UserRepository;
import com.formHandling.backend.services.UserService;
import com.formHandling.backend.services.serviceimpl;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	@Mock
	UserService userService;

	@Mock
	UserRepository userRepository;

	@InjectMocks
	serviceimpl service;

	@Captor
	private ArgumentCaptor<User> captor;

	@BeforeEach
	void init() {
		// MockitoAnnotations.initMocks(this); deprecated
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void getAllUsersSuccessful() {
		when(userService.getAllDatas()).thenReturn(Collections.emptyList());
		UserController userController = new UserController(userService);
		List<User> usersResponse = userController.getAllUsers();
		assertNotNull(usersResponse);
	}

	@Test
	void getDataByIdTest() {
		User user = getUser();
		when(userService.getDataById(1000)).thenReturn(user);
		assertEquals("Testing", user.getName());
		// When we want to test many asserts in one go
		// assertAll(heading, executables);
		assertAll("getDataByIdTest", () -> assertEquals("Testing", user.getName()),
				() -> assertEquals("Other", user.getGender()));
	}

	private User getUser() {
		String[] array = { "Mockito", "Junit" };
		User user = new User();
		user.setId(1000);
		user.setName("Testing");
		user.setEmail("fetchIdTest@gmail.com");
		user.setMobilenumber("1111111111");
		user.setGender("Other");
		user.setState("Test");
		user.setSkills(Arrays.asList(array));
		return user;
	}
	
	private User updateDetails() {
		String[] array = { "Mockito" };
		User user = new User();
		user.setId(1000);
		user.setName("Testing");
		user.setEmail("testing@gmail.com");
		user.setMobilenumber("0000000000");
		user.setGender("Special");
		user.setState("Testing");
		user.setSkills(Arrays.asList(array));
		return user;
	}

	@Test
	public void shouldCaptureTest() {
		String[] skills = { "Mockito", "Junit" };
		List<String> d = Arrays.asList(skills);
		User user1 = new User("Harry", "harry@gmail.com", "8171603367", "Kerala", "Male", d);
		userService.saveData(user1);
		Mockito.verify(userService).saveData(captor.capture());
		assertEquals("Harry", captor.getValue().getName());
	}
	// Multiple Captures using ArgumentCaptor

	@Test
	public void shouldCaptureMultipleTimes() {
		String[] skills = { "Mockito", "Junit" };
		List<String> d = Arrays.asList(skills);
		User user_1 = new User("Harry", "harry@gmail.com", "8171603367", "Kerala", "Male", d);
		User user_2 = new User("Joe", "joe@gmail.com", "8234603367", "Madhya Pradesh", "Male", d);
		User user_3 = new User("Laura", "laura@gmail.com", "8678993367", "Maharashtra", "Female", d);
		userService.saveData(user_1);
		userService.saveData(user_2);
		userService.saveData(user_3);
		Mockito.verify(userService, Mockito.times(3)).saveData(captor.capture());
		List<User> userList = captor.getAllValues();

		assertEquals("Harry", userList.get(0).getName());
		assertEquals("Joe", userList.get(1).getName());
		assertEquals("Laura", userList.get(2).getName());
	}
	
	@Test
	public void UpdateUserTest() {
		User user = getUser();
		when(userService.getDataById(1001)).thenReturn(updateDetails());
		assertEquals("Testing", user.getName());
	}

}
