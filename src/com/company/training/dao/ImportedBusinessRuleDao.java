package com.company.training.dao;

import java.util.Map;

import com.company.training.taxcal.model.BusinessRule;
import com.company.training.taxcal.model.Surcharge;

public class ImportedBusinessRuleDao extends BusinessRuleDao {

	@Override
	public void BusinessRuleDaoCatagory(Map<String, BusinessRule> businessRuleMap) {
		BusinessRule importedBusinessRule= new BusinessRule();
		importedBusinessRule.setImportDuty(10.0f);
		Surcharge surcharge=new Surcharge();
		surcharge.setSurchargeSlab1(5);
		surcharge.setSurchargeSlab2(10);
		importedBusinessRule.setSurcharge(surcharge);
		businessRuleMap.put("Imported", importedBusinessRule);
		
	}

	@Override
	public BusinessRule getBusinessRule(String type,Map<String, BusinessRule> businessRuleMap) {
		BusinessRule rule = businessRuleMap.get(type);
		return rule;
	}

}
