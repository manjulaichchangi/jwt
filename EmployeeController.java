package com.jwt.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.jwt.example.model.Employee;
import com.jwt.example.model.JwtRequest;
import com.jwt.example.model.JwtResponse;
import com.jwt.example.security.MyUserDetailsService;
import com.jwt.example.service.EmployeeService;
import com.jwt.example.utility.JwtUtility;

@RestController
public class EmployeeController 
{	@Autowired
	private EmployeeService service;
    @Autowired
    private JwtUtility jwtUtility;
    @Autowired
    private AuthenticationManager authenicationManager;
    @Autowired
    
    private MyUserDetailsService userService;

	@RequestMapping("/add")
	public String create(@RequestParam int empid, @RequestParam String name,@RequestParam String job)
	{
		Employee emp= service.create(empid, name, job);
		return emp.toString();
	}
	
	@RequestMapping("/")
	public String Home()
	{
		return "Hello world";
	}
	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		try
		{
		authenicationManager.authenticate(
				new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),
						jwtRequest.getPassword()));
		}
		catch(BadCredentialsException e)
		{
        throw new Exception("invalid credentials",e);
	     }
		final UserDetails userDetails=userService.loadUserByUsername(jwtRequest.getUsername());
		
		final String token=jwtUtility.generateToken(userDetails);
		
		return new JwtResponse(token);
		//return  new JwtResponse();
		
}
}
