package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.UserController;
import com.example.demo.entity.User;
import com.example.demo.impl.UserImpl;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

	@Autowired
	private MockMvc mockMvc;

	ObjectMapper objectMapper = new ObjectMapper();

	ObjectWriter objectwriter = objectMapper.writer();

	@MockBean
	private UserRepository mockRepository;
	

	@InjectMocks
    private UserImpl userimpl;
	
	
	
	@MockBean
    private UserService userService;

	@InjectMocks
	private UserController userController;

	User RECORD_1 = new User("123", "Radhika", "Radhika@gmail.com", "Dev");

	User RECORD_2 = new User("456", "athika", "athika@gmail.com", "Dev");

	User RECORD_3 = new User("789", "Radha", "radha@gmail.com", "Dev");

	@Before(value = "")
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

	}

	@Test
	public void getAllUsers() throws Exception {

		List<User> user = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
		logger.info("fetched all the employees" +user);
		
		Mockito.when(mockRepository.findAll()).thenReturn(user);
		mockMvc.perform(MockMvcRequestBuilders.get("/getusers").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}
	
	
	 @Test
	    public void testSaveUser() {
	        // Create a new User entity
	        User user = new User();
	        user.setName("John Doe");
	        user.setEmail("john.doe@example.com");

	        // Save the User entity
	        User savedUser = mockRepository.save(user);

	        // Verify the User entity was saved correctly
	        assertThat(savedUser).isNotNull();
	        assertThat(savedUser.getUserId()).isNotNull();
	        assertThat(savedUser.getName()).isEqualTo("John Doe");
	        assertThat(savedUser.getEmail()).isEqualTo("john.doe@example.com");

	        // Retrieve the User entity from the repository
	        User retrievedUser = mockRepository.findById(savedUser.getUserId()).orElse(null);

	        // Verify the retrieved User entity
	        assertThat(retrievedUser).isNotNull();
	        assertThat(retrievedUser.getUserId()).isEqualTo(savedUser.getUserId());
	        assertThat(retrievedUser.getName()).isEqualTo("John Doe");
	        assertThat(retrievedUser.getEmail()).isEqualTo("john.doe@example.com");
	    }
	 
	 
	 @Test
	    public void testDeleteEmployeeById() {
	        // Given
	        String userId = "123";

	        // When
	        userService.deleteEmployeeById(userId);

	        // Then
	        verify(mockRepository, times(1)).deleteById(userId);
	    }

	
	
	
}
