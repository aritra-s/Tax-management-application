package com.company.training.factory.service;

import com.company.training.taxcal.model.BusinessRule;
import com.company.training.taxcal.model.Item;
import com.company.training.taxcal.model.ItemResponse;
import com.company.training.taxcal.model.Surcharge;

public class ManufacturedItemCostCalculator implements ItemCostCalculator {

	@Override
	public void populateItemCost(BusinessRule rule, Surcharge surcharge, Item item, ItemResponse response) {
		
		// 12.5% of the item cost + 2% of (item cost + 12.5% of item cost)
		double i = ((rule.getBasicTax() / 100.0) * item.getPrice());
		double j = (rule.getAddedTax() / 100.0) * (item.getPrice() + i);
		double f = i + j + item.getPrice();
		response.setEffectivePrice(f);
		response.setSalesTax(i + j);

	}

}
