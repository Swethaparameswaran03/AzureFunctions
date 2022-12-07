package com.example;


import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import com.example.model.User;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.BindingName;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;



public class HelloHandler  extends FunctionInvoker<Object,User>{

	
	
	@FunctionName("savingUser")
    public HttpResponseMessage saveUser(
            @HttpTrigger(name = "savingUser", methods = {HttpMethod.POST}, 
            authLevel = AuthorizationLevel.ANONYMOUS,route="user"
            )HttpRequestMessage<User> request,
            ExecutionContext context) throws UserNullException
    {
		
	
		User user=request.getBody();
		return request.createResponseBuilder(HttpStatus.CREATED).body(handleRequest(user,context))
				.header("Content-Type", "application/json").build();
	    }
	
    @FunctionName("getIdfromUser")
    public HttpResponseMessage getUser(
            @HttpTrigger(name = "getIdfromUser", methods = {HttpMethod.GET}, 
            authLevel = AuthorizationLevel.ANONYMOUS,route="user/{id}"
            )HttpRequestMessage<User> request,@BindingName("id") String id,
            ExecutionContext context) throws UserNullException
    {
    	
    			return request.createResponseBuilder(HttpStatus.OK)
						.body(handleRequest(id, context)).header("Content-Type", "application/json").build();
    }
    
    @FunctionName("updateUser")
    public HttpResponseMessage updateUserDetails(
    		@HttpTrigger(name="updateUser" , methods = {HttpMethod.PUT},
    		  authLevel = AuthorizationLevel.ANONYMOUS,route="user"
    	            )HttpRequestMessage<User> request,
    	            ExecutionContext context) throws UserNullException
    {
    	User user=request.getBody();
    	return request.createResponseBuilder(HttpStatus.CREATED).body(handleRequest(user,context))
    			.header("Content-Type", "application/json").build();
    }
    
    @FunctionName("deleteUser")
    public HttpResponseMessage deletingUser(
            @HttpTrigger(name = "deleteUser", methods = {HttpMethod.DELETE}, 
            authLevel = AuthorizationLevel.ANONYMOUS,route="user/{id}"
            )HttpRequestMessage<User> request,@BindingName("id") String id,
            ExecutionContext context) throws UserNullException
    {
    	
    			return request.createResponseBuilder(HttpStatus.OK)
						.body(handleRequest(id, context)).header("Content-Type", "application/json").build();
    }
    
    @FunctionName("getAllUsers")
    public HttpResponseMessage getAllUserDetails(
    		@HttpTrigger(name="getAllUsers" , methods = {HttpMethod.GET},
    		  authLevel = AuthorizationLevel.ANONYMOUS,route="users/all"
    	            )HttpRequestMessage<User> request,
    	            ExecutionContext context) throws UserNullException
    {
    	return request.createResponseBuilder(HttpStatus.CREATED).body(handleRequest(" ",context))
    			.header("Content-Type", "application/json").build();
    }

}