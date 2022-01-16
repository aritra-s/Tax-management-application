package com.company.training.factory.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.company.training.dao.BusinessRuleDao;
import com.company.training.dao.ImportedBusinessRuleDao;
import com.company.training.dao.InvalidBusinessRuleDao;
import com.company.training.dao.ManufacturedBusinessRuleDao;
import com.company.training.dao.RawBusinessRuleDao;
import com.company.training.taxcal.model.BusinessRule;
import com.company.training.taxcal.model.Item;
import com.company.training.taxcal.model.ItemResponse;
import com.company.training.taxcal.model.Surcharge;

public class ItemCostCalculatorFactory extends BaseItemCostCalculatorFactory{

	
	
	private static final String ITEM_TYPE_MANUFACTURED = "Manufactured";
	private static final String ITEM_TYPE_RAW = "Raw"; 
	private static final String ITEM_TYPE_IMPORTED ="Imported";
	private BusinessRuleDao brDaoRaw;
	private BusinessRuleDao brDaoManufactured;
	private BusinessRuleDao brDaoImported;
	private BusinessRuleDao brDaoInvalid;
    private Map<String, BusinessRule> businessRuleMap;
	public ItemCostCalculatorFactory() {
		brDaoRaw = new RawBusinessRuleDao();
		brDaoManufactured = new ManufacturedBusinessRuleDao();
		brDaoImported = new ImportedBusinessRuleDao();
		brDaoInvalid = new InvalidBusinessRuleDao();
		businessRuleMap = new HashMap<>();
		
		brDaoRaw.BusinessRuleDaoCatagory(businessRuleMap);
		brDaoManufactured.BusinessRuleDaoCatagory(businessRuleMap);
		brDaoImported.BusinessRuleDaoCatagory(businessRuleMap);
		
	}

	// TODO implement Inversion of control
	
	@Override
	public List<ItemResponse> calculatItemCost(List<Item> items) {
		List<ItemResponse> result = new ArrayList<>();

		for (Item item : items) {
			BusinessRule ruleRaw = brDaoRaw.getBusinessRule(item.getItemType(),businessRuleMap);
			BusinessRule ruleManufactured = brDaoManufactured.getBusinessRule(item.getItemType(),businessRuleMap);
			BusinessRule ruleImported = brDaoImported.getBusinessRule(item.getItemType(),businessRuleMap);
			BusinessRule ruleInvalid = brDaoInvalid.getBusinessRule(item.getItemType(), businessRuleMap);
			ItemResponse response = ItemCostCalculatorHelper.initializeItemResponse(item);
			
			if (ITEM_TYPE_RAW.equals(item.getItemType())) {
				ItemCostCalculatorHelper.populateRawItemCost(item, ruleRaw, response);
			} else if (ITEM_TYPE_MANUFACTURED.equals(item.getItemType())) {
				ItemCostCalculatorHelper.populateManufacturedItemCost(item, ruleManufactured, response);
			} else if(ITEM_TYPE_IMPORTED.equals(item.getItemType())){
				ItemCostCalculatorHelper.populateImportedItemCost(ruleImported,ruleImported.getSurcharge(), item, response);
			}
			else {
				ItemCostCalculatorHelper.populateInvalidItemCost(item, ruleInvalid, response);
			}
			
			result.add(response);
		}
		return result;
	}


}
