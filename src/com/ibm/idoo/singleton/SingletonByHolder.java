package com.ibm.idoo.singleton;

public class SingletonByHolder {
	
	//lazy initialization
	//use static class to ensure initialization happens-before any thread to use the instance
	
	private static class InstanceHolder{
		private static final SingletonByHolder INSTANCE = new SingletonByHolder();
	}

	public static SingletonByHolder get(){
		return InstanceHolder.INSTANCE;
	}
	
	//invisible constructor
	private SingletonByHolder(){}
	
	public static void main(String[] args){
		SingletonByHolder.get();
	}
}
