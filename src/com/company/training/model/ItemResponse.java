package com.company.training.model;

public class ItemResponse {
	
	private String itemName;
	private Double itemPrice;
	private Double effectivePrice;
	
	private Double salesTax;
	private String itemType;
	private Integer quantity;
	
	@Override
	public String toString() {
		return "ItemResponse [itemName=" + itemName + ", itemPrice=" + itemPrice + ", effectivePrice=" + effectivePrice
				+ ", salesTax=" + salesTax + ", itemType=" + itemType + ", quantity=" + quantity + "]";
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Double getEffectivePrice() {
		return effectivePrice;
	}
	public void setEffectivePrice(Double effectivePrice) {
		this.effectivePrice = effectivePrice;
	}
	public Double getSalesTax() {
		return salesTax;
	}
	public void setSalesTax(Double salesTax) {
		this.salesTax = salesTax;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
