package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class ArrayListPractice {

	public static void main(String[] args) {
		
		
		ArrayList<String> arr1=new ArrayList<String>();
		ArrayList<String> arr2=new ArrayList<String>();
		arr1.add("A");
		arr1.add("B");
		arr1.add("C");
		
		 /* Sorting in decreasing order*/
		   Collections.sort(arr1, Collections.reverseOrder());

		   /* Sorted List in reverse order*/
		   System.out.println("ArrayList in descending order:");
		   for(String str: arr1){
				System.out.println(str);
			}
		
		//System.out.println(Collections.reverseOrder());
		System.out.println("Iterator logic");
		ListIterator itr= arr1.listIterator();
		while(itr.hasNext())
		{
			
			System.out.println(itr.next());
		}
		
		
		System.out.println("Traverse in reverse order");
		while(itr.hasPrevious())
		{
			System.out.println(itr.previous());
		}
		
		
		System.out.println("Normal for loop");
		for (int i=0; i<arr1.size(); i++){
		System.out.println(arr1.get(i));
		}
		
		System.out.println("For each loop");
		for(String j:arr1){
			System.out.println(j);
		}
		
		String[] arr=new String[] {"ANDROID", "JSP", "JAVA", "STRUTS", "HADOOP", "JSF"};
		System.out.println("before converting:"+Arrays.toString(arr));
		ArrayList<String> list=new ArrayList<String>(Arrays.asList(arr));
		System.out.println("after converting: "+list);
	}
	
	//Array to Arraylist
	
	
		
		
	/*Scanner sc = new Scanner(System.in);
	System.out.println("Enter values");
	int number = sc.nextInt();
	
	for (int i = 0 ; i < number ; i ++) {
		String name = sc.next();
		arr1.add(name);
		
	}
	
	for(String j:arr1){
		System.out.println(j);
	}

	sc.close();
	
	}*/
}
