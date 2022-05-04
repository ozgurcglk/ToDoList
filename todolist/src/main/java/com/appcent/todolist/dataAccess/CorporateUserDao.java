package com.appcent.todolist.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.todolist.entities.CorporateUser;

@Repository
public interface CorporateUserDao extends JpaRepository<CorporateUser, Integer> {
	
	CorporateUser getByCorporateUserId(int corporateUserId);
	CorporateUser findByEmail(String email);
	
}
