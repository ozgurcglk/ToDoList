package com.appcent.todolist.BusinessTests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.appcent.todolist.business.concretes.CorporateUserManager;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.utilities.mapping.ModelMapperService;
import com.appcent.todolist.dataAccess.CorporateUserDao;
import com.appcent.todolist.entities.CorporateUser;

public class CorporateUserTests {
	
	@InjectMocks
	private CorporateUserManager corporateUserManager;
	
	@Mock
	private CorporateUserDao corporateUserDao;
	private ModelMapperService mapperService;
	
	@Before
	public void setup() throws Exception{
		corporateUserDao = Mockito.mock(CorporateUserDao.class);
		corporateUserManager = new CorporateUserManager(corporateUserDao, mapperService);
	}
	
	@Test
	public void should_pass_if_corporate_user_correctly_added() throws BusinessException{
		
		CorporateUser corporateUser = new CorporateUser();
		corporateUser.setUserId(2);
		corporateUser.setEmail("appcent@mail");
		corporateUser.setPassword("123456");
		corporateUser.setCompanyName("appcent");
		corporateUser.setTaxNumber("123456789");
		
		Mockito.when(corporateUserDao.save(ArgumentMatchers.any(CorporateUser.class))).thenReturn(corporateUser);
		CorporateUser created = corporateUserDao.save(corporateUser);
		
		Mockito.verify(corporateUserDao).save(created);
		
	}
	
	
}
