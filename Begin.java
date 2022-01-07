package com.company.tax;

import java.io.BufferedReader;
import java.io.IOException;
public class Begin {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new java.io.InputStreamReader(System.in));
		System.out.println("Welcome to Tax Management App");
		
		while(true) {
			System.out.println("enter name");
			String Itemname= br.readLine();
			
			
			System.out.println("enter price");
			int price= Integer.parseInt(br.readLine());
			
			System.out.println("enter quantity");
			int quantity= Integer.parseInt(br.readLine());
			
			System.out.println("enter type");
			String Itemtype= br.readLine();
			
			Calculation it= new Calculation(Itemname,price,quantity,Itemtype);
			
			System.out.println("enter Yes if you want to continue otherwise enter No");
			String option= br.readLine();
			if(option.equals("No")) {
				System.out.println(it);
				it.method();
				System.out.println("THANK YOU");
				break;
			}
			else {
				System.out.println(it);
				it.method();
				continue;
			}
		}

	}

}
