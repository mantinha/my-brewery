package com.example.mybrewery.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybrewery.services.BeerService;
import com.example.mybrewery.web.model.BeerDTO;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	private final String HOST = "http://localhost:8080";
	private final BeerService beerService;
	
	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}

	@GetMapping("/{beerId}") // POST - create new beer
	public ResponseEntity<BeerDTO> getBeer(@PathVariable UUID beerId) {		
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping
	public ResponseEntity handlePost(BeerDTO beerDTO) {
		BeerDTO savedDTO = beerService.saveNewBeer(beerDTO);
		HttpHeaders headers = new HttpHeaders(null);
		headers.add("Location", HOST + "/api/v1/beer/" + savedDTO.getId().toString());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

}
