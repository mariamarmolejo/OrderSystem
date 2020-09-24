package model;

import java.util.Comparator;

public class NameComparator implements Comparator<Restaurant>{

	@Override
	public int compare(Restaurant o1, Restaurant o2) {
		int comp;
		String n1 = o1.getName();
		String n2 = o2.getName();
		
		comp = n1.compareTo(n2);
		
		return comp;
	}

}