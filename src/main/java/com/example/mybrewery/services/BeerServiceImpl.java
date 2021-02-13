package com.example.mybrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.mybrewery.web.model.BeerDTO;

@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDTO getBeerById(UUID beerId) {
		return BeerDTO.builder().id(UUID.randomUUID())
				.beerName("Galaxy Cat")
				.beerStyle("Pale Ale")
				.build();
	}

	@Override
	public BeerDTO saveNewBeer(BeerDTO beerDTO) {
		return BeerDTO.builder()
				.id(UUID.randomUUID())
				.build();
	}

}
