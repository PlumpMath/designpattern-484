package com.ibm.idoo.singleton;

public class EagerLoadSingleton {
	
	private static EagerLoadSingleton instance = new EagerLoadSingleton(); 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EagerLoadSingleton.INSTANCE();
	}
	
	//invisible constructor
	private EagerLoadSingleton(){}
	
	public static EagerLoadSingleton INSTANCE(){
		return instance;
	}
	
	

}
