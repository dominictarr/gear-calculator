package gears3;

import java.util.*;

public class Combinations {

Integer [] objs;

public static Integer[] integers(int ... ints){
	Integer[] I = new Integer[ints.length];
	
	for(int i = 0; i < ints.length; i ++)
		I[i] = new Integer(ints[i]);
	
	return I;
}

public Combinations (int [] os, int n){
	objs = integers(os);
	combine(n);
}


public Combinations (Integer [] os, int n){
	objs = os;
	combine(n);
}

SortedSet ss = new TreeSet(new Multiplier());

public void combine(int maxL){
	combine(maxL  ,0,0,new LinkedList());
}
public Set combinations(){return ss;}

public void combine(int maxL,int level, int min, LinkedList l){
	if(level >= maxL){
		ss.add(l);
		return;
	}
	for(int i = min; i < objs.length; i ++){
		LinkedList nl = (LinkedList)l.clone();
		nl.add(objs[i]);
		combine(maxL,level + 1, i + 1, nl);
	}
}
}
