package gears3;

import java.util.*;

public class GearGenerator{

	public Integer gears[] = Combinations.integers(20,25,30,35,38,40,45,50,55,60,65,70,75);
	public int pairs = 2;
	
	public Integer[] maskGears(List mask){
		Integer[] m = new Integer[gears.length - mask.size()];
		int j = 0;
		Set s = new TreeSet();
		
	//	for(int n = 0; n < mask.length; n++){
	//		s.add(mask[n]);
	//	}
		for(int i = 0; i < gears.length; i++){
			if(!mask.contains(gears[i]))
			m[j++] = gears[i]; 
		}
		return m;
	}
	
	public void getGears2(double ratio, int pairs){
		Combinations c = new Combinations(gears,pairs * 2);
		Collection l = c.combinations();
	}
		double [] ratios;
		List[] bestA;
		List[] bestB;
		
		public GearGenerator(){
			
			ratios = new double[50];
			double inc = 0.1;
			double start = 0;
			int i = 0;
			while(i < ratios.length){
				ratios[i] = start + inc;
				start += inc;
				i++;
			}
			 bestA = new List[ratios.length];
			bestB = new List[ratios.length];
		}
	
		double leadScrew = 3.175;
		
		public double gearRatio(List a, List b){
			Multiplier m = new Multiplier();
			return leadScrew * (double)m.multiply(a)/(double)m.multiply(b);
		}
		
	public void addGearing(List a, List b){
		for(int i = 0; i < ratios.length; i ++){
			if (bestA[i] != null){
				double diff_c = ratios[i] - gearRatio(bestA[i],bestB[i]);
				double diff_n = ratios[i] - gearRatio(a,b);
				if(diff_c < 0)
					diff_c = diff_c*-1;
				if(diff_n < 0)
					diff_n = diff_n*-1;
			
				if(diff_n < diff_c){
					bestA[i] = a;
					bestB[i] = b;
				}
			} else {
				bestA[i] = a;
				bestB[i] = b;
			}
		}
		
	}

	public void printRatios(){
		System.out.println("target	,best	, diff	,[oddGears]/[evenGears]");
		for(int i = 0; i < ratios.length; i ++){
		System.out.println(
			ratios[i] + "	" +
			gearRatio(bestA[i],bestB[i]) + "	" +
			(ratios[i] - gearRatio(bestA[i],bestB[i])) + "	" +
			bestA[i] + "/" + bestB[i]);
		}
	}
	
	public void getGears(double ratio, int pairs){
		Combinations c = new Combinations(gears,pairs);
		List[] combs = (List[])c.combinations().toArray(new List[]{});
	
		Multiplier m = new Multiplier();
		double leadScrew = 3.175;
		for (int i = 0; i < combs.length; i ++){
//			System.out.println(combs[i] + " " + m.multiply((List)combs[i]));

			Combinations d = new Combinations(maskGears(combs[i]),pairs);

			List[] _combs = (List[])d.combinations().toArray(new List[]{});
			
			for (int j = 0; j < _combs.length; j ++){
				//System.out.println(" " + _combs[j] + " " + m.multiply((List)_combs[j]));
				
				double r = (double)m.multiply((List)combs[i])/(double)m.multiply((List)_combs[j]);
				/*System.out.println ("" + r * leadScrew + "	" +
					r + "	" +
					(List)combs[i] + "/" + (List)_combs[j]);
					*/
				addGearing((List)combs[i],(List)_combs[j]);
			}
		
		}
	}

	public static void main(String[] args){
		int a = 2;
		if(args.length > 0){
			a = new Integer(args[0]).intValue();
		}
		GearGenerator gg = new GearGenerator();

		for(int i = 1; i <= a; i ++)
			gg.getGears(0,i);
		gg.printRatios();
	}
}
