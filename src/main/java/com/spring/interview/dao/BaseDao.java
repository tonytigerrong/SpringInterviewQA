package com.spring.interview.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.spring.interview.entities.Address;
import com.spring.interview.entities.User;

@Repository
public class BaseDao {
	public static List<User> users;
	static {
		Address address1 = new Address("12 streetname", "Manhatan", "New York", "USA");
		Address address2 = new Address("13 streetname", "Toronto", "Ontario", "Canada");
		Address address3 = new Address("14 streetname", "Vaccouver", "BC", "Canada");

		User user1 = new User("David", "Green", 31, address1);
		User user2 = new User("Steven", "Great", 33, address2);
		User user3 = new User("Iron", "Fox", 12, address3);
		users = Arrays.asList(user1, user2, user3);
	}

	public List<String> getTestData() {
		List<String> strList = Arrays.asList("David", "Tony", "Smith", "Pilliph");
		return strList;
	}
	
	public List<User> getAllUsers(){
		return BaseDao.users;
	}
	
	public User getUserByName(String firstName,String lastName) {
		List<User> results =  BaseDao.users.stream().filter(user->{
			if(firstName.equals(user.getFirstName()) && lastName.equals(user.getLastName())) {
				return true;
			}
			return false;
		}).collect(Collectors.toList());
		
		return results == null ? null : results.get(0);
	}

}
