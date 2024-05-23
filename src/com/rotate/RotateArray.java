package com.rotate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RotateArray {

	public static void main(String[] args) {
		Integer arr2[]= {1,2,3,5};
		//6) Missing Number
		int s=0;
		for (int i = 0; i < arr2.length; i++) {
			s+=arr2[i];
		}
		int n=arr2[arr2.length-1];
		int actualSum=(n*(n+1))/2;
		int missingNum=actualSum-s;
		System.out.println("Missing Number : "+missingNum);
		
		//7) Rotate array :: output 4 5 1 2 8
		Integer arr[]= {1,2,8,4,5};
		int k=2;
		System.out.print("Original Array : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
		System.out.println();
		for (int j = 0; j < k; j++) {
			int lastVal=arr[arr.length-1];
			for (int i = arr.length-2; i >=0 ; i--) {
				arr[i+1]=arr[i];
			}
			arr[0]=lastVal;
		}
		
		System.out.print("Rotated array : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
		
		
		//8) Common Element between two array
		ArrayList<Integer> commonEle = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if(arr[i]==arr2[j]) commonEle.add(arr[i]);
			}
		}
		System.out.println();
		System.out.print("array : ");
		Arrays.asList(arr).forEach(e->System.out.print(e+" "));
		System.out.println();
		System.out.print(" Second array : ");
		Arrays.asList(arr2).forEach(e->System.out.print(e+" "));
		System.out.println();
		System.out.print("Common Element between two array : ");
		commonEle.forEach(e->System.out.print(e+" "));
		
		//2nd method
		System.out.println();
		System.out.print("Using Hashset : ");
		HashSet<Integer> hashSet1 = new HashSet<>();
		HashSet<Integer> hashSet2 = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			hashSet1.add(arr[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			hashSet2.add(arr2[i]);
		}
		hashSet1.retainAll(hashSet2);	
		hashSet1.forEach(e->System.out.print(e+" "));
		
		//3rd 
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i:arr) {
			hashMap.put(i, 1);
		}
		Set<Integer>  resSet=new HashSet<>();
		for (int i : arr2) {
			if(hashMap.containsKey(i))
				resSet.add(i);
		}
		
		System.out.println();
		System.out.print("Using HashMAp : ");
		resSet.forEach(e->System.out.print(e+" "));
		
		//9) Find frequency of element
		Integer arr4[]= {1,2,3,2,1,5,1,1,5};
		HashMap<Integer, Integer> hashMap2 = new HashMap<>();
		for(int i: arr4) {
			if (hashMap2.containsKey(i)) {
				hashMap2.put(i, hashMap2.get(i)+1);
			}
			else {
				hashMap2.put(i, 1);
			}
		}
		Iterator<Integer> iterator = hashMap2.keySet().iterator();
		System.out.println();
		System.out.println("Freq of element in array: ");
		while (iterator.hasNext()) {
			Integer key = (Integer) iterator.next();
			Integer value = hashMap2.get(key);
			System.out.println("Element : "+ key+" , Count : "+value);
			
		}
		
		////10) remove specific element in an array and shift remaining element
		Integer arr5[]= {1,2,3,2,1,5,1,1,5};
		//remove 1   res= 2, 3 2 5 5
		//1) way using arrayList
		System.out.print("remove specific element using arrayList : ");
		ArrayList<Integer> arrayList = new ArrayList<>();
		for(int i :arr5) {
			if(i!=1) {
				arrayList.add(i);
			}
		}
		arrayList.forEach(e->System.out.print(e+ " "));
		
		//11) find element that present twice
		//by using hashmap
		// by using flag
		//by using hashset contains method
		
		//12) Longest Increasing subsequence in an array
//		arr = [10,9,2,5,3,7,101,18]
//				Output: 4
//				The longest increasing subsequence is [2,3,7,101], therefore output is 4.
		System.out.println();
		Integer []arr6 = {10,9,2,5,3,7,101,18 ,8,10,9,11};
		System.out.println("Using Recursion");
		System.out.println("Longest Increasing subsequence : "+LIS(arr6,0,-1)+"  count : "+count_recursion);
		System.out.println("Using Memoization");
		n=arr6.length;
		int dp[][]=new int[n+1][n+1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				dp[i][j]=-1;
			}
		}
		System.out.println("Longest Increasing subsequence : "+LIS(arr6,0,-1,dp)+"  count : "+count_memo);
		
	}
	static int count_recursion=1 ;static int count_memo=1 ;
	public static int LIS(Integer [] arr, int ind ,int prev_ind,int dp[][]) {
			count_memo++;
			//System.out.println(count_memo);
			if (ind==arr.length) return 0;
			if(dp[ind][prev_ind+1]!=-1) return dp[ind][prev_ind+1];
			int len=LIS(arr,ind+1,prev_ind,dp);
			if(prev_ind==-1 || arr[ind]>arr[prev_ind])
				len=len>1+LIS(arr,ind+1,ind,dp)?len:1+LIS(arr,ind+1,ind,dp);
			return dp[ind][prev_ind+1]=len;
		}
	public static int LIS(Integer [] arr, int ind ,int prev_ind) {
		count_recursion++;
		if (ind==arr.length) return 0;
		int len=LIS(arr,ind+1,prev_ind);
		if(prev_ind==-1 || arr[ind]>arr[prev_ind])
			len=len>1+LIS(arr,ind+1,ind)?len:1+LIS(arr,ind+1,ind);
		return len;
	}
	

}
