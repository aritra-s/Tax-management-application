package com.company.training.factory.service;

import com.company.training.taxcal.model.BusinessRule;
import com.company.training.taxcal.model.Item;
import com.company.training.taxcal.model.ItemResponse;
import com.company.training.taxcal.model.Surcharge;

public class ImportedItemCostCalculator implements ItemCostCalculator {

	@Override
	public void populateItemCost(BusinessRule rule, Surcharge surcharge, Item item, ItemResponse response) {
		/*
		 * 10% import duty on item cost + a surcharge (surcharge is: Rs. 5 if the final
		 * cost after applying tax & import duty is up to Rs. 100, Rs. 10 if the cost
		 * exceeds 100 and up to 200 and 5% of the final cost if it exceeds 200).
		 */
		double i = rule.getImportDuty() / 100.0;
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

}
