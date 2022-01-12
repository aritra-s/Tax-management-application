package com.company.training.taxcal.model;

public class Item {

	private String itemName;
	private Double price;
	private Integer quantity;
	private String itemType;

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", price=" + price + ", quantity=" + quantity + ", itemType=" + itemType
				+ "]";
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

}
