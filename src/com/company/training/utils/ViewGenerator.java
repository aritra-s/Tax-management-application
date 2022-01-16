package com.company.training.utils;

import java.util.List;

import com.company.training.taxcal.model.ItemResponse;

public final class ViewGenerator {

	private ViewGenerator() {
		super();
	}

	public static void printItemsCost(List<ItemResponse> result) {
		int i = 1;
		for (ItemResponse item : result) {
	
			System.out.println();
			
			if(item.getEffectivePrice()==null)
				System.out.println("INVALID ITEM TYPE");
			else {
				System.out.println("        ITEM " + (i++) + "       ");
				System.out.println("itemName :");
				System.out.println(item.getItemName());

				System.out.println("itemQuantity :");
				System.out.println(item.getQuantity());

				System.out.println("itemPrice :");
				System.out.println(item.getItemPrice());
				System.out.println("itemTax :");
				System.out.println(item.getSalesTax());

				System.out.println("effectivePrice :");
				System.out.printf("%.2f", item.getEffectivePrice());
				
				System.out.println();
			}

			
		}

	}

}
