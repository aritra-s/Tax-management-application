package com.company.tax;

import java.io.BufferedReader;
import java.io.IOException;

//Model -> noun
//Services -> Verb, nounService, ItemService,
//try with resousrce to close a stream automatically
//variable names are always camelCase
//Model ->
//class name is never plural
public class AppStarter {

	public static void main(String[] args) throws IOException {

		//close this stream.
		BufferedReader br= null;
		try {
			br = new BufferedReader(new java.io.InputStreamReader(System.in));
			System.out.println("Welcome to Tax Management App");

		} catch () {

		} finally {
			br.close();
		}

		while(true) {
			System.out.println("enter name");
			String itemName= br.readLine();
			
			System.out.println("enter price");
			int price= Integer.parseInt(br.readLine());
			
			System.out.println("enter quantity");
			int quantity= Integer.parseInt(br.readLine());
			
			System.out.println("enter type");
			String Itemtype= br.readLine();
			//TODO using the inputs -> create an Item model
			//create method Calculater.calcuateTaxAndFinalPrice(List<Item> items) {

				//return List<ItemResponse>;
			// }
			//itemName, itemPrice, tax, finalPrice
			//private static Map<itemType, BusinessRule>, initialize this map in the constructore
			//BusinessRuleDao -> getBusinessRule(itemType); -> BusinessRule
			Calculation it= new Calculation(itemName,price,quantity,Itemtype);
			
			System.out.println("enter Yes if you want to continue otherwise enter No");
			String option= br.readLine();
			if(option.equals("No")) {
				System.out.println(it);
				it.method();
				System.out.println("THANK YOU");
				break;
			}
			else {
				System.out.println(it);
				it.method();
				continue;
			}
		}

	}

}

// AppStarter(List<Item>) -> ItemCostCalculator(List<Item>) <=> BusinessDao(BusinessRule)(map)
// 								|
//								|----> List<ItemResponse> ---> AppStarter -> ViewGenerator(print)

