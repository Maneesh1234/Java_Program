package com.arrayeq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayEqual {

	public static void main(String[] args) {
		Integer[] arr1={1,2,3,4,2};
		Integer[] arr2={1,2,3,2,4};
		//Check equality of array
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		boolean res=Arrays.equals(arr1, arr2);
		if( res==true) {
			System.out.println("Arrays are equal");
		}
		else {
			System.out.println("Arrays are not equal");
		}
		//using java 8 
		boolean resusingJava8=Arrays.equals(Arrays.stream(arr1).sorted().toArray(), Arrays.stream(arr2).sorted().toArray());
		if( resusingJava8==true) {
			System.out.println("Arrays are equal using java8");
		}
		else {
			System.out.println("Arrays are not equal using java8");
		}
		
		System.out.println("5) merge two sorted array");
		arr1=new Integer []{1,2,4};
		arr2=new Integer []{2,3,5};
		Integer [] arr=new Integer[arr1.length+arr2.length];
		merge(arr1, arr2, arr);
		Arrays.asList(arr).forEach(e->System.out.print(e+" "));
		
		

	}
	
	public static void merge(Integer []arr1,Integer[] arr2,Integer[] arr) {
		int i=0,j=0,k=0;
		while (i<arr1.length && j<arr2.length) {
			if(arr1[i]<arr2[j]) {
				arr[k]=arr1[i]; i++;
			}
			else {
				arr[k]=arr2[j]; j++;
			}
			k++;
		}
		while (i<arr1.length ) {
			arr[k]=arr1[i]; i++; k++;
		}
		while (j<arr2.length ) {
			arr[k]=arr2[j]; j++; k++;
		}
	}

}
