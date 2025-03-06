package service;


import datastr.MyLinkedList;

public class MainService {

	public static void main(String[] args) {
		MyLinkedList<Integer> linkedListForInt = new  MyLinkedList<>();
		try {
			linkedListForInt.add(45);
			linkedListForInt.add(-100);
			linkedListForInt.add(200);
			linkedListForInt.add(1);
			linkedListForInt.add(700, 3);;
			linkedListForInt.add(200, 6);
			linkedListForInt.remove(1);
			linkedListForInt.print();
			System.out.println(linkedListForInt.get(2));
			linkedListForInt.print();
			System.out.println(linkedListForInt.search(700));
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}