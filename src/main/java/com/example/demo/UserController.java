package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping
	public String getUsers()
	{
		return "<h1 style='text-align:center; color: green;'>Get Request with all users</h1>";
	}
	
	@GetMapping("/{userId}")
	public String getUser(@PathVariable(value="userId") String userId)
	{
		return "Get User with a id "+userId;
	}
	
	@GetMapping("/username")
	public String getUserWithQuery(@RequestParam(value="page") int page, @RequestParam(value="limit") int limit)
	{
		return "Page Number is : "+page+" and Limit is : "+limit;
	}

}
