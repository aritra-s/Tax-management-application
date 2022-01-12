package com.company.training.taxcal;

import java.util.List;

import com.company.training.taxcal.model.ItemResponse;

public final class ViewGenerator {

	private ViewGenerator() {
		super();
	}

	// print item cost
	// TODO Itemname | item Price | item tax | final Price
	public static void printItemsCost(List<ItemResponse> result) {
		int i = 1;
		for (ItemResponse item : result) {
			// TODO print item output in here
			System.out.println();
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
