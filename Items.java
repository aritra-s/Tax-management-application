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

//	public String getItemName() {
//		return ItemName;
//	}
//	public void setItemName(String itemName) {
//		ItemName = itemName;
//	}
//	public String getItemPrice() {
//		return ItemPrice;
//	}
//	public void setItemPrice(String itemPrice) {
//		ItemPrice = itemPrice;
//	}
//	public String getItemQty() {
//		return ItemQty;
//	}
//	public void setItemQty(String itemQty) {
//		ItemQty = itemQty;
//	}
//	public String getItemType() {
//		return ItemType;
//	}
//	public void setItemType(String itemType) {
//		ItemType = itemType;
//	}
//	
//	
//	
//	
//	Calculate c=new Calculate();
//	public void m2() {
//	c.effectiveprice(ItemType,100);
//	}

}
