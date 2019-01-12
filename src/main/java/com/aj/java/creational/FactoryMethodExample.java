package com.aj.java.creational;

interface Polygon {
	public String getType();
}

class Square implements Polygon {
	@Override
	public String getType() {
		return "Square";
	}
}

class Pentagon implements Polygon {
	@Override
	public String getType() {
		return "Pentagon";
	}
}

class Triangle implements Polygon {
	@Override
	public String getType() {
		return "Triangle";
	}
}

class PolygonFactory {

	public static Polygon getPolygon(int edges) {
		Polygon polygon = null;

		switch (edges) {
		case 3:
			polygon = new Triangle();
			break;
		case 4:
			polygon = new Square();
			break;
		case 5:
			polygon = new Pentagon();
			break;
		}

		return polygon;
	}
}

public class FactoryMethodExample {

	public static void main(String[] args) {
		Polygon polygon = PolygonFactory.getPolygon(3);
		System.out.println(polygon.getType());
		
		polygon = PolygonFactory.getPolygon(4);
		System.out.println(polygon.getType());
		
		polygon = PolygonFactory.getPolygon(5);
		System.out.println(polygon.getType());
	}

}
