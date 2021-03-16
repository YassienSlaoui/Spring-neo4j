package com.example.demo.controller;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
@CrossOrigin(origins = "http://localhost:3000")
@Component
@RestController
@RequestMapping("/rest/neo4j/")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/users")
    public Collection<User> getAll() {
        return userService.getAll();
    }
    @Scheduled(fixedRate = 60000)
	public void reportCurrentTime() {
    	getAll();
    	System.out.println("OK");
	}
	
	@PostMapping("/users")
	public User adduser(@RequestBody User User) {
		return userService.createEmployee(User);
	}
	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getEmployeeById(@PathVariable Long id) {
		
		return userService.getEmployeeById(id);
	}
	
	
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateEmployee(@PathVariable Long id, @RequestBody User user){
		
		return userService.updateEmployee(id,user);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		
		return userService.deleteEmployee(id);
	}
}