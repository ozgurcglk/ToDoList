package com.appcent.todolist.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "corporate_users")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "corporate_user_id", referencedColumnName = "user_id")
@Entity
public class CorporateUser extends User{
	
	@Column(name = "corporate_user_id", insertable = false, updatable = false)
	private int corporateUserId;
	
	@Column(name = "tax_number")
	private String taxNumber;
	
	@Column(name = "company_name")
	private String companyName;
	
	
}
