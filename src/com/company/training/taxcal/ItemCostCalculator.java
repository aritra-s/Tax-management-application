package com.company.training.taxcal;

import java.util.ArrayList;
import java.util.List;

import com.company.training.model.BusinessRule;
import com.company.training.model.Item;
import com.company.training.model.ItemResponse;

public class ItemCostCalculator {

	private BusinessRuleDao brDao;

	public ItemCostCalculator() {
		brDao = new BusinessRuleDao();
	}

	public List<ItemResponse> calculatItemCost(List<Item> items) {
		List<ItemResponse> result = new ArrayList<>();

		items.forEach(item -> {
			BusinessRule rule = brDao.getBusinessRule(item.getItemType());			
			//TODO based on itemType get information from rule and calulate the required output
			
			ItemResponse response = new ItemResponse();
			//TODO set values to the response						
			result.add(response);			
		});
		return result;
	}
}
