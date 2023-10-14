package com.dfleper.ProducerConsumerThreads;

import java.util.Random;

public class Producer extends Thread {

	private Store Store;
	private String Name;

	public Producer(Store store, String name) {
		this.Store = store;
		this.Name = name;
	}

	@Override
	public void run() {
		int NumProducts = 0;

		while (true) {
			
			NumProducts = (new Random()).nextInt(5);
			
			this.Store.Produce(NumProducts, Name);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
