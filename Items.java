package com.company.tax;

public class Items {
	
	public String ItemName;
	public int ItemPrice;
	public int ItemQty;
	public String ItemType;
	public Items() {
		super();
	}

public Items(String itemName, int itemPrice, int itemQty, String itemType) {
		super();
		ItemName = itemName;
		ItemPrice = itemPrice;
		ItemQty = itemQty;
		ItemType = itemType;
	}

@Override
public String toString() {
	return "Items [ItemName=" + ItemName + ", ItemPrice=" + ItemPrice + ", ItemQty=" + ItemQty + ", ItemType="
			+ ItemType + "]";
}


}
