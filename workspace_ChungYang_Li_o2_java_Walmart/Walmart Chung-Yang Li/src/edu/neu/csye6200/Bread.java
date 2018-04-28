package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Bread extends Item implements Comparable<Bread>{
	
	private int calories; 
	public Bread() {
		super(5,10);// TODO Auto-generated constructor stub
	}
	
	public Bread(int price, int itemNumber) {
		super(price, itemNumber);
	}
	
	public Bread(int price, int itemNumber, int calories) {
		super(price, itemNumber);
		this.calories = calories;// TODO Auto-generated constructor stub
	}
	
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	@Override
	public void show() {
		System.out.println("Bread: Price: " + this.getPrice() + ", ItemNumber: " + this.getItemNumber());// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "Bread: ";
	}

	@Override
	public int compareTo(Bread o) {
		// TODO Auto-generated method stub
		return this.getItemNumber() - o.getItemNumber();
	}
	public static void demo() {
		List<Bread> inventory = new ArrayList<>();
		inventory.add(new Bread(8,5));
		inventory.add(new Bread(4,6));
		inventory.add(new Bread(2,3));
		inventory.add(new Bread(7,1));
		inventory.add(new Bread(0,9));
		
		System.out.println("\n Sort by ItemNumber");
		Comparator<Bread> byItemNumber = (Bread o1, Bread o2) -> o1.getItemNumber() - o2.getItemNumber();
		inventory.stream().sorted(byItemNumber).forEach(n->n.show());
		
		System.out.println("\n Sort by Price");
		inventory.stream().sorted(
				(Bread o1, Bread o2) -> o1.getPrice() - o2.getPrice()
				).forEach(n->n.show());
		
		System.out.println("\n Sort by Price");
		Collections.sort(inventory, (Bread o1, Bread o2) -> o1.getPrice() - o2.getPrice());		
		inventory.forEach(n->n.show());
	}

}
