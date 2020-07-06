package com.bolsadeideas.springboot.error.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.error.app.models.domain.User;

@Service
public class UserServiceImpl implements UserService {
	
	private List<User> userList;

	public UserServiceImpl() {
		userList = new ArrayList<>();
		userList.add(new User(1,"Alex", "Turner"));
		userList.add(new User(2,"Dan", "Auerbach"));
		userList.add(new User(3,"Noel", "Gallagher"));
	}
	
	@Override
	public List<User> getUserList() {
		return userList;
	}

	@Override
	public User getUserById(Integer id) {
		User result = null;
		for (User user : userList) {
			if (id == user.getId()) {
				result = user;
				break;
			}
		}
		return result;
	}

	@Override
	public Optional<User> optGetUserById(Integer id) {
		User result = getUserById(id);
		return Optional.ofNullable(result);
	}

}
