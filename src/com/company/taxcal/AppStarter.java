package com.company.taxcal;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


//Model -> noun
//Services -> Verb, nounService, ItemService,
//try with resousrce to close a stream automatically
//variable names are always camelCase
//Model ->
//class name is never plural

//AppStarter(List<Item>) -> ItemCostCalculator(List<Item>) <=> BusinessDao(BusinessRule)(map)
//	|
//|----> List<ItemResponse> ---> AppStarter -> ViewGenerator(print)

public class AppStarter {

	public static void main(String[] args) throws IOException {

		//close this stream.
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
			//TODO using the inputs -> create an Item model
			//create method Calculater.calcuateTaxAndFinalPrice(List<Item> items) {

				//return List<ItemResponse>;
			// }
			//itemName, itemPrice, tax, finalPrice
			//private static Map<itemType, BusinessRule>, initialize this map in the constructore
			//BusinessRuleDao -> getBusinessRule(itemType); -> BusinessRule
			//Calculation it= new Calculation(itemName,price,quantity,Itemtype);
		    
		    Item it=new Item(itemName, price, quantity, itemType);
		    //Map<Double, String> map=new TreeMap<>();
		    map.put(price.get(counter-1), itemType.get(counter-1));
		    //Calculator.ItemCostCalculator(price,itemType);
		    BusinessRuleDao b=new BusinessRuleDao(map);
			System.out.println("enter Yes if you want to continue otherwise enter No");
			String option= br.readLine();
			if(option.equals("No")) {
				System.out.println(it);
				//it.method();
				//ViewGenerator.view(it.getPrice(), it.getItemType());
				System.out.println(Arrays.toString(b.EffectiveCostCalculator().toArray()));
				Calculator.ItemCostCalculator(b.EffectiveCostCalculator());
	            System.out.println("THANK YOU");
				break;
			}
			else {
				System.out.println(it);
				//ViewGenerator.view(it.getPrice(), it.getItemType());
				System.out.println(Arrays.toString(b.EffectiveCostCalculator().toArray()));
				Calculator.ItemCostCalculator(b.EffectiveCostCalculator());
				continue;
			}
		}
		//List<Double> pricef=new ArrayList<Double>();
		
	     //BusinessRuleDao b=new BusinessRuleDao(map);
		//pricef=b.EffectiveCostCalculator(price, itemType);
		//Iterator<Double> it = b.EffectiveCostCalculator().iterator();
		 
        //while (it.hasNext()) {
            //System.out.println(it.next());
//	     System.out.println(Arrays.toString(b.EffectiveCostCalculator().toArray()));
//            Calculator.ItemCostCalculator(b.EffectiveCostCalculator());
//            System.out.println("THANK YOU");
        //}
		//Item it=new Item(itemName, price, quantity, itemType);
		//ViewGenerator.view(price, itemType);
		

	}finally {
		br.close();
	}

  }
}

// AppStarter(List<Item>) -> ItemCostCalculator(List<Item>) <=> BusinessDao(BusinessRule)(map)
// 								|
//								|----> List<ItemResponse> ---> AppStarter -> ViewGenerator(print)

