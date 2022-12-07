package com.example;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.User;



@Repository
public interface Repo extends MongoRepository<User,String>{

public Optional<User> findById(String id);



}