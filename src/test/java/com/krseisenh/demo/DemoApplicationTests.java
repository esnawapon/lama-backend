package com.krseisenh.demo;

import com.krseisenh.demo.repository.WordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@MockBean
	private WordRepository repository;

	@Test
	public void getAllWords(){

	}

}
