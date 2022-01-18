package com.company.training.factory.service;

import com.company.training.taxcal.model.BusinessRule;
import com.company.training.taxcal.model.Item;
import com.company.training.taxcal.model.ItemResponse;
import com.company.training.taxcal.model.Surcharge;

public class ItemCostCalculatorHelper {
	
	private ItemCostCalculatorHelper() {
		super();
	}
	
	
//	public static void populateImportedItemCost(BusinessRule rule,Surcharge surcharge, Item item, ItemResponse response) {
//		/*
//		 * 10% import duty on item cost + a surcharge (surcharge is: Rs. 5 if the final
//		 * cost after applying tax & import duty is up to Rs. 100, Rs. 10 if the cost
//		 * exceeds 100 and up to 200 and 5% of the final cost if it exceeds 200).
//		 */
//		double i = rule.getImportDuty() / 100.0;
//		double import_duty = i * item.getPrice();
//
//		if (item.getPrice() + import_duty <= 100.0) {
//			double f = item.getPrice() + import_duty + surcharge.getSurchargeSlab1();
//			response.setSalesTax(f - item.getPrice());
//			response.setEffectivePrice(f);
//
//		} else if (item.getPrice() + import_duty <= 200.0) {
//			double f = item.getPrice() + import_duty + surcharge.getSurchargeSlab2();
//			response.setEffectivePrice(f);
//			response.setSalesTax(f - item.getPrice());
//
//		} else {
//			double s = 5 / 100.0;
//			double fs = s * item.getPrice();
//			double f = item.getPrice() + import_duty + fs;
//			response.setSalesTax(import_duty + fs);
//			response.setEffectivePrice(f);
//		}
//	}
//
//	// 12.5% of the item cost + 2% of (item cost + 12.5% of item cost)
//	public static void populateManufacturedItemCost(Item item, BusinessRule rule, ItemResponse response) {
//		double i = ((rule.getBasicTax() / 100.0) * item.getPrice());
//		double j = (rule.getAddedTax() / 100.0) * (item.getPrice() + i);
//		double f = i + j + item.getPrice();
//		response.setEffectivePrice(f);
//		response.setSalesTax(i + j);
//	}
//
//	// 12.5% of the item cost
//	public static void populateRawItemCost(Item item, BusinessRule rule, ItemResponse response) {
//		response.setSalesTax(((rule.getBasicTax() / 100.0) * item.getPrice())); 
//		response.setEffectivePrice((item.getPrice() + ((rule.getBasicTax() / 100.0) * item.getPrice())));
//	}
//	
//	public static void populateInvalidItemCost(Item item, BusinessRule rule, ItemResponse response) {
//		response.setSalesTax(null); 
//		response.setEffectivePrice(null);
//	}
//
//	public static ItemResponse initializeItemResponse(Item item) {
//		ItemResponse response = new ItemResponse();
//		response.setItemName(item.getItemName());
//		response.setItemType(item.getItemType());
//		response.setItemPrice(item.getPrice());
//		response.setQuantity(item.getQuantity());
//		return response;
//	}

}
