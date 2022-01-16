package com.company.training.dao;

import java.util.Map;

import com.company.training.taxcal.model.BusinessRule;

public class ManufacturedBusinessRuleDao extends BusinessRuleDao {

	@Override
	public void BusinessRuleDaoCatagory(Map<String, BusinessRule> businessRuleMap) {
		BusinessRule manufacturedBusinessRule= new BusinessRule();
		manufacturedBusinessRule.setAddedTax(2.0f);
		manufacturedBusinessRule.setBasicTax(12.5f);
		businessRuleMap.put("Manufactured", manufacturedBusinessRule);
		
	}

	@Override
	public BusinessRule getBusinessRule(String type,Map<String, BusinessRule> businessRuleMap) {
		BusinessRule rule = businessRuleMap.get(type);
		return rule;
	}

}
