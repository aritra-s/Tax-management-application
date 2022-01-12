package com.company.training.taxcal.model;

import java.util.List;

public class BusinessRule {

	private Float basicTax;
	private Float addedTax;
	private Float importDuty;
	private Surcharge surcharge;

	public Float getBasicTax() {
		return basicTax;
	}

	public void setBasicTax(Float basicTax) {
		this.basicTax = basicTax;
	}

	public Float getAddedTax() {
		return addedTax;
	}

	public void setAddedTax(Float addedTax) {
		this.addedTax = addedTax;
	}

	public Float getImportDuty() {
		return importDuty;
	}

	public void setImportDuty(Float importDuty) {
		this.importDuty = importDuty;
	}

	public Surcharge getSurcharge() {
		return surcharge;
	}

	public void setSurcharge(Surcharge surcharge) {
		this.surcharge = surcharge;
	}

}
