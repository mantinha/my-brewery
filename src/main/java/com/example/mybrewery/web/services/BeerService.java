package com.example.mybrewery.web.services;

import java.util.UUID;

import com.example.mybrewery.web.model.BeerDTO;

public interface BeerService {

	BeerDTO getBeerById(UUID beerId);

	BeerDTO saveNewBeer(BeerDTO beerDTO);

	void updateBeer(UUID beerId, BeerDTO beerDTO);

	void deleteById(UUID beerId);

}
