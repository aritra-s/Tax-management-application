package com.company.training.taxcal;

import java.util.ArrayList;


import java.util.List;


import com.company.training.model.BusinessRule;
import com.company.training.model.Item;
import com.company.training.model.ItemResponse;
import com.company.training.model.Surcharge;

public class ItemCostCalculator {

	private BusinessRuleDao brDao;
    private BusinessRule rawBusinessRule;
    private BusinessRule manufacturedBusinessRule;
    private BusinessRule importedBusinessRule;

	public ItemCostCalculator() {
		brDao = new BusinessRuleDao();
	}

	public List<ItemResponse> calculatItemCost(List<Item> items) {
		List<ItemResponse> result = new ArrayList<>();
		    
		Surcharge surcharge=new Surcharge();
		surcharge.setSurchargeSlab1(5);
		surcharge.setSurchargeSlab2(10);
		for(Item item:items) {
			BusinessRule rule = brDao.getBusinessRule(item.getItemType());	
			ItemResponse response=new ItemResponse();
			response.setItemName(item.getItemName());
			response.setItemType(item.getItemType());
			response.setItemPrice(item.getPrice());
			response.setQuantity(item.getQuantity());
			//TODO based on itemType get information from rule and calculate the required output
			if(rule.equals(rawBusinessRule)) {
				//12.5% of the item cost
				
				response.setSalesTax(((rawBusinessRule.getBasicTax()/100.0)*item.getPrice())); //Review why output is null
    			response.setEffectivePrice((item.getPrice()+((rawBusinessRule.getBasicTax()/100.0)*item.getPrice())));
    			result.add(response);
			}
			else if(rule.equals(manufacturedBusinessRule)) {
    			//12.5% of the item cost + 2% of (item cost + 12.5% of item cost)
    			Double i= ((rawBusinessRule.getBasicTax()/100.0)*item.getPrice());
    			Double j=(manufacturedBusinessRule.getAddedTax()/100.0)*(item.getPrice()+i);
    			Double f=i+j+item.getPrice();
    			response.setEffectivePrice(f);
				response.setSalesTax(i+j);
    			result.add(response);
    			
    		}
			
			else {
    			/*10% import duty on item cost + a surcharge (surcharge is: Rs. 5 
    			if the final cost after applying tax & import duty is up to Rs. 100, Rs. 10 
    			if the cost exceeds 100 and up to 200 and 5% of the final cost if it exceeds 200).*/
    			double i=10/100.0;
    			double import_duty=i*item.getPrice();
    			
    			if(item.getPrice()+import_duty<=100.0) {
    			double f=item.getPrice()+import_duty+surcharge.getSurchargeSlab1();
    			response.setSalesTax(f-item.getPrice());
    			response.setEffectivePrice(f);
    			result.add(response);
    			
    			}
    			else if(item.getPrice()+import_duty<=200.0) {
    				double f=item.getPrice()+import_duty+surcharge.getSurchargeSlab2();
    				response.setEffectivePrice(f);
    				response.setSalesTax(f-item.getPrice());
        			result.add(response);
    				
    			}
    			else {
    				double s=5/100.0;
    				double fs=s*item.getPrice();
    				double f=item.getPrice()+import_duty+fs;
    				response.setSalesTax(import_duty+fs);
    				response.setEffectivePrice(f);
        			result.add(response);
    				
    			}
    		}
			//ItemResponse response = new ItemResponse();
			//TODO set values to the response									
		}
		return result;
	}
}

