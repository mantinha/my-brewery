package com.example.mybrewery.services;

import java.util.UUID;

import com.example.mybrewery.web.model.BeerDTO;

public interface BeerService {

	BeerDTO getBeerById(UUID beerId);

}
