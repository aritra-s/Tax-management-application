package com.company.taxcal;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
	
	

	public static void ItemCostCalculator(List<Double> itemPrice){
		List<Double> result=new ArrayList<Double>();
		
		//BusinessRuleDao bd=new BusinessRuleDao();
		//result=bd.EffectiveCostCalculator(itemPrice, itemType);
		ViewGenerator.view(itemPrice);
		
	}
}
