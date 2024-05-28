package com.stringdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
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
        
        System.out.println("9) Remove Duplicate character from an string");
        s="Hi my name is Maneesh";
        System.out.println(removeDuplicates(s));
        
        System.out.println("Check one string is rotating of other or not");
        s1="maneesh"; s2="aneeshm";
        System.out.println(checkRotating(s1,s2));
        
        System.out.println("Sort the chracter in dtring by their freq");
        s="aabbcddd";
        //out caabbddd
        System.out.println(sortByCharacter(s));
        
        
        System.out.println("Balance parnthesis check: ");
        s="[()]{}{[()()]()}";
//       exp = “[()]{}{[()()]()}” 
//        		Output: Balanced
//        		Explanation: all the brackets are well-formed
//
//        		Input: exp = “[(])” 
//        		Output: Not Balanced 
//        		Explanation: 1 and 4 brackets are not balanced because 
//        		there is a closing ‘]’ before the closing ‘(‘
        if (checkBalance(s))
        System.out.println("Balanced");
        else System.out.println(" Not Balanced");
        
        
        System.out.println(" Group of anagram: "
        		+ "");
        ArrayList<String> list = new ArrayList<>();
        list.add("cat");
        list.add("dog");
        list.add("ogd");
        list.add("god");
        list.add("atc");
 
        System.out.println(groupOfAnagram(list));
        
	}
	
	
	
	
	
	public static List<String> groupOfAnagram(List<String> list){
		HashMap<HashMap<Character, Integer>, ArrayList<String> > map =new HashMap<>();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			String s = (String) iterator.next();
			HashMap<Character , Integer> tempMap=new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				tempMap.put(s.charAt(i), tempMap.getOrDefault(s.charAt(i), 0)+1);
			}
			if(map.containsKey(tempMap)) {
				map.get(tempMap).add(s);
			}
			else {
				ArrayList<String > tempList=new ArrayList<>();
				tempList.add(s);
				map.put(tempMap, tempList);
			}
			
		}
		ArrayList <String > res=new ArrayList<>();
		for (Map.Entry<HashMap<Character, Integer>, ArrayList<String>> entry : map.entrySet()) {
			HashMap<Character, Integer> key = entry.getKey();
			ArrayList<String> val = entry.getValue();
			res.addAll(val);
			
			
		}
		return res;
	}
	
	public static boolean checkBalance(String x) {
		 Stack<Character> st = new Stack<>();
			char[] charArray = x.toCharArray();
			for (char c : charArray) {
				if(c=='{' || c=='[' || c=='(') st.push(c);
				else {
					if (c=='}' && !st.isEmpty() && st.peek()=='{')  st.pop();
					else if (c==']' && !st.isEmpty() && st.peek()=='[')  st.pop();
					else if (c==')' && !st.isEmpty() && st.peek()=='(')  st.pop();
					else if((c==']' || c=='}' || c==')') && st.isEmpty()) return false;
					else if(c=='}' && (st.peek()=='[' || st.peek()=='(')) return false;
					else if(c==']' && (st.peek()=='{' || st.peek()=='(')) return false;
					else if(c==')' && (st.peek()=='[' || st.peek()=='{')) return false;
				}
			}
			if(st.isEmpty()) return true;
			
			return false;
	}
	public static String sortByCharacter(String s) {
		Map<Character, Integer> map= new HashMap<>();
		for (Character ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
			
			
		}
		List<Map.Entry<Character , Integer>> entryList= new ArrayList<>(map.entrySet());
		Collections.sort(entryList, (e1,e2)->e1.getValue().compareTo(e2.getValue()));
		StringBuilder res=new StringBuilder();
		for (Map.Entry<Character, Integer> entry : entryList) {
			for (int i = 0; i < entry.getValue(); i++) {
				res.append(entry.getKey());
			}
		}
		return res.toString();
	}
	
	public static boolean checkRotating(String s1, String s2) {
		if(s1.equals(s2)) return true;
		for (int i = 0; i < s1.length(); i++) {
			String temp=s1.substring(i+1)+s1.substring(0,i+1);
			if(temp.equals(s2)) return true;
		}
		return false;
	}
	
	
	private static String removeDuplicates(String s) {
		// TODO Auto-generated method stub
		Map<Character, Integer> map= new HashMap<>();
		String res ="";
		for (int i = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i)) && s.charAt(i)!=' ') continue;
			else {
				res=res+s.charAt(i);
				map.put(s.charAt(i), 1);
			}
		}
		return res;
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
