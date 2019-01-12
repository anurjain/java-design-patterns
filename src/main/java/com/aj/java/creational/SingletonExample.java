package com.aj.java.creational;

import java.io.Serializable;

class EagerInitializedSingleton {

	private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

	// private constructor to avoid client applications to use constructor
	private EagerInitializedSingleton() {
	}

	public static EagerInitializedSingleton getInstance() {
		return instance;
	}
}

class StaticBlockSingleton {

	private static StaticBlockSingleton instance;

	private StaticBlockSingleton() {
	}

	// static block initialization for exception handling
	static {
		try {
			instance = new StaticBlockSingleton();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	public static StaticBlockSingleton getInstance() {
		return instance;
	}
}

class LazyInitializedSingleton {

	private static LazyInitializedSingleton instance;

	private LazyInitializedSingleton() {
	}

	public static LazyInitializedSingleton getInstance() {
		if (instance == null) {
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}
}

class ThreadSafeSingleton {

	private static ThreadSafeSingleton instance;

	private ThreadSafeSingleton() {
	}

	public static synchronized ThreadSafeSingleton getInstance() {
		if (instance == null) {
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}

}

class SerializedSingleton implements Serializable {

	private static final long serialVersionUID = -7604766932017737115L;

	private SerializedSingleton() {
	}

	private static class SingletonHelper {
		private static final SerializedSingleton instance = new SerializedSingleton();
	}

	public static SerializedSingleton getInstance() {
		return SingletonHelper.instance;
	}

	
	protected Object readResolve() 
    { 
        return getInstance(); 
    } 
}

public class SingletonExample {

	public static void main(String[] args) {
		EagerInitializedSingleton eagerInstance = EagerInitializedSingleton.getInstance();
		StaticBlockSingleton staticInstance = StaticBlockSingleton.getInstance();
		LazyInitializedSingleton lazyInstance = LazyInitializedSingleton.getInstance();
		ThreadSafeSingleton threadInstance = ThreadSafeSingleton.getInstance();
		SerializedSingleton serialInstance = SerializedSingleton.getInstance();
		
		System.out.println(eagerInstance);
		System.out.println(staticInstance);
		System.out.println(lazyInstance);
		System.out.println(threadInstance);
		System.out.println(serialInstance);
	}

}
