package com.example.demo.repository;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Superviseur;

public interface SuperviseurRepository extends Neo4jRepository<Superviseur, Long>{
	
	
}

