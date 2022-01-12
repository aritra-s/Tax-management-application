package com.company.training.taxcal;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.company.training.model.Item;
import com.company.training.model.ItemResponse;

public class AppStarter {

	public static void main(String[] args) throws IOException {

		BufferedReader br = null;
		try {
			// TODO use try with resources--- will review later
			br = new BufferedReader(new java.io.InputStreamReader(System.in));
			System.out.println("Welcome to Tax Management App");

			List<Item> items = new ArrayList<>();
			
			while (true) {
				Item item = new Item();
				System.out.println("enter name");
				item.setItemName(br.readLine());
				System.out.println("enter price");
				item.setPrice(Double.parseDouble(br.readLine()));
				System.out.println("enter quantity");
				item.setQuantity(Integer.parseInt(br.readLine()));
				System.out.println("enter type");
				item.setItemType(br.readLine());
				items.add(item);

				System.out.println("enter Yes if you want to continue otherwise enter No");
				String option = br.readLine();
				
				if (option.equals("No")) {
					break;
				} else {
					continue;
				}
			}
			//Item it=new Item();
			//System.out.println(items);
			List<ItemResponse> result = new ItemCostCalculator().calculatItemCost(items);
		
			//System.out.println(result);
			ViewGenerator.printItemsCost(result);
			

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			br.close();
		}

	}
}
