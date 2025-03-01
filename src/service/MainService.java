package service;

import datastr.MyLinkedList;

public class MainService {

	public static void main(String[] args) {
		MyLinkedList<Integer> listForInt = new MyLinkedList<Integer>();
		listForInt.add(45);
		listForInt.add(-100);
		listForInt.add(200);
		listForInt.add(1);
		
		try {
			listForInt.print();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
