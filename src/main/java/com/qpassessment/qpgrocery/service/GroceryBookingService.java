package com.qpassessment.qpgrocery.service;

import java.util.List;
import java.util.Map;

import com.qpassessment.qpgrocery.dto.BookItems;

public interface GroceryBookingService {
	
	 public Map<String, String> bookItems(BookItems items);

}
