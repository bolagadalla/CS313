package Default;

class DLinkedList<E>{
	private static class DNode<E>{
		private E element;
		private DNode<E> prev;
		private DNode<E> next;
		public DNode(E e){
			this(e, null, null);
		}
		public DNode(E e, DNode<E> p, DNode<E> n){
			element = e;
			prev = p;
			next = n;
		}
		public E getE(){
			return element;
		}
		public DNode<E> getPrev(){
			return prev;
		}
		public DNode<E> getNext(){
			return next;
		}
		public void setE(E e){
			element = e;
		}
		public void setPrev(DNode<E> p){
			prev = p;
		}
		public void setNext(DNode<E> n){
			next = n;
		}
	}
	private DNode<E> header;
	private DNode<E> trailer;
	private int size;
	public DLinkedList(){  
		header = new DNode<E>(null);
		trailer = new DNode<E>(null, header, null);
		header.setNext(trailer);
		size = 0;
	}
	public void add(E e){
		DNode<E> oLast = trailer.getPrev();
		DNode<E> temp = new DNode<>(e, oLast, trailer);			
		oLast.setNext(temp);
		trailer.setPrev(temp);
		size++;
	}

	//complete this method
	public E get(int i) throws Exception{
        if (i < 0 || i >= size) throw new Exception("Bad Index");
      	DNode<E> ansNode;
      	//lower end
      	if (i <= size / 2)
      	{
	 		ansNode = header.getNext();
	 		//loop - traversal from header
	 		while (i > 0){
	    		ansNode = ansNode.getNext();
	    		i--;
	 		}
	 		return ansNode.getE();
	 	}

      	else if(i > size / 2)
      	{
      		ansNode = trailer.getPrev();
	 		//loop - traversal from trailer
      		while(i < size - 1)
      		{
      			ansNode = ansNode.getPrev();
      			i++;
      		}
      		
      		return ansNode.getE();
      	}
	 	return null;
	}
	public void print(){
	        DNode<E> temp = header.getNext();
		while (temp != trailer){
			System.out.print(temp.getE().toString() + ", ");
			temp = temp.getNext();
		}
		System.out.println();
	}
}

