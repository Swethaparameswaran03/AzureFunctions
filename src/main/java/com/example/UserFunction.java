package com.example;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.model.User;

@Configuration
public class UserFunction {
	
	
	@Autowired
	private Repo repo;

	@Bean("savingUser")
    public Function<User, User> savingUser() {
        return user -> repo.save(user);
    }
	
	@Bean("getIdfromUser")
	public Function<String,User> getIdfromUser()
	{
		return id-> repo.findById(id).get();
	}
	@Bean("deleteUser")
	public Function<String,String> deleteUser(){
		return id -> {
			repo.deleteById(id);
			return "deleted";
		};
	}
	
	@Bean("updateUser")
	public Function<User, User> updateUser(){
		return user-> repo.save(user);
		
	}
	
	@Bean("getAllUsers")
	public Function<User, List<User>> getAllUsers(){
		return users->repo.findAll();
		
	}
	
}

