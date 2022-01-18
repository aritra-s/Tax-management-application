package com.company.training.factory.service;

import com.company.training.dao.BusinessRuleDao;
import com.company.training.taxcal.model.BusinessRule;
import com.company.training.taxcal.model.Item;
import com.company.training.taxcal.model.ItemResponse;
import com.company.training.taxcal.model.Surcharge;

public class RawItemCostCalculator implements ItemCostCalculator {

	@Override
	public ItemResponse calculateCost(Item item) {
		BusinessRuleDao brDao= new BusinessRuleDao();
		BusinessRule rule = brDao.getBusinessRule(item.getItemType());
		ItemResponse response = initializeItemResponse(item);
		populateItemCost(rule,null, item, response);
		return response;
	}
	
	
	private void populateItemCost(BusinessRule rule, Surcharge surcharge, Item item, ItemResponse response) {
		
		// 12.5% of the item cost
		response.setSalesTax(((rule.getBasicTax() / 100.0) * item.getPrice())); 
		response.setEffectivePrice((item.getPrice() + ((rule.getBasicTax() / 100.0) * item.getPrice())));

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
