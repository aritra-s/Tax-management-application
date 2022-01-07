package com.company.tax;

public class Calculation extends Items {
	
    

	public Calculation() {
		super();
	}

	public Calculation(String itemName, int itemPrice, int itemQty, String itemType) {
		super(itemName, itemPrice, itemQty, itemType);
	}

	public void method() {
		
	super.toString();
	int ItemPrice=super.ItemPrice;
	String ItemType=super.ItemType;
	
	if(ItemType.equals("Raw")) {
		//12.5% of the item cost
		double eff= (ItemPrice+((12.5/100.0)*ItemPrice));
		
		System.out.println("Effective cost is :"+eff);
		System.out.println("Sales tax is :"+(eff-ItemPrice));
	}
	
	else if(ItemType.equals("Manufactured")) {
		//12.5% of the item cost + 2% of (item cost + 12.5% of item cost)
		double i= ((12.5/100.0)*ItemPrice);
		double j=(2/100.0)*(ItemPrice+i);
		double f=i+j+ItemPrice;
		System.out.println("Effective cost is :"+f);
		System.out.println("Sales tax is :"+(f-ItemPrice));
	}
	
	//if(ItemType.equals("Imported")) {
	else {
		/*10% import duty on item cost + a surcharge (surcharge is: Rs. 5 
		if the final cost after applying tax & import duty is up to Rs. 100, Rs. 10 
		if the cost exceeds 100 and up to 200 and 5% of the final cost if it exceeds 200).*/
		double i=10/100.0;
		double import_duty=i*ItemPrice;
		
		if(ItemPrice+import_duty<=100.0) {
		double f=ItemPrice+import_duty+5;
		System.out.println("Effective cost is :"+f);
		System.out.println("Sales tax is :"+(f-ItemPrice));
		}
		else if(ItemPrice+import_duty<=200.0) {
			double f=ItemPrice+import_duty+10;
			System.out.println("Effective cost is :"+f);
			System.out.println("Sales tax is :"+(f-ItemPrice));
		}
		else {
			double s=5/100.0;
			double fs=s*ItemPrice;
			double f=ItemPrice+import_duty+fs;
			System.out.println("Effective cost is :"+f);
			System.out.println("Sales tax is :"+(f-ItemPrice));
			
		}
	}
 }
}


