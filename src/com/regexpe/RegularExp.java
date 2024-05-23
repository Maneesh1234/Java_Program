package com.regexpe;

import java.util.Arrays;
import java.util.regex.*;  
public class RegularExp{  
public static void main(String args[]){  
	//1st way  
	Pattern p = Pattern.compile(".s");//. represents single character  
	Matcher m = p.matcher("as");  
	boolean b = m.matches();  
	  
	//2nd way  
	boolean b2=Pattern.compile(".s").matcher("as").matches();  
	  
	//3rd way  
	boolean b3 = Pattern.matches(".s", "as"); 
	
	System.out.println(b+" "+b2+" "+b3);  
	
	Pattern p1 = Pattern.compile(".s");//. represents single character  
	Matcher m1 = p1.matcher("as hi vbb ccas asb");  
	String res; int start_ind, end_ind, group_count;
//	boolean b1=m1.find(1);
//	res=m1.group();
//	System.out.println(b1+" "+res);
	
	group_count=m1.groupCount();
	System.out.println("Total Count : "+group_count);
	
	System.out.println("Using While Loop");
	while(m1.find()) {
		res=m1.group();
		start_ind=m1.start();
		end_ind=m1.end();
		//group_count=m1.groupCount();
		System.out.println("start index : "+ start_ind+" End Index : "+ end_ind+ " Value : "+res);
	}
	
	//Pattern method compile(), matcher(String), matches(regex, String), split(String)
	String[] arrStr = p1.split("as hi vbb ccas asb");
	Arrays.stream(arrStr).forEach(s->System.out.print(s+" "));
	System.out.println();

	String pattern = p1.pattern();
	System.out.println(pattern);
	
	//Chracter Classess
	System.out.println(Pattern.matches("[amn]*", "abcd"));//false (not a or m or n)  
	System.out.println(Pattern.matches("[amn]*", "amn"));//true (among a or m or n)  
	System.out.println(Pattern.matches("[amn]*", "ammmnab"));//false (not a or m or n)   

}}  