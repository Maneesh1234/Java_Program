package com.stringdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StringProgram {

	public static void main(String[] args) {
//		Input: str1 = “listen”  str2 = “silent”
//				Output: “Anagram”
//				Explanation: All characters of “listen” and “silent” are the same.
//
//				Input: str1 = “gram”  str2 = “arm”
//				Output: “Not Anagram”
		String str1 = "listen"; 
		String  str2 = "silent";
		System.out.println("Check anagram : "+ checkAnagram(str1,str2));
		
		System.out.println("Check anagram Using Map : "+ checkAnagramUsingMap(str1,str2));
		
		//Longest String 
		String s="You are now Selected";
		String [] arrOfStr=s.split(" ");
		String res = Arrays.asList(arrOfStr).stream().sorted((e1,e2)->e1.length()>e2.length()?-1:1).collect(Collectors.toList()).get(0);
		System.out.println(res);
		
		//Longest String length
		Integer longlen = Arrays.asList(arrOfStr).stream().map(e->e.length()).sorted((e1,e2)->e1>e2?-1:1).collect(Collectors.toList()).get(0);
		System.out.println(longlen);
		
		String s1="aab", s2="xyx";
		System.out.println("Is Isomorphic : "+ isIsomorphic(s1, s2));
		
		System.out.println("3) String Palindrome");
		
//		A string is called a palindrome if the reverse of the string is the same as the original one.
//
//		Example: “madam”, “racecar”, “12321”.
		String str = "4123214";
		StringBuilder revStr= new StringBuilder(str);
		revStr.reverse();
		System.out.println("Is Palindrome: " + str.equals(revStr.toString())+"  : "+ revStr);
		
		//2nd way
		String rev="";
		for (int i = 0; i < str.length(); i++) {
			rev=str.charAt(i)+rev;
		}
		System.out.println("2nd way :: Is Palindrome: " + str.equals(rev) +"   : "+rev);

        s="Hi my name is Maneesh";
        System.out.println("Capitalize Every character of string");
        String reduce = Arrays.asList(s.split(" ")).stream().map(subs->subs.substring(0,1).toUpperCase()+subs.substring(1)).reduce("", (ans,i)->ans+" "+i);
        System.out.println(reduce);
        
        System.out.println("8) reverse each word in string");
        String revEveWord = Arrays.asList(s.split(" ")).stream().map(sub->reverse(sub)).reduce("",(ans,i)->ans+" "+i);
        System.out.println(revEveWord);
        
        // 2nd way
        String revEveWord2 = Arrays.asList(s.split(" ")).stream().map(sub->new StringBuilder(sub).reverse().toString()).reduce("",(ans,i)->ans+" "+i);
        System.out.println(revEveWord2);
        
        //3rd way
        String revEveWord3 = Arrays.asList(s.split(" ")).stream().map(sub->{
        	char [] ch=sub.toCharArray();
        	String rev2="";
        	for (int i = 0; i < ch.length; i++) {
				rev2=ch[i]+rev2;
			}
        	return rev2;
        }).reduce("",(ans,i)->ans+" "+i);
        System.out.println(revEveWord3);
        
	}
	
	public static String reverse(String s) {
		StringBuilder sb= new StringBuilder(s);
		sb.reverse();
		return sb.toString();
	}

	
	public static boolean isIsomorphic(String s1, String s2) {
		if(s1.length()!=s2.length()) return false;
		HashMap<Character, Integer> hashMap = new HashMap<>();
		int n=s1.length();
		for (int i = 0; i < n; i++) {
			if(hashMap.containsKey(s1.charAt(i))) hashMap.put(s1.charAt(i), 1+hashMap.get(s1.charAt(i)));
			else hashMap.put(s1.charAt(i), 1);
		}
		List<Integer> list1 = new ArrayList<Integer>();
		for(Map.Entry< Character, Integer> entry:hashMap.entrySet()) {
			list1.add(entry.getValue());
		}
		HashMap<Character, Integer> hashMap2 = new HashMap<>();
		int n2=s2.length();
		for (int i = 0; i < n; i++) {
			if(hashMap2.containsKey(s2.charAt(i))) hashMap2.put(s2.charAt(i), 1+hashMap2.get(s2.charAt(i)));
			else hashMap2.put(s2.charAt(i), 1);
		}
		List<Integer> list2 = new ArrayList<Integer>();
		for(Map.Entry< Character, Integer> entry:hashMap2.entrySet()) {
			list2.add(entry.getValue());
		}
		list1.sort((e1,e2)->e1>e2?1:-1);
		list2.sort((e1,e2)->e1>e2?1:-1);
		if(list1.size()!=list2.size()) return false;
		n=list1.size();
		for(int i=0;i<n ;i++) {
			if(list1.get(i)!=list2.get(i)) return false;
		}
		return true;
	}
	
	public static boolean checkAnagram(String str1, String str2) {
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		if (charArray1.length!= charArray2.length) return false;
		for (int i = 0; i < charArray2.length; i++) {
			if(charArray1[i]!=charArray2[i])  return false;
		}
		return true;
	}
	
	public static boolean checkAnagramUsingMap(String str1, String str2) {
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		if (charArray1.length!= charArray2.length) return false;
		HashMap<Character, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < charArray1.length; i++) {
			if(hashMap.containsKey(charArray1[i]))
				hashMap.put(charArray1[i], hashMap.get(charArray1[i])+1);
			else
				hashMap.put(charArray1[i], 1);
		}
		for (int i = 0; i < charArray2.length; i++) {
			if(hashMap.containsKey(charArray2[i]))
				hashMap.put(charArray2[i], hashMap.get(charArray2[i])-1);
			else
				return false;
		}
		Set<Character> keySet = hashMap.keySet();
		for (Character key : keySet) {
			if(hashMap.get(key)!=0) return false; 
		}
		return true;
	}
	

}
