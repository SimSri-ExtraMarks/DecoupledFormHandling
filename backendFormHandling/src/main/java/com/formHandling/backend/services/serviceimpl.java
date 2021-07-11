package com.formHandling.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.formHandling.backend.entity.User;
import com.formHandling.backend.repository.UserRepository;


@Service
public class serviceimpl implements UserService{
	private UserRepository userRepository;
	
	public serviceimpl(UserRepository userRepository) {
		super();
		this.userRepository=userRepository;
	}

	@Override
	public List<User> getAllDatas() {
		return userRepository.findAll();
	}

	@Override
	public User getDataById(int id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User updateData(User user) {
		return userRepository.save(user);
	}

	@Override
	public User saveData(User user) {
		return userRepository.save(user);
	}

}
