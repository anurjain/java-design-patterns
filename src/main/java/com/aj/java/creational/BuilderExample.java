package com.aj.java.creational;

import java.util.StringJoiner;

class Person {
	String name;
	int age;
	long height;
	int weight;
	String address;
	String fatherName;
	String motherName;

	public String toString () {
		return new StringJoiner (" ").add(name).add(""+age).add(""+height).add(""+weight).add(address).add(fatherName).add(motherName).toString();
	}
	
	private Person() {

	}

	public static class Builder {
		String name;
		int age;
		long height;
		int weight;
		String address;
		String fatherName;
		String motherName;

		public Builder(String name, int age) {
			this.name = name;
			this.age = age;
		}

		/**
		 * @param height the height to set
		 */
		public Builder setHeight(long height) {
			this.height = height;
			return this;
		}

		/**
		 * @param weight the weight to set
		 */
		public Builder setWeight(int weight) {
			this.weight = weight;
			return this;
		}

		/**
		 * @param address the address to set
		 */
		public Builder setAddress(String address) {
			this.address = address;
			return this;
		}

		/**
		 * @param fatherName the fatherName to set
		 */
		public Builder setFatherName(String fatherName) {
			this.fatherName = fatherName;
			return this;
		}

		/**
		 * @param motherName the motherName to set
		 */
		public Builder setMotherName(String motherName) {
			this.motherName = motherName;
			return this;
		}

		public Person build () {
			Person person = new Person();
			person.name = this.name;
			person.age = this.age;
			person.height = this.height;
			person.weight = this.weight;
			person.fatherName = this.fatherName;
			person.motherName = this.motherName;
			person.address = this.address;
			
			return person;
		}
	}

}

public class BuilderExample {

	public static void main(String[] args) {
		Person person1 = new Person.Builder("Rahul Dravid", 40).build();
		System.out.println(person1);
		
		Person person2 = new Person.Builder("Rahul Dravid", 40).setHeight(158l).setAddress("Bangalore").setWeight(75).build();
		System.out.println(person2);
	}

}
