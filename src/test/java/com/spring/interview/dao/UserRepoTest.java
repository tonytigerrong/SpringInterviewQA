package com.spring.interview.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.interview.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class UserRepoTest {

	@Autowired
	UserRepo userRepo;
	@Test
	void test() {
		String path = "src/test/resources";
		File file = new File(path);
		String absolutePath = file.getAbsolutePath();
		System.out.println(absolutePath);
		assertTrue(absolutePath.endsWith("resources"));
		
		User user = new User("Smith","Green",11,null);
		userRepo.save(user);
	}

}
