package com.mapsort;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
class MyMap{
	Integer key;
	String Value;
	public MyMap(Integer key, String value) {
		super();
		this.key = key;
		Value = value;
	}
	
}
class ValueComparator implements Comparator<MyMap>{

	@Override
	public int compare(MyMap o1, MyMap o2) {
		return o2.Value.compareTo(o1.Value);
	}
	
}
public class MapSorting {

	public static void main(String[] args) {
		Map<Integer, String> map=new HashMap<>();
		map.put(1, "maneesh1");
		map.put(2, "maneesh5");
		map.put(3, "maneesh3");
		map.put(4, "maneesh6");
		System.out.println("Value in desc order sorting");
		LinkedList<Entry<Integer, String>> linkedList = new LinkedList<Map.Entry<Integer, String>>( map.entrySet());
		List<Entry<Integer, String>> sortedList= linkedList.stream().sorted((l1,l2)->l2.getValue().compareTo(l1.getValue())).collect(Collectors.toList());
		Map<Integer, String> res=new LinkedHashMap<>();
		
		for(Map.Entry<Integer, String> e:sortedList) {
			res.put(e.getKey(), e.getValue());
		}
		Iterator it =res.keySet().iterator();
		while (it.hasNext()) {
			Integer key = (Integer) it.next();
			System.out.println(key+" : "+ res.get(key));
			
		}
		
		//2) Using Collection sort method
		System.out.println("Using Collection key in asc order");
		Collections.sort(linkedList,(l1,l2)->l1.getKey().compareTo(l2.getKey()));
		Map<Integer, String> res2=new LinkedHashMap<>();
		for(Map.Entry<Integer, String> e:linkedList) {
			res2.put(e.getKey(), e.getValue());
		}
		Iterator<Integer> it2 =res2.keySet().iterator();
		while (it2.hasNext()) {
			Integer key = (Integer) it2.next();
			System.out.println(key+" : "+ res.get(key));
			
		}
		
		
		List <MyMap> listMyMap=new LinkedList<>();
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			Integer key = entry.getKey();
			String val = entry.getValue();
			MyMap myMap = new MyMap(key,val);
			listMyMap.add(myMap);
			
			
		}
		System.out.println("Using Comparator: desc by value");
		listMyMap.stream().sorted(new ValueComparator()).forEach(e->System.out.println(e.key+" : "+e.Value));
	}

}
