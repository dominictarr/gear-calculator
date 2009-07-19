package gears3;

import java.util.*;

public class Multiplier implements Comparator {

	public int multiply(List l){
	Iterator i = l.iterator();
	int prod = 1;
	while(i.hasNext())
		prod = prod * ((Integer)i.next()).intValue();
	return prod;
	}
public int compare(Object _a, Object _b){
	return multiply((List)_a) - multiply((List)_b);
}
}

