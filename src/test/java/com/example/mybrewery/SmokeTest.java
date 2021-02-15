package com.example.mybrewery;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mybrewery.web.controller.v2.BeerControllerV2;

@SpringBootTest
public class SmokeTest {
	
	@Autowired
	private BeerControllerV2 controller;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
