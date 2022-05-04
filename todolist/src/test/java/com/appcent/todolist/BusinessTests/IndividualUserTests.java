package com.appcent.todolist.BusinessTests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.appcent.todolist.business.concretes.IndividualUserManager;
import com.appcent.todolist.core.concretes.BusinessException;
import com.appcent.todolist.core.utilities.mapping.ModelMapperService;
import com.appcent.todolist.dataAccess.IndividualUserDao;
import com.appcent.todolist.entities.IndividualUser;

public class IndividualUserTests {
	
	@InjectMocks
	private IndividualUserManager individualUserManager;
	
	@Mock
	private IndividualUserDao individualUserDao;
	private ModelMapperService mapperService;
	
	@Before
	public void setup() throws Exception{
		individualUserDao = Mockito.mock(IndividualUserDao.class);
		individualUserManager = new IndividualUserManager(individualUserDao, mapperService);
	}
	
	@Test
	public void should_pass_if_individual_user_correctly_added() throws BusinessException {
		
		IndividualUser individualUser = new IndividualUser();
		individualUser.setUserId(1);
		individualUser.setEmail("ozgur@mail");
		individualUser.setPassword("123456");
		individualUser.setFirstName("ozgur");
		individualUser.setLastName("caglak");
		individualUser.setNationalityId("123445556");
		
		
		Mockito.when(individualUserDao.save(ArgumentMatchers.any(IndividualUser.class))).thenReturn(individualUser);
		IndividualUser created = individualUserDao.save(individualUser);
		
		Mockito.verify(individualUserDao).save(created);
		
	}
	
	
}
