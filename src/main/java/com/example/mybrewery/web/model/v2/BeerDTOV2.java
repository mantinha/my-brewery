package com.example.mybrewery.web.model.v2;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTOV2 {	
	private BigDecimal price;
	private String beerName;
	private BeerStyleEnum beerStyle;
	private Integer quantityOnHand;
	private Integer version;
	private Long upc;	
	private OffsetDateTime createdDate;
	private OffsetDateTime lastModifiedDate;
	private UUID id;
	
}
