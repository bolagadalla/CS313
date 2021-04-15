package Default;

class PolynomialLinkedList{
	public class PNode{
		private int coe;
		private int exp;
		private PNode next;
		public PNode(int c, int e){
			this(c, e, null);
		}
		public PNode(int c, int e, PNode n){
			coe = c;
			exp = e;
			next = n;
		}
		public void setCoe(int c){ coe = c;}
		public void setExp(int e){ exp = e;}
		public void setNext(PNode n){ next = n;}
		public int getCoe(){ return coe;}
		public int getExp(){ return exp;}
		public PNode getNext(){ return next;}
	}
	public PNode first;
	private PNode last;
	    public PolynomialLinkedList(){
			first = last = null;
		}
		public PolynomialLinkedList(int c, int e){
			PNode tempn = new PNode(c, e);
			first = last = tempn;
		}
		public void print(){
			if (first == null){
				System.out.println("");
				return;
			}
			PNode temp = first;
			String ans = "";
			while (temp != null){
				if (temp.getCoe() > 0) {
					if (temp != first) ans = ans + " + ";
					ans = ans + temp.getCoe();
				}
				else if (temp.getCoe() < 0) ans = ans + " - " + temp.getCoe() * -1;
				if (temp.getExp() != 0){
					ans = ans + "X^" + temp.getExp();
				}
				temp = temp.getNext();
			}
			System.out.println(ans);
		}
		
		public PNode getLast() {return last;}
		
		//implement this method
		public PolynomialLinkedList add(PolynomialLinkedList s){
			PolynomialLinkedList sum = new PolynomialLinkedList();
			// This currentNode will be the start of the link, initialized with an empty node
			PNode currentNode = new PNode(0,0); // Had to create an empty constructor for this
			// The sum "first" property points to the currentNode address
			sum.first = currentNode;
			// Node that will traverse the first polynomial list
			PNode first = this.first;
			// Node that will traverse the second polynomial list
			PNode second = s.first;
			
			// While loop, while either one of the polynomial is not null
			// O(N)
			while(first != null || second != null)
			{
				// if both list are not null
				if(first != null && second != null)
				{
					// if the first polynomial exponent is greater then the second
					if(first.getExp() > second.getExp())
					{
						// Since we initialized this currentNode to be empty then 
						// we set the coe and exp and next properties
						currentNode.setCoe(first.getCoe());
						currentNode.setExp(first.getExp());
						// Since the first node exp was greater, we move its point to the next node
						first = first.getNext();
					}
					// if the second polynomial exponent is greater then the first
					else if(first.getExp() < second.getExp())
					{
						// the currentNode is empty, not null, so we assign the coe, exp, next properties
						currentNode.setCoe(second.getCoe());
						currentNode.setExp(second.getExp());
						// Since second exp was greater, we move its pointer to the next node
						second = second.getNext();
					}
					// otherwise BOTH exp are equal
					else 
					{
						// set the coe to the addition of both coe of both polynomial
						currentNode.setCoe(first.getCoe() + second.getCoe());
						currentNode.setExp(first.getExp());
						// Since both exp were equal, then we move both pointers to the next node
						first = first.getNext();
						second = second.getNext();
					}
				}
				// This happens when we finished with one polynomial list but not the other
				// More specifically if we were finished with "second" but not "first"
				else if (first != null && second == null)
				{
					// Do the same thing as if "first" had the greater exp
					currentNode.setCoe(first.getCoe());
					currentNode.setExp(first.getExp());
					first = first.getNext();
				}
				// if we are finished with "first" polynomial list but not the "second"
				else if(first == null && second != null)
				{
					// Do the same thing as if "second" exp was greater
					currentNode.setCoe(second.getCoe());
					currentNode.setExp(second.getExp());
					second = second.getNext();
				}
				// we keep sum.last to be the last node we have. If there was already existing
				// node there, it will be reset to this currentNode
				sum.last = currentNode;
				// We set the next node to be an empty node
				if(second != null || first != null) currentNode.setNext(new PNode(0,0));
				// we also move the currentNode that was assigned to the sum list to the
				// next (empty node assigned above) node so we can continue assigning it
				currentNode = currentNode.getNext();
			}
			return sum;
		}
		
		//implement this method for extra credit
		public PolynomialLinkedList multiply(PolynomialLinkedList s){
			PolynomialLinkedList product = new PolynomialLinkedList();
			
			return product;
		}
		
		/*
		Write method negate of PolynomialLinkedList which returns back a new PolynomialLinkedList that negate each term in the caller PolynomialLinkeList.
		PolynomialLinkedList has first and last PNode reference.
		Each term is stored in a PNode which has getCoe(), getExp(), getNext(), setNext() method.
		*/
		public PolynomialLinkedList negate()
		{
			PolynomialLinkedList result = new PolynomialLinkedList();
			PNode res = new PNode(0,0);
			PNode resCurrentNode = res;
			PNode currentNode = first;
			while(currentNode != null)
			{
				resCurrentNode.next = new PNode(currentNode.getCoe() * -1, currentNode.getExp());
				resCurrentNode = resCurrentNode.next;
				currentNode = currentNode.next;
			}
			result.last = new PNode(last.getCoe() * -1, last.getExp());
			result.first = res.next;
			return result;
		}
}
