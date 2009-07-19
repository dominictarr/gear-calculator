package gears3;

import junit.framework.*;
import java.util.*;

import gears3.Combinations.*;

public class TestGearGenerator extends TestCase {

	public void testMask(){
		GearGenerator gg = new GearGenerator();
		gg.gears = Combinations.integers(21,20,25,30);

		List l = new LinkedList();
		l.add(new Integer(21));
		l.add(new Integer(20));
		l.add(new Integer(25));
		
		Integer [] mask = new Integer[]{new Integer (30)};
		assertEquals(mask.length,gg.maskGears(l).length);
		assertEquals(mask[0],gg.maskGears(l)[0]);
	}
}
