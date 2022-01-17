package com.company.training.taxcal;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.company.training.controller.ItemController;
import com.company.training.factory.service.ItemCostCalculatorFactory;
import com.company.training.taxcal.model.Item;
import com.company.training.taxcal.model.ItemResponse;
import com.company.training.utils.ViewGenerator;

public class AppStarter {

	public static void main(String[] args)  {

		try(BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in))) {
			System.out.println("Welcome to Tax Management App");
			List<Item> items = new ArrayList<>();
			Item model;
			while (true) {
				model=readItemDetails(br, items);
				System.out.println("enter Yes if you want to continue otherwise enter No");
				String option = br.readLine();
				
				if (option.equalsIgnoreCase("No")) {
					break;
				} else {
					continue;
				}
			}
			//List<ItemResponse> result = new ItemCostCalculatorFactory().calculatItemCost(items);		
			//ViewGenerator.printItemsCost(result);
			
			// model=readItemDetails(br, items);
			ViewGenerator view = new ViewGenerator();
			ItemController controller= new ItemController(model, view);
			controller.updateView(items);

		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	private static Item readItemDetails(BufferedReader br, List<Item> items) throws IOException {
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
		return item;
	}
}
