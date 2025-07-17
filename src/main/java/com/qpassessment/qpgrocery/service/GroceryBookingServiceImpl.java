package com.qpassessment.qpgrocery.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpassessment.qpgrocery.dao.GroceryItemRepository;
import com.qpassessment.qpgrocery.dto.BookItems;
import com.qpassessment.qpgrocery.dto.Items;
import com.qpassessment.qpgrocery.model.GroceryItem;


/**
 * Separated out this service as booking can be a separate module
 * To keep code readable and one should track the functionality
 * Booking may include payment gateway. 
 * 
 * 
 */

@Service
public class GroceryBookingServiceImpl implements GroceryBookingService {
	
	@Autowired
	private GroceryItemRepository groceryItemRepository;

	@Override
	public Map<String, String> bookItems(BookItems items) {
		 Map<String, String> bookingResult = new HashMap<>();

	        for (Items itemBooking : items.getItems()) {
	            GroceryItem groceryItem = groceryItemRepository.findById(itemBooking.getItemId()).orElse(null);

	            if (groceryItem == null) {
	                bookingResult.put("Item ID: " + itemBooking.getItemId(), "Item not found");
	                continue;
	            }

	            if (!groceryItem.isAvailable()) {
	                bookingResult.put("Item ID: " + itemBooking.getItemId(), "Item is not available");
	                continue;
	            }

	            if (groceryItem.getQuantity() < itemBooking.getQuantity()) {
	                bookingResult.put("Item ID: " + itemBooking.getItemId(), "Insufficient stock");
	                continue;
	            }

	            // Deduct the booked quantity
	            groceryItem.setQuantity(groceryItem.getQuantity() - itemBooking.getQuantity());
	            groceryItemRepository.save(groceryItem);

	            bookingResult.put("Item ID: " + itemBooking.getItemId(), "Booking successful");
	        }

	        return bookingResult;
	}

}
