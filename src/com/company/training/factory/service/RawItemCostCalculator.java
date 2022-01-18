package com.company.training.factory.service;

import com.company.training.taxcal.model.BusinessRule;
import com.company.training.taxcal.model.Item;
import com.company.training.taxcal.model.ItemResponse;
import com.company.training.taxcal.model.Surcharge;

public class RawItemCostCalculator implements ItemCostCalculator {

	@Override
	public void populateItemCost(BusinessRule rule, Surcharge surcharge, Item item, ItemResponse response) {
		
		// 12.5% of the item cost
		response.setSalesTax(((rule.getBasicTax() / 100.0) * item.getPrice())); 
		response.setEffectivePrice((item.getPrice() + ((rule.getBasicTax() / 100.0) * item.getPrice())));

	}

}
