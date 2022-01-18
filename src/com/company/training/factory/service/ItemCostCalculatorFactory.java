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
	private BusinessRuleDao brDao;

	public ItemCostCalculatorFactory() {
		brDao = new BusinessRuleDao();
	}
	// TODO implement Inversion of control
	
	
	//Interface :-  ItemCostCalculator :- calculateItemCost(item);
		//Class 1 :- RawItemCostCalculator implements ItemCostCalculator
		//Class 2 :- ManufacturedItemCostCalcualtor implements ItemCostCalculator
		//Class 3 :- ImportedItemCostCalculator implements ItemCostCalculator
	public List<ItemResponse> calculatItemCost(List<Item> items) {
		List<ItemResponse> result = new ArrayList<>();
		for (Item item : items) {
			BusinessRule rule = brDao.getBusinessRule(item.getItemType());
			ItemResponse response = initializeItemResponse(item);
			// output
			if (ITEM_TYPE_RAW.equals(item.getItemType())) {
				
				ItemCostCalculator calculator= new RawItemCostCalculator();
				calculator.populateItemCost(rule, null, item, response);
				
			} else if (ITEM_TYPE_MANUFACTURED.equals(item.getItemType())) {
				
				ItemCostCalculator calculator= new ManufacturedItemCostCalculator();
				calculator.populateItemCost(rule,null, item, response);
				
			} else {
				
				ItemCostCalculator calculator= new ImportedItemCostCalculator();
				calculator.populateItemCost(rule,rule.getSurcharge(), item, response);
				
			}
			result.add(response);
		}
		return result;
	}


	private ItemResponse initializeItemResponse(Item item) {
		ItemResponse response = new ItemResponse();
		response.setItemName(item.getItemName());
		response.setItemType(item.getItemType());
		response.setItemPrice(item.getPrice());
		response.setQuantity(item.getQuantity());
		return response;
	}
}