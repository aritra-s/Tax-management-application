package com.company.taxcal;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class AppStarter {

	public static void main(String[] args) throws IOException {

		BufferedReader br= null;
		try {
			br = new BufferedReader(new java.io.InputStreamReader(System.in));
			System.out.println("Welcome to Tax Management App");

			List<String> itemName=new ArrayList<String>(); 
			List<Double> price=new ArrayList<Double>(); 
			List<Integer> quantity=new ArrayList<Integer>(); 
			List<String> itemType=new ArrayList<String>(); 
			
			Map<Double, String> map=new TreeMap<>();
			int counter=0;

		while(true) {
			System.out.println("enter name");
			
			 itemName.add(br.readLine());
			
			System.out.println("enter price");
			 price.add(Double.parseDouble(br.readLine()));
			
			System.out.println("enter quantity");
			quantity.add(Integer.parseInt(br.readLine()));
			
			System.out.println("enter type");
		        itemType.add(br.readLine());
		    
		     counter++;
			
		    Item it=new Item(itemName, price, quantity, itemType);
		    map.put(it.getPrice().get(counter-1), it.getItemType().get(counter-1));
		    BusinessRuleDao b=new BusinessRuleDao(map);
			System.out.println("enter Yes if you want to continue otherwise enter No");
			String option= br.readLine();
			if(option.equals("No")) {
				System.out.println(it);
				System.out.println(Arrays.toString(b.EffectiveCostCalculator().toArray()));
				Calculator.ItemCostCalculator(b.EffectiveCostCalculator());
	            System.out.println("THANK YOU");
				break;
			}
			else {
				System.out.println(it);
				System.out.println(Arrays.toString(b.EffectiveCostCalculator().toArray()));
				Calculator.ItemCostCalculator(b.EffectiveCostCalculator());
				continue;
			}
		}
			

	}finally {
		br.close();
	}

  }
}


