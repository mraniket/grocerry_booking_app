package com.qpassessment.qpgrocery.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qpassessment.qpgrocery.model.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Integer>{
	
	
	/**
	 * This method will return all the elements in the grocery
	 * 
	 */
	public List<GroceryItem> findAll();
	
	/**
	 * This method will add the items into the database
	 * 
	 */
	
	public GroceryItem save(GroceryItem groceryItem);

	
	/**
	 * // Custom query method to find all items where available is true
	 * 
	 */
	
	public List<GroceryItem> findByAvailableTrue();

}
