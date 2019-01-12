package com.aj.java.creational;

import java.util.ArrayList;
import java.util.List;

class Students implements Cloneable {
	List<String> students;
	
	public Students () {
		students = new ArrayList<String> ();
	}
	
	public Students (List<String> students) {
		this.students = students;
	}
	
	public void addStudents () {
		students.add("Ankur");
		students.add("Aditya");
		students.add("Rahul");
		students.add("Vineet");
		students.add("Shah");
		students.add("Tania");
	}
	
	public Object clone()  {
		List<String> students = new ArrayList <String> ();
		
		for (String s : this.students)
			students.add(s);
		
		return new Students (students);
	}
	
	public List<String> getStudentList () {
		return students;
	}
}


public class PrototypeExample {
	
	public static void main (String...strings)
	{
		Students list1 = new Students();
		list1.addStudents();
		
		Students list2 = (Students) list1.clone();
		
		list1.addStudents();
		list1.addStudents();
		
		System.out.println("List 1 = " + list1.getStudentList());
		System.out.println("List 2 = " + list2.getStudentList());
		
	}

	
}
