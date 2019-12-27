package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		ArrayList ls2=new ArrayList();
		
		ls2.add("a");
		ls2.add(1);
		ls2.add('c');

		for (Object ar:ls2){
		System.out.println(ar);
		}
		
		
		
		ArrayList<String> ls=new ArrayList<String>();
		ls.add("India");
		ls.add("US");
		ls.add("China");
		
		System.out.println("Before sorting: ");
		for(String n:ls){
	    System.out.println(n);
		}  
	    Collections.sort(ls);
	    
	    System.out.println();
	    System.out.println("Sorting in ascending order: ");
		for(String n:ls){
	    System.out.println(n);
		}
		
		int[] myarr={3,2,4,1,0,10};
		Arrays.sort(myarr);
		for(int str:myarr){
			System.out.println("sorted array: "+str);
		}
	    	  
      /* ArrayList<Integer> arr=new ArrayList<Integer>(Collections.nCopies(10, 2));
       System.out.println("Array list items :" +arr);
       
       System.out.println("Iterating through for each loop");
       System.out.println();
       for(Integer n:arr){
    	   System.out.println(n);*/
       }
	
	
	

	}
	

