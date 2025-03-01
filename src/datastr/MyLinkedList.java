package datastr;

public class MyLinkedList <Ttype>{
	private MyNode firstNode = null;// netaisu ne get, net set nav nepieciesams
	private MyNode lastNode = null;// netaisu ne get, net set nav nepieciesams
	private int counter = 0;
	
	//neveidosu bezargumeta konstruktoru, jo tas ir jau no object klases pieejams
	
	public boolean isFull() {
		try {
		MyNode<Ttype> newNode = new MyNode (4);
		return false;
		}
		catch (OutOfMemoryError e) {
			return true;
		}
		
	}
	
	public boolean isEmpty() {
		return (counter==0);
	}
	public int howMnayElements() {
		return counter;
	}
	
}
