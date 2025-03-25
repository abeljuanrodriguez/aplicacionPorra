package com.example.myPorra;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.example.myPorra.service.CalculoService;

@SpringBootTest
@Transactional
public class CalculoTest {

	@Autowired
	private CalculoService calculoService;
	
	@Test
	@Commit
	void insertDataTest() throws Exception {
		this.calculoService.calcular();
	}


}
