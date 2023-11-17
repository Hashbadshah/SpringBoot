package com.spring.user.UserProfile;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import com.spring.user.UserProfile.Model.User;
import com.spring.user.UserProfile.Repository.UserRepository;
import com.spring.user.UserProfile.service.UserService;

@SpringBootTest
class UserProfileApplicationTests {

	@Autowired
	private UserService userService;
	@MockBean
	private UserRepository userRepo;

	@Test
	void getAllUsersTest() {
		when(userRepo.findAll()).thenReturn((List<User>) Stream.
				of(new User((long) 123, "Hasan", "Mohd", "mohd@89.com"), new User((long) 321 ,"Mohd","Yusuf","Yusuf@123.com")).collect(Collectors.toList()));
		Assertions.assertEquals(2, userService.getAllUsers().size());
	}

	@Test
	public void createUserTest() {
		User user = new User((long) 234, "Anass", "Mohd", "anas@98.com");
		when(userRepo.save(user)).thenReturn(user);
	}

	@Test
	public void getUserByIdTest() {
		Long id = 12345L;
		when(userRepo.findById(id)).thenReturn(Optional.of(new User(123L, "Hasan", "Mohd", "mohd@89.com")));
		User user = userService.getUserById(id);

	    Assertions.assertNotNull(user);
	    Assertions.assertEquals(123L, user.getUserId());
	    Assertions.assertEquals("Hasan", user.getFirstName());
	    Assertions.assertEquals("Mohd", user.getLastName());
	    Assertions.assertEquals("mohd@89.com", user.getEmail());

	}
	public void deleteUserTest() {
		Long id = 234L;
		User deletedUser = userService.deleteUserById(id);
		verify(userRepo, times(1)).deleteById(id);
		Assertions.assertNotNull(deletedUser);
		Assertions.assertEquals(id, deletedUser.getUserId());
	}
}
