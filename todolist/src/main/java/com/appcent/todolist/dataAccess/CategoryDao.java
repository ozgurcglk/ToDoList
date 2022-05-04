package com.appcent.todolist.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.todolist.entities.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer>{
	
	Category getByCategoryId(int categoryId);
	Category getByCategoryName(String categoryName);
	
}
