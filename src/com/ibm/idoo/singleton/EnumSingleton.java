package com.ibm.idoo.singleton;

import java.io.Serializable;

/*
 * 枚举没有构造方法,它的每一个示例都是静态的单例,并且可以定义成员变量及其行为,可以说是纯天然的单例实现. 需要注意的地方是对单例反序列化的时候,需要定义readResolve()方法,否则每次反序列化readObject()方法每次都会返回一个新的示例
 */
public enum EnumSingleton implements Serializable {
	INSTANCE;
	public void method1() {

	}

	/**
	 * readResolve()方法会在ObjectInputStream读取完对象准备返回前调用
	 * 如果定义了readResolve()方法,则由readResolve方法指定返回对象
	 *
	 * @return
	 */
	private Object readResolve() {
		return INSTANCE;
	}
}
