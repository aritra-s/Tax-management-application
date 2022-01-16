package com.company.training.dao;

import java.util.Map;

import com.company.training.taxcal.model.BusinessRule;

public class InvalidBusinessRuleDao extends BusinessRuleDao {

	@Override
	public void BusinessRuleDaoCatagory(Map<String, BusinessRule> businessRuleMap) {

		BusinessRule invalidBusinessRule= new BusinessRule();
		businessRuleMap.put("Invalid", invalidBusinessRule);
	}

	@Override
	public BusinessRule getBusinessRule(String type, Map<String, BusinessRule> businessRuleMap) {
		return null;
	}

}
