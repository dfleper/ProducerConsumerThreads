package com.dfleper.ProducerConsumerThreads;

public class Store {

	private int Articles;
	private final int NumMaxStock = 20;

	public Store(int articles) {
		this.Articles = articles;
	}

	synchronized public void Produce(int NewProducts, String Name) {
		try {
			while ((NewProducts + this.Articles) > NumMaxStock) {
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.Articles = this.Articles + NewProducts;
		System.out.println("El Productor " + Name + " ha conseguido añadir " + NewProducts + " productos. Stock = "
				+ this.Articles);
		notifyAll();
	}

	synchronized public void Consume(int ProductstoRemove, String Name) {
		try {
			while ((this.Articles - ProductstoRemove) < 0) {
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.Articles = this.Articles - ProductstoRemove;
		System.out.println(
				"El Consumidor " + Name + " ha retirado " + ProductstoRemove + " productos. Stock = " + this.Articles);
		notifyAll();
	}

	public int getArticles() {
		return Articles;
	}
}