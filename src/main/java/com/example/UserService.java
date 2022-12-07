package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;

@Service
public class UserService {
	
	@Autowired
	private Repo repo;
	
	
	public User saveUser(User user)
	{
		User user1=new User();
		user1.setId(user.getId());
		user1.setName(user.getName());
		user1.setAge(user.getAge());
		return repo.save(user1);
	}
	
public User findById(String id) throws UserNullException
{
	User user=repo.findById(id).get();
	return user;
}

	public UserService () {
		
	}
}
