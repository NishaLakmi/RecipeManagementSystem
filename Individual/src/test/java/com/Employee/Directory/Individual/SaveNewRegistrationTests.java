package com.Employee.Directory.Individual;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest
class SaveNewRegistrationTests {

	@Autowired
	private UserRepository userRepository;


	@Test
	public void SaveNewLogin(){

		// Arrange
		User newRecord = new User();

		newRecord.setUsername("Test_Name");
		newRecord.setEmail("test@gmail.com");
		newRecord.setUser_password("test123456");


		// Act
		User saveRecord = userRepository.save(newRecord);


		//Assert
		assertNotNull(saveRecord.getId());
		Assertions.assertEquals("Test_Name", saveRecord.getUsername());
		Assertions.assertEquals("test@gmail.com", saveRecord.getEmail());
		Assertions.assertEquals("test123456", saveRecord.getUser_password());

	}

}
