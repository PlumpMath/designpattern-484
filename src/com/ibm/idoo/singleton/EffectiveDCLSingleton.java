package com.ibm.idoo.singleton;

public class EffectiveDCLSingleton {
	private volatile static EffectiveDCLSingleton instance;

	// This ensures that in cases where helper is already initialized (i.e.,
	// most of the time), the volatile field is only accessed once (due to
	// "return result;" instead of "return helper;"), which can improve the
	// method's overall performance by as much as 25 percent
	public static EffectiveDCLSingleton get() {
		EffectiveDCLSingleton result = instance;
		if (result == null) {
			synchronized (EffectiveDCLSingleton.class) {
				result = instance;
				if (result == null) {
					result = instance = new EffectiveDCLSingleton();
				}
			}
		}
		return result;
	}

	private EffectiveDCLSingleton() {

	}
}
