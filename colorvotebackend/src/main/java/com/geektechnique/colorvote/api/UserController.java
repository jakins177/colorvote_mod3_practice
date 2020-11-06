package com.geektechnique.colorvote.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.geektechnique.colorvote.model.Person;
import com.geektechnique.colorvote.model.User;
import com.geektechnique.colorvote.service.UserService;

@RequestMapping("colorvoteapi/v1/user")
@RestController
public class UserController {
	
	private final UserService userService;

	 @Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	 
	 @CrossOrigin
	 @PostMapping
	    public void addUser(@Valid @NonNull @RequestBody User user){
	        userService.addUser(user);
	    }
	 @CrossOrigin
	 @PostMapping("/red")
	    public int addUserRed(@Valid @NonNull @RequestBody User user){
	        userService.addUserRed(user);
	        return 1;
	    }
	 
	 @CrossOrigin
	 @PostMapping("/blue")
	 public int addUserBlue(@Valid @NonNull @RequestBody User user){
	        userService.addUserBlue(user);
	        return 1;
	    }
	 
	 @CrossOrigin
	 @PostMapping("/yellow")
	    public int addUserYellow(@Valid @NonNull @RequestBody User user){
	        userService.addUserYellow(user);
	        return 1;
	    }
	 
	 @CrossOrigin
	 @GetMapping("yellow/count")
	    public int getYellowCount(){
	        return userService.getYellowCount();
	    }
	 
	 @CrossOrigin
	 @GetMapping("blue/count")
	    public int getBlueCount(){
	        return userService.getBlueCount();
	    }
	 
	 @CrossOrigin
	 @GetMapping("red/count")
	    public int getRedCount(){
	        return userService.getRedCount();
	    }
	 
	
	 @CrossOrigin
	 @GetMapping
	    public List<User> getAllUsers(){
	        return userService.getAllUsers();
	    }
	 
	 @CrossOrigin
	 @PostMapping("/dupes")
	 public List<User> addForDupeUser(@Valid @NonNull @RequestBody User user){
	      return  userService.checkDupes(user);
	    }
	

	
	

}
