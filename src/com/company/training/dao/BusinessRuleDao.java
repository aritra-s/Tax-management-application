package com.company.training.dao;

import java.util.HashMap;
import java.util.Map;


import com.company.training.taxcal.model.BusinessRule;
import com.company.training.taxcal.model.Surcharge;


public class BusinessRuleDao {
	
	//(type, businessRule)
	private  Map<String, BusinessRule> businessRuleMap;
	public BusinessRuleDao() {
		businessRuleMap = new HashMap<>();
		//RAW
		BusinessRule rawBusinessRule = new BusinessRule();
		rawBusinessRule.setBasicTax(12.5f);
		businessRuleMap.put("Raw", rawBusinessRule);

		//MANUFACTURED
		BusinessRule manufacturedBusinessRule= new BusinessRule();
		manufacturedBusinessRule.setAddedTax(2.0f);
		manufacturedBusinessRule.setBasicTax(12.5f);
		businessRuleMap.put("Manufactured", manufacturedBusinessRule);
		
		//IMPORTED
		BusinessRule importedBusinessRule= new BusinessRule();
		importedBusinessRule.setImportDuty(10.0f);
		Surcharge surcharge=new Surcharge();
		surcharge.setSurchargeSlab1(5);
		surcharge.setSurchargeSlab2(10);
		importedBusinessRule.setSurcharge(surcharge);
		businessRuleMap.put("Imported", importedBusinessRule);
		
		
	}

	
	public BusinessRule getBusinessRule(String type) {
		BusinessRule rule = businessRuleMap.get(type);
		return rule;
	}
}


