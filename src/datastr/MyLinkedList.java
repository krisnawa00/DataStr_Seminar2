package datastr;

public class MyLinkedList<Ttype> {
	private MyNode firstNode = null;//netaisu ne get, ne set. tas nav nepieciešams, jo leitotājam nevajag pie šiem piekļut
	private MyNode lastNode = null;//netaisu ne get, ne set. tas nav nepieciešams, jo leitotājam nevajag pie šiem piekļut
	private int counter = 0;
	
	//neveidošu beazrgumenta konstruktoru, jo tas ir jau no Object klases pieejams
	
	
	public boolean isFull()//saraksts būs pilns, ja RAM atmiņā nebūs vietas 
	{
		try
		{
			MyNode<Integer> newNode = new MyNode<Integer>(4);
			return false;
			
		}
		catch (OutOfMemoryError e) {
			return true;
		}
	}
	
	
	public boolean isEmpty() {
		return (counter == 0);
	}

	public int howManyElements() {
		return counter;
	}
	
	public void add(Ttype element) {
		if(!isFull()) {
			
			if(isEmpty()) {
				MyNode<Ttype> newNode = new MyNode<Ttype>(element);
				firstNode = newNode;
				lastNode = newNode;
				counter++;
			}
			else
			{
				MyNode<Ttype> newNode = new MyNode<Ttype>(element);
				lastNode.setNext(newNode);
				lastNode = newNode;
				counter++;
				
			}
			
			
		}
	}
	
	public void add(Ttype element, int position) throws Exception {
		
		if(isFull()) {
			throw new Exception ("Saraksts ir pilns");
		}
		
		
		if (position <=0 || position > counter + 1) 
		{
			throw new Exception ("Padota pozicija nav atrasta");
		}
		if (position == 1) {
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			newNode.setNext(firstNode);
			firstNode = newNode;
			counter++;
		}
		else if (position == counter + 1) {
			add(element);
		}
		else {
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			
			
			MyNode <Ttype> currentNode = firstNode;
			
			for (int i = 1; i < position-1; i++) {
				currentNode = currentNode.getNext();
			}
			MyNode<Ttype> currentNodeNext = currentNode.getNext();
			currentNode.setNext(newNode);
			newNode.setNext(currentNodeNext);
			counter++;
		}
	}
	
	
	//dzesanas funkcija definicija, kura ka input param in pozicija
	//veicam nepieciesamas parbaudes
	//ja velamies dzest pirmo elementu
	//ja velams dzest pedejo elementu
	//ja velams dzest jebkuru elementu
	
	public void remove(int position)throws Exception{
		if(isEmpty())
		{
			Exception myException = new Exception("Saraksts ir tukšs, tāpēc nevar izdzest");
			throw myException;
		}
		if (position<1 || position > counter) {
			throw new Exception ("Padota pozicija nav pareiza");
		}
		
		if (position==1) {
			firstNode = firstNode.getNext();
			counter--;
			System.gc();
		}
		else if (position==counter) {

			MyNode <Ttype> currentNode = firstNode;
			
			for (int i = 1; i <= position - 2; i++) {
				currentNode = currentNode.getNext();
			}
			
			lastNode = currentNode;
			lastNode.setNext(null);
			counter--;
			System.gc();
			
			
		}
		
		else {
			MyNode <Ttype> currentNode = firstNode;
			for (int i = 1; i <= position - 2; i++) {
				currentNode = currentNode.getNext();
			}
			MyNode <Ttype> currentNodeNextNext = currentNode.getNext().getNext();
			
			currentNode.setNext(currentNodeNextNext);
			
			counter--;
			System.gc();
		}

		
		
	}
	
	public boolean search(Ttype element) throws Exception {
		if(isEmpty())
		{
			throw new Exception("Saraksts ir tukšs, tāpēc nevar meklēt elementus");
			
		}
		MyNode <Ttype> currentNode = firstNode;
		while(currentNode != null) {
			if(currentNode.getElement().equals(element)) {
				return true;
			}
			currentNode = currentNode.getNext();
		}
		return false;
	
	}
	public void print() throws Exception
	{
		//pārbaudi uz isEmpty
		if(isEmpty())
		{
			Exception myException = new Exception("Saraksts ir tukšs, tāpēc nevar veikt printēšanu");
			throw myException;
		}
		
		MyNode<Ttype> currentNode = firstNode;
		
		while(currentNode != null) {
			System.out.print(currentNode.getElement() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	
	public void makeEmpty() {
		if(!isEmpty()) {
			firstNode = null;//netaisu ne get, ne set. tas nav nepieciešams, jo leitotājam nevajag pie šiem piekļut
			lastNode = null;
			counter = 0;
			
			System.gc();
		}
	}
	
	public Ttype get(int position) throws Exception {
		if(isEmpty())
		{
			Exception myException = new Exception("Saraksts ir tukšs, tāpēc nevar piekļūt elementiem");
			throw myException;
		}
		if(position < 0 || position > counter) {
			throw new Exception("Jūsu position nav atbilstošs");
			
		}
		MyNode <Ttype> currentNode = firstNode;
		
		for (int i = 1; i < position - 1; i++) {
			currentNode = currentNode.getNext();
		}
		
		return currentNode.getElement();

		

	}
	
	
	
	
	
}