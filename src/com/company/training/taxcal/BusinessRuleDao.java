package com.company.training.taxcal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.company.training.model.BusinessRule;


public class BusinessRuleDao {
	
	//(type, businessRule)
	private  Map<String, BusinessRule> businessRuleMap;
	public BusinessRuleDao() {
		businessRuleMap = new HashMap<>();
		BusinessRule rawBusinessRule = new BusinessRule();
		rawBusinessRule.setBasicTax(12.5f);
		businessRuleMap.put("Raw", rawBusinessRule);
		//TODO similary add values for other types
	}

	
	public BusinessRule getBusinessRule(String type) {
		BusinessRule rule = businessRuleMap.get(type);
		return rule;
	}
	
	//TODO move this to ItemCostCalculator
	
	public List<Double> EffectiveCostCalculator(){
		List<Double> effectivePrice=new ArrayList<Double>();
		 
		for (Entry<Double, String> e : businessRuleMap.entrySet()) {
 
        	if(e.getValue().equals("Raw")) {
    			//12.5% of the item cost
    			double eff= (e.getKey()+((12.5/100.0)*e.getKey()));
    			effectivePrice.add(eff);
    		}
    		
    		else if(e.getValue().equals("Manufactured")) {
    			//12.5% of the item cost + 2% of (item cost + 12.5% of item cost)
    			double i= ((12.5/100.0)*e.getKey());
    			double j=(2/100.0)*(e.getKey()+i);
    			double f=i+j+e.getKey();
    			effectivePrice.add(f);
    			
    		}
    		
    		else {
    			/*10% import duty on item cost + a surcharge (surcharge is: Rs. 5 
    			if the final cost after applying tax & import duty is up to Rs. 100, Rs. 10 
    			if the cost exceeds 100 and up to 200 and 5% of the final cost if it exceeds 200).*/
    			double i=10/100.0;
    			double import_duty=i*e.getKey();
    			
    			if(e.getKey()+import_duty<=100.0) {
    			double f=e.getKey()+import_duty+5;
    			effectivePrice.add(f);
    			
    			}
    			else if(e.getKey()+import_duty<=200.0) {
    				double f=e.getKey()+import_duty+10;
    				effectivePrice.add(f);
    				
    			}
    			else {
    				double s=5/100.0;
    				double fs=s*e.getKey();
    				double f=e.getKey()+import_duty+fs;
    				effectivePrice.add(f);
    				
    			}
    		}
        	
    	 }
    		
        return effectivePrice;    
	}
}


