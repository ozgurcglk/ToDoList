package com.appcent.todolist.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.todolist.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	User getByUserId(int userId);
	
}
