package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Superviseur;
import com.example.demo.service.SuperviseurService;

import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:3000")
@Component
@RestController
@RequestMapping("/rest/neo4j/")
public class SuperviseurController {

    @Autowired
    SuperviseurService SuperviseurService;


    @GetMapping("/superviseur")
    public Collection<Superviseur> getAll() {
        return SuperviseurService.getAll();
    }
    @Scheduled(fixedRate = 60000)
	public void reportCurrentTime() {
    	getAll();
    	System.out.println("OK");
	}
}