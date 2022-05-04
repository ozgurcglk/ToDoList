package com.appcent.todolist.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.todolist.entities.IndividualUser;

@Repository
public interface IndividualUserDao extends JpaRepository<IndividualUser, Integer>{
	
	IndividualUser getByIndividualUserId(int individualUserId);
	
	IndividualUser findByEmail(String email);

}
