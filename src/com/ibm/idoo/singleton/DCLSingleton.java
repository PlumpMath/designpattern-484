package com.ibm.idoo.singleton;

public class DCLSingleton {
	// volatile avoid invalid happens-before situation when other threads access
	// instance before it's got constructed completely,
	// e.g. before constructor "SingletonObj(){...};" finished, or constructor
	// execution finished, however, the instance memory has not been
	// written from local WM back to MM, while the new instance
	// reference has already been assigned and accessed by other threads

	// NOTICE: this is difficult to reproduce this problem depends on compiler,
	// executor and processor, but it's still possible to happen

	private volatile static DCLSingleton instance; // = new SingletonObj();
													// avoid eager
													// initialization

	private static byte[] lock = new byte[0];

	// make constructor invisible, to avoid initialization outside
	private DCLSingleton() {
		System.out.println(Thread.currentThread().getId()
				+ " ------ start constrcutor");
		try {
			Thread.sleep(310);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getId()
				+ " ------ end constrcutor");
	}

	// lazy initialization

	// thread-safe : Double Check Lock with volatile

	public static DCLSingleton get() {
		System.out.println(Thread.currentThread().getId() + " : " + instance);
		if (instance == null) { // avoid lock when every time calling get()
			synchronized (lock) { // ensure both null-check and
									// initialization write in atomic action
				// or synchronized(CDLSingleton.class) {
				if (instance == null) {
					instance = new DCLSingleton();
				}
			}
		}
		return instance;
	}

	public void hello(long id) {
		System.out.println(id + " = " + instance);
	}

}
