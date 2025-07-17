package com.qpassessment.qpgrocery.service;

import java.util.List;

import com.qpassessment.qpgrocery.model.GroceryItem;

public interface GroceryServiceInteface {
	
	public List<GroceryItem> getAllGroceryItems();

	public GroceryItem addGroceryItem(GroceryItem groceryItem);

	public GroceryItem updateGroceryItem(int id, GroceryItem updatedItem);

	public void deleteGroceryItem(int id);

	public List<GroceryItem> getAvailableGroceryItems(); 

}
