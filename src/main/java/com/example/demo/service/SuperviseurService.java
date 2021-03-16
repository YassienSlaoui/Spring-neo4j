package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Superviseur;
import com.example.demo.repository.SuperviseurRepository;

import java.util.Collection;

@Service
public class SuperviseurService {

    @Autowired
    SuperviseurRepository SuperviseurRepository;

    public Collection<Superviseur> getAll() {
        return SuperviseurRepository.findAll();
    }
}