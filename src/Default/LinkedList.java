package Default;

class LinkedList<E>{
	private static class Node<E>{
		private E element;
		private Node<E> next;
		public Node(E e, Node<E> n){
			element = e;
			next = n;
		}
		public E getElement(){
			return element;
		}
		public Node<E> getNext(){
			return next;
		}
		public void setElement(E e){
			element = e;
		}
		public void setNext(Node<E> n){
			next = n;
		}
	}
	
	private Node<E> head;
	public LinkedList(){
		head = null;
	}
	public void add(E e){
		Node<E> temp = new Node<>(e, head);			
		head = temp;
	}
	public void insert(E e, Node<E> p, Node<E> n){
		p.setNext(new Node<>(e, n));      
	}
	public Node<E> getNode(int i) throws Exception{
		Node<E> temp = head;
		while (i > 0){
			if (temp == null) throw new Exception("Out of bound");
			temp = temp.getNext();
			i--;
		}
		return temp;
	}
	
	//implement this method
	public boolean detectLoop(){
		// Create a slow pointer which will travel on the link list one by one
		Node<E> slow = head;
		// Create a fast pointer that will travel through the link list by 2s
		Node<E> fast = head;
		
		// Create a while loop to travel throw the link list
		// as long as the current slow, fast, and the next node on the fast is not null
		while(slow != null && fast != null && fast.getNext() != null)
		{
			// Assign the next node on the slow pointer to the slow pointer
			slow = slow.getNext();
			// Assign the 2nd in line node on the fast pointer to the fast pointer
			fast = fast.getNext().getNext();
			
			// Check if they are equal, if so then return true
			if(slow == fast) return true;
		}
		// Return false when there is no loop
		return false; 
	}
}
