package com.inher;

class ChildClass{
	public static void main(String[] args) {
		System.out.println("Child Class");
	}
}
public class InheritanceDemo extends ChildClass {

	public static void main(String[] args) {
		System.out.println("Parent Class");
		//String [] args2= {"2", "3"};
		ChildClass.main(args);
	}

}
