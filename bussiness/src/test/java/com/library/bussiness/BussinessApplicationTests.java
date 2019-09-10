package com.library.bussiness;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.library.dao.model.English;
import com.library.dao.repository.EnglishRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BussinessApplicationTests {

	@Autowired
	EnglishRepository englishRepository;

	@Test
	public void contextLoads() {
		List<English> ls = englishRepository.findAll();
	}

}
