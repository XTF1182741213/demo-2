package com.example.demo.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);
	//User findById(int id);
	//List<User> findAll();
	
	
//	@Transactional
//	@Modifying(clearAutomatically = true)
//	@Query(value = "update User u set u.password= ?1,u.email= ?2,u.phone= ?3,u.card= ?4,u.realname= ?5,u.icon= ?6 WHERE u.username= ?7",nativeQuery = true)
//	int updateUserByUsername(String password,String email,BigInteger phone,BigInteger card,String realname,String username);

}
