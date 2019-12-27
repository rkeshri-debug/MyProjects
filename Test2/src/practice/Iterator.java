package practice;

import java.util.ArrayList;
import java.util.ListIterator;

public class Iterator {

	public static void main(String[] args) {
		ArrayList<String> arr2=new ArrayList<String>();
		arr2.add("abc");
		arr2.add("rt");
		arr2.add("gjh");
		
		//arr2.clear();
		
	    //arr2.remove(2);
		
		//update the element
		//arr2.set(1, "Abc");
		
		//If we
		//int pos=arr2.indexOf("Abc");
		//System.out.println(pos);
		ListIterator ls=arr2.listIterator();
		
		System.out.println("Forwad direction");
		while(ls.hasNext())
		{
			System.out.println(ls.next());
		}
		
		
		System.out.println("backward direction");
		while(ls.hasPrevious())
		{
			
			System.out.println(ls.previous());
		}

	}

	
}
