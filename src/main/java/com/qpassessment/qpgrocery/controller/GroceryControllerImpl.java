package com.qpassessment.qpgrocery.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qpassessment.qpgrocery.dto.BookItems;
import com.qpassessment.qpgrocery.model.GroceryItem;
import com.qpassessment.qpgrocery.model.User;
import com.qpassessment.qpgrocery.service.GroceryBookingService;
import com.qpassessment.qpgrocery.service.GroceryServiceInteface;
import com.qpassessment.qpgrocery.service.user.UserServiceinterface;

@RestController
@RequestMapping("/api")
public class GroceryControllerImpl implements GroceryControllerInterface {

	@Autowired
	private GroceryServiceInteface groceryService;
	
	@Autowired
	private GroceryBookingService groceryBookingService;
	
	@Override
	@GetMapping("/getAll")
	public List<GroceryItem> getAll() {
		return groceryService.getAllGroceryItems();
	}
	
	@Override
	@GetMapping("/grocery-items/available")
	public List<GroceryItem> getAvailable() {
		return groceryService.getAvailableGroceryItems();
	}	
	
	@Override
	@PostMapping("/bookItems")
	public ResponseEntity<Map<String, String>> bookItems(@RequestBody BookItems bookItems) {
		  Map<String, String> bookingResult = groceryBookingService.bookItems(bookItems);
		  return ResponseEntity.ok(bookingResult);
	}
	
	/**
	 * Below are the endpoints related to the grocery which can be only accessed by the ADMIN
	 * 
	 * */

	@Override
	@PostMapping("/addItem")
	public GroceryItem add(@RequestBody GroceryItem grocery) {
		return groceryService.addGroceryItem(grocery);
	}

	@Override
	@PutMapping("/update/{id}")
	public GroceryItem updateGroceryItem(@PathVariable int id, @RequestBody GroceryItem updatedItem) {
		// Full update - the entire item is replaced
		return groceryService.updateGroceryItem(id, updatedItem);
	}
	
	@Override
	@DeleteMapping("/delete/{id}")
	public void deleteGroceryItem(@PathVariable int id) {
		 groceryService.deleteGroceryItem(id);
	}
	


}
