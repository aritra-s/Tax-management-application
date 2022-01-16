package com.company.training.dao;

import java.util.Map;

import com.company.training.taxcal.model.BusinessRule;

public class RawBusinessRuleDao extends BusinessRuleDao {

	@Override
	public void BusinessRuleDaoCatagory(Map<String, BusinessRule> businessRuleMap) {
		//RAW
		BusinessRule rawBusinessRule = new BusinessRule();
		rawBusinessRule.setBasicTax(12.5f);
		businessRuleMap.put("Raw", rawBusinessRule);

	}

	@Override
	public BusinessRule getBusinessRule(String type,Map<String, BusinessRule> businessRuleMap) {
		BusinessRule rule = businessRuleMap.get(type);
		return rule;
	}

}
