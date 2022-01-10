package com.company.taxcal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ViewGenerator {
	
	public static void view(List<Double> itemPrice){
		
		
		 Iterator<Double> it = itemPrice.iterator();
		 
	        while (it.hasNext()) {
	            System.out.println(it.next());
	        }		
		
	}

}
