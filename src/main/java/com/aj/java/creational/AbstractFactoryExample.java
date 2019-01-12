package com.aj.java.creational;

interface TwoWheeler {
	public void model ();
	public void manufaturer ();
}

class Hero implements TwoWheeler {

	@Override
	public void model() {
		System.out.println("Scooter");
	}

	@Override
	public void manufaturer() {
		System.out.println("Hero India");
	}
}

class Suzuki implements TwoWheeler {

	@Override
	public void model() {
		System.out.println("Bike");
	}

	@Override
	public void manufaturer() {
		System.out.println("Suzuki");
	}
}

interface Fourheeler {
	public void model ();
	public void manufaturer ();
}

class Maruti implements Fourheeler {

	@Override
	public void model() {
		System.out.println("Sedan");
	}

	@Override
	public void manufaturer() {
		System.out.println("Maruti");
	}
}

class Honda implements Fourheeler {

	@Override
	public void model() {
		System.out.println("Hatchback");
	}

	@Override
	public void manufaturer() {
		System.out.println("Honda");
	}
}

abstract class VehicleAbstractFactory {
	public abstract TwoWheeler createByManufacturer (String manufacturer);
	public abstract Fourheeler createByModel (String model);
}

class TwoWheelerFactory extends VehicleAbstractFactory {

	@Override
	public TwoWheeler createByManufacturer(String manufacturer) {
		TwoWheeler vehicle = null;
		
		switch (manufacturer) {
		case "Hero" : vehicle = new Hero ();
		              break;
		case "Suzuki" : vehicle = new Suzuki ();
        break;
		}
		
		return vehicle;
	}

	@Override
	public Fourheeler createByModel(String model) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class FourWheelerFactory extends VehicleAbstractFactory {

	@Override
	public TwoWheeler createByManufacturer(String manufacturer) {
		return null;
	}

	@Override
	public Fourheeler createByModel(String model) {
		Fourheeler vehicle = null;
		
		switch (model) {
		case "Hatvchback" : vehicle = new Honda ();
		              break;
		case "Sedan" : vehicle = new Maruti ();
        break;
		}
		
		return vehicle;
	}
}

class FactoryProducer {
	   public static VehicleAbstractFactory getFactory(int wheels){
	   
	      if(wheels == 2){
	         return new TwoWheelerFactory();
	         
	      }else if (wheels == 2){
	         return new FourWheelerFactory();
	      }
	      
	      return null;
	   }
	}

public class AbstractFactoryExample {
	
	public static void main(String... args) {
		VehicleAbstractFactory absFactory = FactoryProducer.getFactory(2);
		
		TwoWheeler object = absFactory.createByManufacturer("Suzuki");
		object.manufaturer();
		object.model();
		
		object = absFactory.createByManufacturer("Hero");
		object.manufaturer();
		object.model();
	}
}
