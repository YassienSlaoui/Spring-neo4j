package com.example.demo.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;

public interface UserRepository extends Neo4jRepository<User, Long>{
	@Query("MATCH(a:Superviseur{team:$A}),(b:User {team:$A}) MERGE (a)-[c:assignment]->(b)")
     void AjouterRelationShip(@Param("A") String A);
	/*List<User> findAll();*/
}
