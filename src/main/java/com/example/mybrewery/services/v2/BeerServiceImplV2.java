package com.example.mybrewery.services.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.mybrewery.web.model.v2.BeerDTOV2;
import com.example.mybrewery.web.model.v2.BeerStyleEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceImplV2 implements BeerServiceV2 {

	@Override
	public BeerDTOV2 getBeerById(UUID beerId) {
		return BeerDTOV2.builder().id(UUID.randomUUID())
				.beerName("Galaxy Cat V2")
				.beerStyle(BeerStyleEnum.ALE)
				.build();
	}

	@Override
	public BeerDTOV2 saveNewBeer(BeerDTOV2 beerDTO) {
		return BeerDTOV2.builder()
				.id(UUID.randomUUID())
				.build();
	}

	@Override
	public void updateBeer(UUID beerId, BeerDTOV2 beerDTO) {
		log.debug("Updating a beer...");
	}

	@Override
	public void deleteById(UUID beerId) {
		log.debug("Deleting a beer...");
	}

}
