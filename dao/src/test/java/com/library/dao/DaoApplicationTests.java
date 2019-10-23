package com.library.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.library.dao.model.English;
import com.library.dao.model.UserModel;
import com.library.dao.repository.EnglishRepository;
import com.library.dao.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoApplicationTests {

	@Autowired
	UserRepository englishRepository;

	@Test
	public void contextLoads() {
		List<UserModel> ls = englishRepository.findAll();
		System.out.println(ls);
	}

}
