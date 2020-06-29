package domain;

import domain.adapter.IDCard;
import domain.adapter.Student;
import domain.builder.Company;
import domain.builder.MainBuilder;

public class Main {
	public static void main(String args[]) 
	{
	 // write your code here

		//BUILDER
		MainBuilder builder = new MainBuilder();
		Company c1 = builder.buildBaziz();
		c1.showBlocks();

		Company c2 = builder.buildBIgroup();
		c2.showBlocks();

		//ADAPTER
		IDCard card = new Student("Ula", 155, "AITU", "EXPO");
		
		System.out.print(card.getIDCard());

	}
}
