package com.company.taxcal;

import java.util.ArrayList;
import java.util.List;

public class Item {
	
	private List<String> itemName; 
	private List<Double> price; 
	private List<Integer> quantity; 
	private List<String> itemType;
	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", price=" + price + ", quantity=" + quantity + ", itemType=" + itemType
				+ "]";
	}
	public List<String> getItemName() {
		return itemName;
	}
	public void setItemName(List<String> itemName) {
		this.itemName = itemName;
	}
	public List<Double> getPrice() {
		return price;
	}
	public void setPrice(List<Double> price) {
		this.price = price;
	}
	public List<Integer> getQuantity() {
		return quantity;
	}
	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
	}
	public List<String> getItemType() {
		return itemType;
	}
	public void setItemType(List<String> itemType) {
		this.itemType = itemType;
	}
	public Item(List<String> itemName, List<Double> price, List<Integer> quantity, List<String> itemType) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
		this.itemType = itemType;
	} 

}
