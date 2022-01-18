package com.company.training.factory.service;

import java.util.ArrayList;

import java.util.List;

import com.company.training.dao.BusinessRuleDao;
import com.company.training.taxcal.model.BusinessRule;
import com.company.training.taxcal.model.Item;
import com.company.training.taxcal.model.ItemResponse;
import com.company.training.taxcal.model.Surcharge;

public class ItemCostCalculatorFactory {

	private static final String ITEM_TYPE_MANUFACTURED = "Manufactured";
	private static final String ITEM_TYPE_RAW = "Raw";

	// TODO implement Inversion of control
	

	public List<ItemResponse> calculatItemCost(List<Item> items) {
		List<ItemResponse> result = new ArrayList<>();
		for (Item item : items) {

			if (ITEM_TYPE_RAW.equals(item.getItemType())) {
				
				ItemCostCalculator calculator= new RawItemCostCalculator();
				result.add(calculator.calculateCost(item));
				
			} else if (ITEM_TYPE_MANUFACTURED.equals(item.getItemType())) {
				
				ItemCostCalculator calculator= new ManufacturedItemCostCalculator();
				result.add(calculator.calculateCost(item));
				
			} else {
				
				ItemCostCalculator calculator= new ImportedItemCostCalculator();
				result.add(calculator.calculateCost(item));
				
			}
			
		}
		return result;
	}



}
