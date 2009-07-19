package gears3;

import junit.framework.*;
import java.util.*;

import gears3.Combinations.*;

public class TestCombinations extends TestCase {

	public Integer I(int i){
		return new Integer(i);
	}
	
	public void testMultiplier(){
		
		List l = new LinkedList();
		l.add(I(1));
		l.add(I(2));
		l.add(I(3));
		
		Multiplier m = new Multiplier();
		assertEquals(6,m.multiply(l));
	}
	
	public List L(int ... ints){
		
		List l = new LinkedList ();
		for(int i = 0; i < ints.length; i ++){
			l.add(new Integer(ints[i]));
		}
		return l;
	}

	public void testCombinations(){
		Combinations c = new Combinations(new int[]{1,2,3},2);
		
		Set s = new TreeSet(new Multiplier());
		
		s.add(L(1,2));
		s.add(L(1,3));
		s.add(L(2,3));
		
		assertEquals(s ,c.combinations());
	}	public void testCombinations2(){
		Combinations c = new Combinations(new int[]{1,2,3,4},2);
		
		Set s = new TreeSet(new Multiplier());
		
		s.add(L(1,2));
		s.add(L(1,3));
		s.add(L(1,4));
		s.add(L(2,3));
		s.add(L(2,4));
		s.add(L(3,4));
		
		assertEquals(s ,c.combinations());


		c = new Combinations(new int[]{1,2,3,4},3);
		s = new TreeSet(new Multiplier());
		s.add(L(1,2,3));
		s.add(L(1,2,4));
		s.add(L(1,3,4));
		s.add(L(2,3,4));
		assertEquals(s ,c.combinations());

	}


	
	
}
