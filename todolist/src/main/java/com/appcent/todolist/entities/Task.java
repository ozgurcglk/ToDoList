package com.appcent.todolist.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.type.YesNoType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tasks")
@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private int taskId;
	
	@Column(name = "task_description")
	private String taskDescription;
	
	@Column(name = "task_related_with_who")
	private String taskRelatedWithWho;
	
	@Column(name = "task_due_date")
	private LocalDate taskDueDate;
	
	@Column(name = "task_due_time")
	private LocalTime taskDueTime;
	
	@Column(name = "is_the_task_finished")
	private YesNoType isTheTaskFinished;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
}
