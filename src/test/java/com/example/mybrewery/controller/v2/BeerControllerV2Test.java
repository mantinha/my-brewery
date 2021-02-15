package com.example.mybrewery.controller.v2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.mybrewery.web.controller.v2.BeerControllerV2;
import com.example.mybrewery.web.model.v2.BeerDTOV2;
import com.example.mybrewery.web.services.v2.BeerServiceV2;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BeerControllerV2.class)
public class BeerControllerV2Test {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private BeerServiceV2 service;

	@Test
	public void getBeer() throws Exception {
		this.mockMvc.perform(get("/api/v2/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	@Test
	public void handlePost() throws Exception {
		BeerDTOV2 beerDTO = BeerDTOV2.builder().build();
		String beerDTOJson = objectMapper.writeValueAsString(beerDTO);
		this.mockMvc.perform(post("/api/v2/beer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDTOJson))
				.andExpect(status().isCreated());
	}

	@Test
	public void handleUpdate() throws Exception {
		BeerDTOV2 beerDTO = BeerDTOV2.builder().build();
		String beerDTOJson = objectMapper.writeValueAsString(beerDTO);
		this.mockMvc.perform(post("/api/v2/beer/" + UUID.randomUUID().toString())
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDTOJson))
				.andExpect(status().isNoContent());
	}

}
