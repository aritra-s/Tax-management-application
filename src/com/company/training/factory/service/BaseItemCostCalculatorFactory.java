package com.company.training.factory.service;

import java.util.List;

import com.company.training.taxcal.model.Item;
import com.company.training.taxcal.model.ItemResponse;

public abstract class BaseItemCostCalculatorFactory {

	
	public abstract List<ItemResponse> calculatItemCost(List<Item> items);
}
