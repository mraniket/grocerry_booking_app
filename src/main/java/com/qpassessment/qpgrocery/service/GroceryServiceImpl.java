package com.qpassessment.qpgrocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.qpassessment.qpgrocery.dao.GroceryItemRepository;
import com.qpassessment.qpgrocery.model.GroceryItem;

@Service
public class GroceryServiceImpl implements GroceryServiceInteface {

	@Autowired
	private GroceryItemRepository groceryItemRepository;

	@Override
	public List<GroceryItem> getAllGroceryItems() {
		List<GroceryItem> groceryItem = groceryItemRepository.findAll();
		return groceryItem;
	}

	@Override
	public GroceryItem addGroceryItem(GroceryItem groceryItem) {
		groceryItemRepository.save(groceryItem);
		return groceryItem;
	}

	@Override
	public GroceryItem updateGroceryItem(int id, GroceryItem updatedItem) {
		// Find the existing item by ID
		GroceryItem existingItem = groceryItemRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Item not found with ID: " + id));

		// Update only the fields that are present in the updatedItem
		if (updatedItem.getItemName() != null) {
			existingItem.setItemName(updatedItem.getItemName());
		}
		if (updatedItem.getPrice() != 0) {
			existingItem.setPrice(updatedItem.getPrice());
		}
		if (updatedItem.getQuantity() != 0) {
			existingItem.setQuantity(updatedItem.getQuantity());
		}
		if (updatedItem.getManifactureDate() != null) {
			existingItem.setManifactureDate(updatedItem.getManifactureDate());
		}
		if (updatedItem.isAvailable() != existingItem.isAvailable()) {
			existingItem.setAvailable(updatedItem.isAvailable());
		}
		if (updatedItem.getDiscount() != 0) {
			existingItem.setDiscount(updatedItem.getDiscount());
		}

		return groceryItemRepository.save(existingItem);
	}

	@Override
	public void deleteGroceryItem(int id) {
		// Check if the item exists
        if (!groceryItemRepository.existsById(id)) {
            throw new RuntimeException("Item not found with ID: " + id);
        }
        // If it exists, delete the item
        groceryItemRepository.deleteById(id);
	}

	@Override
	public List<GroceryItem> getAvailableGroceryItems() {
		return groceryItemRepository.findByAvailableTrue();
	}



}
