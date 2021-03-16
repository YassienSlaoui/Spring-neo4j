package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Collection<User> getAll() {
        return userRepository.findAll();
    }
    		
	
	
	public User createEmployee( User user) {
		return userRepository.save(user);
	}
	public ResponseEntity<User> getEmployeeById(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(user);
	}
	public ResponseEntity<User> updateEmployee( Long id,  User user){
		User user1 = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		user1.setName(user.getName());
		user1.setAge(user.getAge());
		user1.setTeam(user.getTeam());
		
		User updatedUser = userRepository.save(user1);
		return ResponseEntity.ok(updatedUser);
	}
	
	
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id){
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}