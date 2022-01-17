package com.company.training.controller;

import java.util.List;

import com.company.training.factory.service.ItemCostCalculatorFactory;
import com.company.training.taxcal.model.Item;
import com.company.training.taxcal.model.ItemResponse;
import com.company.training.utils.ViewGenerator;

public class ItemController {

	private Item model;
	private ViewGenerator view;
	
	public ItemController(Item model, ViewGenerator view) {
		super();
		this.model = model;
		this.view = view;
	}

	public void setName(String name) {
		model.setItemName(name);
	}
	
	public String getName(String name) {
		return model.getItemName();
	}
	
	public void setItemPrice(Double price) {
		model.setPrice(price);
	}
	
	public Double getItemPrice(Double price) {
		return model.getPrice();
	}
	
	public void setItemQuantity(Integer qty) {
		model.setQuantity(qty);
	}
	 
	public Integer getItemQuantity(Integer qty) {
		return model.getQuantity();
	}
	
	public void setType(String type) {
		model.setItemType(type);
	}
	
	public String getType(String type) {
		return model.getItemType();
	}
	

	public void updateView(List<Item> items) {
		List<ItemResponse> result = new ItemCostCalculatorFactory().calculatItemCost(items);		
		ViewGenerator.printItemsCost(result);
	}

	
	
	
	
}
