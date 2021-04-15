package Default;

import java.awt.print.Printable;

import Default.PolynomialLinkedList;
import Default.PolynomialLinkedList.PNode;

public class A1LinkedList {
	public static void main(String argc[]){
		LinkedList<Integer> sl = new LinkedList<>();
		DLinkedList<Integer> dl = new DLinkedList<>();
		PolynomialLinkedList sum = new PolynomialLinkedList();
		PolynomialLinkedList prod = new PolynomialLinkedList();
		
		for (int i = 40; i >= -40; i-=2) {
		   sl.add(i*i);
		   dl.add(i);
		}
		
		
		try {
			sl.insert(111, sl.getNode(38), sl.getNode(40));
			if (sl.detectLoop()) System.out.println("Loop! Wrong");
			else System.out.println("No loop.");
		
		
			sl.insert(123, sl.getNode(38), sl.getNode(36));
			if (sl.detectLoop()) System.out.println("Loop!");
			else System.out.println("No loop. Wrong");
			
			sl.insert(321, sl.getNode(38), sl.getNode(37));
			if (sl.detectLoop()) System.out.println("Loop!");
			else System.out.println("No loop. Wrong");
			
			
			dl.print();
			System.out.println("Index 20, has 0? " + dl.get(20));
			System.out.println("Index 21, has -2? " + dl.get(21));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		PolynomialLinkedList p1, p2, p3, p4;
		p1 = new PolynomialLinkedList(2,3);
		//p1.print();
		p2 = new PolynomialLinkedList(3,2);
		//p2.print();
		p3 = p1.add(p2);
		p1 = new PolynomialLinkedList(1,0);
		p4 = p2.add(p1);
		sum = p3.add(p4);
		// extra credit
		//prod = p3.multiply(p4);
		p3.print();
		p4.print();
		sum.print();
		print(sum.negate());
		//prod.print();
	}
	public static void print(PolynomialLinkedList p){
		if (p.first == null){
			System.out.println("");
			return;
		}
		PNode temp = p.first;
		String ans = "";
		while (temp != null){
			if (temp.getCoe() > 0) {
				if (temp != p.first) ans = ans + " + ";
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
}
