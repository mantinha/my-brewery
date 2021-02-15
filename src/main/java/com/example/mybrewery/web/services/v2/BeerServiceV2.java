package com.example.mybrewery.web.services.v2;

import java.util.UUID;

import com.example.mybrewery.web.model.v2.BeerDTOV2;

public interface BeerServiceV2 {
	
	BeerDTOV2 getBeerById(UUID beerId);

	BeerDTOV2 saveNewBeer(BeerDTOV2 beerDTO);

	void updateBeer(UUID beerId, BeerDTOV2 beerDTO);

	void deleteById(UUID beerId);
}
