package com.qpassessment.qpgrocery.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.qpassessment.qpgrocery.dto.BookItems;
import com.qpassessment.qpgrocery.model.GroceryItem;

public interface GroceryControllerInterface {
	
	public List<GroceryItem> getAll();
	public GroceryItem add(GroceryItem grocery);
	public GroceryItem updateGroceryItem(int id, GroceryItem updatedItem);
	public void deleteGroceryItem(int id);
	public List<GroceryItem> getAvailable();
	public ResponseEntity<Map<String, String>> bookItems(BookItems bookItems);

}
