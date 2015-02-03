package com.ibm.idoo.singleton;

import java.io.Serializable;

/*
 * ö��û�й��췽��,����ÿһ��ʾ�����Ǿ�̬�ĵ���,���ҿ��Զ����Ա����������Ϊ,����˵�Ǵ���Ȼ�ĵ���ʵ��. ��Ҫע��ĵط��ǶԵ��������л���ʱ��,��Ҫ����readResolve()����,����ÿ�η����л�readObject()����ÿ�ζ��᷵��һ���µ�ʾ��
 */
public enum EnumSingleton implements Serializable {
	INSTANCE;
	public void method1() {

	}

	/**
	 * readResolve()��������ObjectInputStream��ȡ�����׼������ǰ����
	 * ���������readResolve()����,����readResolve����ָ�����ض���
	 *
	 * @return
	 */
	private Object readResolve() {
		return INSTANCE;
	}
}
