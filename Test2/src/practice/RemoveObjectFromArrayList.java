package practice;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class RemoveObjectFromArrayList {

	public static void main(String[] args) {
	
		int[] arr=new int [] {10,20,30,40,50};
		System.out.println("Original array size "+arr.length);
		
		System.out.println("contents are :"+Arrays.toString(arr));
		
		arr=ArrayUtils.remove(arr, 2);
		
		System.out.println("Size of arr after removing an element: "+arr.length);
		System.out.println("Content of array after removal: "+Arrays.toString(arr));

	}

}
