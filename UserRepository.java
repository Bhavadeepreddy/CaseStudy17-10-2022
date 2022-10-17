package com.gl.casestudy4.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.casestudy4.bean.RechargeUsers;

@Repository

public interface UserRepository extends JpaRepository<RechargeUsers, String> {
	
	Optional<RechargeUsers> findUserByUsername(String username);
	
	

}
