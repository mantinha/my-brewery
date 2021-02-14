package com.example.mybrewery.web.model.v2;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

@SuppressWarnings("serial")
public class BeerPagedList extends PageImpl<BeerDTOV2>{

	public BeerPagedList(List<BeerDTOV2> content, Pageable pageable, long total) {
		super(content, pageable, total);
	}

	public BeerPagedList(List<BeerDTOV2> content) {
		super(content);
	}

}
