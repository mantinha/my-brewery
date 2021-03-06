package com.example.mybrewery.web.controller.v2;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybrewery.web.model.v2.BeerDTOV2;
import com.example.mybrewery.web.services.v2.BeerServiceV2;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
	private final String HOST = "http://localhost:8080";	
	private final BeerServiceV2 beerService;
	
	public BeerControllerV2( BeerServiceV2 beerService ) {
		this.beerService = beerService;
	}

	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDTOV2> getBeer( @PathVariable("beerId") UUID beerId ) {		
		return new ResponseEntity<>( beerService.getBeerById(beerId), HttpStatus.OK );		
	}	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping // POST - create new beer
	public ResponseEntity handlePost( @RequestBody BeerDTOV2 beerDTO ) {
		BeerDTOV2 savedDTO = beerService.saveNewBeer( beerDTO );
		HttpHeaders headers = new HttpHeaders();
		headers.add( "Location", HOST + "/api/v2/beer/" + savedDTO.getId().toString() );
		return new ResponseEntity( headers, HttpStatus.CREATED );
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping("/{beerId}")
	public ResponseEntity handleUpdate( @PathVariable("beerId") UUID beerId, @RequestBody BeerDTOV2 beerDTO ) {
		beerService.updateBeer( beerId, beerDTO );
		return new ResponseEntity( HttpStatus.NO_CONTENT );
	}
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer( @PathVariable("beerId") UUID beerId ) {	beerService.deleteById( beerId ); } 
}
