package com.company.training.factory.service;

import java.util.List;

import com.company.training.taxcal.model.BusinessRule;
import com.company.training.taxcal.model.Item;
import com.company.training.taxcal.model.ItemResponse;
import com.company.training.taxcal.model.Surcharge;

public interface ItemCostCalculator {

	
	ItemResponse calculateCost(Item item);
		
}
