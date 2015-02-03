package com.ibm.idoo.singleton;

public class SampleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=0;i<500;i++){
			Thread t = new Thread (new Runnable(){

				@Override
				public void run() {
					DCLSingleton.get().hello(Thread.currentThread().getId());
				}
				
			});
			t.start();
//			try{
//				t.join();
//			}catch (InterruptedException e){
//				e.printStackTrace();
//			}

		}


		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread t = new Thread (new Runnable(){
			@Override
			public void run() {
				DCLSingleton.get().hello(Thread.currentThread().getId());
			}
			
		});
		t.start();
		
//		
//		SingletonObj o = new SingletonObj();
//		o.hello(1);
	}


}
