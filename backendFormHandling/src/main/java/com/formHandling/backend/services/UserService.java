package com.formHandling.backend.services;

import java.util.List;

import com.formHandling.backend.entity.User;

public interface UserService {
	List<User> getAllDatas();
	User getDataById(int id);
	User updateData(User user);
	User saveData(User user);

}
