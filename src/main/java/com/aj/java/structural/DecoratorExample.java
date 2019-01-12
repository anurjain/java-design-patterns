package com.aj.java.structural;

interface Page {
	void create();
}

class A3Page implements Page {
	@Override
	public void create() {
		System.out.println("A3 Page created");
	}
}

class A4Page implements Page {

	@Override
	public void create() {
		System.out.println("A4 Page created");
	}
}

class PageDecorator implements Page {
	Page page;
	
	public PageDecorator (Page page) {
		this.page = page;
	}
	
	@Override
	public void create() {
		System.out.println("Abstact decoder created");
	}
}

class BorderDecorator extends PageDecorator {

	public BorderDecorator(Page page) {
		super(page);
	}
	
	public void create() {
		System.out.print("Bordered ");
		page.create();
	}	
}

class ColorDecorator extends PageDecorator {

	public ColorDecorator(Page page) {
		super(page);
	}
	
	public void create() {
		System.out.print("Colored ");
		page.create();
	}	
}

public class DecoratorExample {

	public static void main(String[] args) {
		Page page1 = new ColorDecorator (new A3Page());
		page1.create();
		
		Page page2 = new BorderDecorator (new A4Page());
		page2.create();
	}

}
