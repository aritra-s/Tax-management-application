package com.company.training.dao;

import java.util.Map;


import com.company.training.taxcal.model.BusinessRule;


public abstract class BusinessRuleDao {
	
	public abstract void BusinessRuleDaoCatagory(Map<String, BusinessRule> businessRuleMap); 
	
	public abstract BusinessRule getBusinessRule(String type,Map<String, BusinessRule> businessRuleMap);	
	
}


