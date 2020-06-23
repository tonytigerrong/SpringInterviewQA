package com.spring.interview.dao;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao {
	public List<String> getTestData() {
		List<String> strList = Arrays.asList("David", "Tony", "Smith", "Pilliph");
		
		return strList;
	}
}
