package com.example.mybrewery.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybrewery.services.BeerService;
import com.example.mybrewery.web.model.BeerDTO;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	private final String HOST = "http://localhost:8080";
	private final BeerService beerService;
	
	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}

	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") UUID beerId) {		
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);		
	}	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping // POST - create new beer
	public ResponseEntity handlePost(BeerDTO beerDTO) {
		BeerDTO savedDTO = beerService.saveNewBeer(beerDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", HOST + "/api/v1/beer/" + savedDTO.getId().toString());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping("/{beerId}")
	public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, BeerDTO beerDTO) {
		beerService.updateBeer(beerId, beerDTO);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}
