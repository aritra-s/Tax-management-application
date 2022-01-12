package com.company.training.taxcal;

import java.util.ArrayList;

import java.util.List;

import com.company.training.taxcal.model.BusinessRule;
import com.company.training.taxcal.model.Item;
import com.company.training.taxcal.model.ItemResponse;
import com.company.training.taxcal.model.Surcharge;

public class ItemCostCalculator {

	private static final String ITEM_TYPE_MANUFACTURED = "Manufactured";
	private static final String ITEM_TYPE_RAW = "Raw";
	private BusinessRuleDao brDao;

	public ItemCostCalculator() {
		brDao = new BusinessRuleDao();
	}

	// TODO implement factory pattern in here
	// TODO implement Inversion of control
	public List<ItemResponse> calculatItemCost(List<Item> items) {
		List<ItemResponse> result = new ArrayList<>();
		for (Item item : items) {
			BusinessRule rule = brDao.getBusinessRule(item.getItemType());
			ItemResponse response = initializeItemResponse(item);
			// output
			if (ITEM_TYPE_RAW.equals(item.getItemType())) {
				populateRawItemCost(item, rule, response);
			} else if (ITEM_TYPE_MANUFACTURED.equals(item.getItemType())) {
				populateManufacturedItemCost(item, rule, response);
			} else {
				populateImportedItemCost(rule.getSurcharge(), item, response);
			}
			result.add(response);
		}
		return result;
	}

	private void populateImportedItemCost(Surcharge surcharge, Item item, ItemResponse response) {
		/*
		 * 10% import duty on item cost + a surcharge (surcharge is: Rs. 5 if the final
		 * cost after applying tax & import duty is up to Rs. 100, Rs. 10 if the cost
		 * exceeds 100 and up to 200 and 5% of the final cost if it exceeds 200).
		 */
		double i = 10 / 100.0;
		double import_duty = i * item.getPrice();

		if (item.getPrice() + import_duty <= 100.0) {
			double f = item.getPrice() + import_duty + surcharge.getSurchargeSlab1();
			response.setSalesTax(f - item.getPrice());
			response.setEffectivePrice(f);

		} else if (item.getPrice() + import_duty <= 200.0) {
			double f = item.getPrice() + import_duty + surcharge.getSurchargeSlab2();
			response.setEffectivePrice(f);
			response.setSalesTax(f - item.getPrice());

		} else {
			double s = 5 / 100.0;
			double fs = s * item.getPrice();
			double f = item.getPrice() + import_duty + fs;
			response.setSalesTax(import_duty + fs);
			response.setEffectivePrice(f);
		}
	}

	// 12.5% of the item cost + 2% of (item cost + 12.5% of item cost)
	private void populateManufacturedItemCost(Item item, BusinessRule rule, ItemResponse response) {
		Double i = ((rule.getBasicTax() / 100.0) * item.getPrice());
		Double j = (rule.getAddedTax() / 100.0) * (item.getPrice() + i);
		Double f = i + j + item.getPrice();
		response.setEffectivePrice(f);
		response.setSalesTax(i + j);
	}

	// 12.5% of the item cost
	private void populateRawItemCost(Item item, BusinessRule rule, ItemResponse response) {
		response.setSalesTax(((rule.getBasicTax() / 100.0) * item.getPrice())); // Review why output is null
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
